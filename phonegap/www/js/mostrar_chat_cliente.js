$(document).ready(function() {
    let id = window.localStorage.getItem("token_consulta");
    console.log("iiiiiiddddddddd = "+id);
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            let id = window.localStorage.getItem("token_consulta");
            console.log("mensajeria");
            //console.log(id);
            for (let i = 0; i < data.mensajeria.length; i++){
                if(data.mensajeria[i].destinatario == data.cliente){//izq
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:8000/v1/tecnico/tecnico?id="+data.mensajeria[i].tecnico,
                        success: function(new_data) {
                            $("#chat_tecnico").append('                                                     \
                            <div class="card" style="width: 18rem;">                                               \
                                <div class="card-body">                                              \
                                <div class=“row”>                                       \
                                        <h5 class="card-title">'+new_data.nombre+'</h5>        \
                                        <p class="card-text">Mensaje: '+ data.mensajeria[i].mensaje+'</p>    \                       \
                                    </div>                                                               \
                                </div>                                      \
                            </div>                                                                   \
                        ');
                        }
                    }),   
                    console.log(); 
                }
                else{//der
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:8000/v1/cliente/cliente?id="+data.mensajeria[i].cliente,
                        success: function(new_data) {
                            $("#chat_cliente").append('                                                     \
                            <div class="card" style="width: 18rem;">                                               \
                                <div class="card-body">                                              \
                                    <h5 class="card-title">'+new_data.nombre+'</h5>        \
                                    <p class="card-text">Mensaje: '+ data.mensajeria[i].mensaje+'</p>    \                       \
                                </div>                                                               \
                            </div>                                                                   \
                        ');
                        }
                    }),
                    console.log();
                }
        }
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
});
});