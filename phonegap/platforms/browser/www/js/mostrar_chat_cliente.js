$(document).ready(function() {
    let id = window.localStorage.getItem("token_consulta");
    console.log("iiiiiiddddddddd = "+id);
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            let id = window.localStorage.getItem("token_consulta");
            console.log("mensajeria");
            console.log(id);
            /*for (let i = 0; i < data.length; i++){
                if(data[i].consulta == id){
                    $("#chat_cliente").append('                                                     \
                    <div class="card" style="width: 18rem;">                                               \
                        <div class="card-body">                                              \
                            <h5 class="card-title">'+data[i].destinatario+'</h5>        \
                            <p class="card-text">Mensaje: '+ data[i].mensaje+'</p>    \                       \
                        </div>                                                               \
                    </div>                                                                   \
                ');    
                }    
            }*/

            for (let i = 0; i < data.mensajeria.length; i++){
                if(data.mensajeria[i].destinatario == data.cliente){//der
                    $("#chat_tecnico").append('                                                     \
                    <div class="card" style="width: 18rem;">                                               \
                        <div class="card-body">                                              \
                        <div class=“row”>                                       \
                                <h5 class="card-title"> derecha de tecnico para cliente '+data.mensajeria[i].destinatario+'</h5>        \
                                <p class="card-text">Mensaje: '+ data.mensajeria[i].mensaje+'</p>    \                       \
                            </div>                                                               \
                        </div>                                      \
                    </div>                                                                   \
                ');    
                }
                else{//izq
                    $("#chat_cliente").append('                                                     \
                    <div class="card" style="width: 18rem;">                                               \
                        <div class="card-body">                                              \
                            <h5 class="card-title">izquierda de cliente para tecnico '+data.mensajeria[i].destinatario+'</h5>        \
                            <p class="card-text">Mensaje: '+ data.mensajeria[i].mensaje+'</p>    \                       \
                        </div>                                                               \
                    </div>                                                                   \
                ');
                }
        }
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
});
});