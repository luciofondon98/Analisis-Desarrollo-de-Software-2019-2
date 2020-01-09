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
                        window.localStorage.setItem("token_consulta", new_data.id);
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
                    $("#chat_cliente").append('                                                     \
                    <div class="card" style="width: 18rem;">                                               \
                        <div class="card-body">                                              \
                            <h5 class="card-title"> derecha de tecnico para cliente '+data.mensajeria[i].destinatario+'</h5>        \
                            <p class="card-text">Mensaje: '+ data.mensajeria[i].mensaje+'</p>    \                       \
                        </div>                                                               \
                    </div>                                                                   \
                ');    
                }
                else{//izq
                    $("#chat_tecnico").append('                                                     \
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