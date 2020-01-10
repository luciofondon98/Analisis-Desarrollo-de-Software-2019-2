$(document).ready(function() {
    let id = window.localStorage.getItem("token_consulta");
    console.log("iiiiiiddddddddd = "+id);
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            console.log("mensajeria");
            id_tec = window.localStorage.getItem("token_tec");
            //console.log("id consulta: "+id);
            //console.log(id_tec);
            if(data.tecnico == 1){
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8000/v1/consulta/consulta",
                    data: JSON.stringify({"tecnico": id_tec,"cliente": data.cliente ,"titulo": data.titulo,
                    "descripcion": data.descripcion, "estado":"pendiente", "categoria": data.categoria}),
                    contentType: "application/json",
                    dataType: "json",
                    success: function(new_data) {
                        let h = data.id +1;
                        window.localStorage.setItem("token_consulta", h);
                        //console.log("se creo la nueva consulta");
                        $.ajax({
                            type: "DELETE",
                            url: "http://localhost:8000/v1/consulta/consulta/"+data.id,
                            success: function(new_new_data) {
                                //console.log("se borro la consulta anterior");
                            }
                        })
                    },
                    error: function() {
                        console.log("No se ha podido obtener la información");
                    }
                });
            }
            console.log("id , tecnico, cliente: "+data.id+data.tecnico+data.cliente);
            for (let i = 0; i < data.mensajeria.length; i++){
                if(data.mensajeria[i].destinatario == data.cliente){//der
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
                else{//izq
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