$(document).ready(function() {
    let id = window.localStorage.getItem("token_consulta");
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            //console.log(data.titulo);
            console.log("mensajeria");
            id_tec = window.localStorage.getItem("token_tec");
            //console.log("id consulta: "+id);
            console.log(id_tec);
            if(data.tecnico == 1){
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8000/v1/consulta/consulta",
                    data: JSON.stringify({"tecnico": id_tec,"cliente": data.cliente ,"titulo": data.titulo,
                    "descripcion": data.descripcion, "estado":"pendiente", "categoria": data.categoria}),
                    contentType: "application/json",
                    dataType: "json",
                    success: function(new_data) {
                        console.log("se creo la nueva consulta");
                        $.ajax({
                            type: "DELETE",
                            url: "http://localhost:8000/v1/consulta/consulta/"+data.id,
                            success: function(new_new_data) {
                                console.log("se borro la consulta anterior");
                            }
                        })
                        for (let i = 0; i < new_data.mensajeria.length; i++){
                            $("#chat_tecnico").append('                                                     \
                            <div class="card" style="width: 18rem;">                                               \
                                <div class="card-body">                                              \
                                    <h5 class="card-title">'+new_data.mensajeria[i].destinatario+'</h5>        \
                                    <p class="card-text">Mensaje: '+ new_data.mensajeria[i].mensaje+'</p>    \                       \
                                </div>                                                               \
                            </div>                                                                   \
                        ');    
                    }
                        //borrar la consulta
                    },
                    error: function() {
                        console.log("No se ha podido obtener la información");
                    }
                });
            }
            
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
});
});