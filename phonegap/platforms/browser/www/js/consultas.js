$(document).ready(function() {
        $.ajax({				
            type: "GET",
            url: "http://localhost:8000/v1/consulta/getAll",
            success: function(data) {
                console.log("consulta");
                let id = window.localStorage.getItem("token");
                //console.log("id es: "+id);
                //console.log(data[0].id);
                for (let i = 0; i < data.length; i++){ 
                    //id = data[i].id;
                    //window.localStorage.setItem("token", id);
                    if(data[i].estado == "nuevo"){
                        $("#consultas").append('                                                     \
                        <div class="card" style="width: 18rem;">                                                       \
                            <div class="card-body">                                              \
                                <h5 class="card-title">Consulta '+data[i].titulo+' Hecha por el usuario de ID '+data[i].cliente+'</h5>         \
                                <h6 class="card-subtitle mb-2 text-muted">Categoria: '+ data[i].categoria +'</h6>    \
                                <p class="card-text">Descripción: '+ data[i].descripcion +'</p>    \
                                <a href="#" id= "aceptar_consulta" class="btn btn-success text-light" data-toggle="modal" data-target="#exampleModal" onclick="myFunction('+data[i].id+')">Aceptar Consulta</a>                            \
                                <a href="#" class="btn btn-danger text-light">Rechazar Consulta</a> \
                            </div>                                                               \
                        </div>                                                                   \
                    ');    
                    }
                    else if(data[i].estado == "pendiente" && data[i].tecnico == id){
                        $("#consultas").append('                                                     \
                        <div class="card" style="width: 18rem;">                                                       \
                            <div class="card-body">                                              \
                                <h5 class="card-title">Consulta '+data[i].titulo+' Hecha por el usuario de ID '+data[i].cliente+'</h5>         \
                                <h6 class="card-subtitle mb-2 text-muted">Categoria: '+ data[i].categoria +'</h6>    \
                                <p class="card-text">Descripción: '+ data[i].descripcion +'</p>    \
                                <a href="chat_tecnico.html" id="entrar_chat" class="btn btn-info">Entrar al Chat</a>                        \
                                <a href="#" class="btn btn-danger text-light">Cancelar Consulta</a> \
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

function myFunction(id) { // Declare a function
    //console.log(id);
    window.localStorage.setItem("token_consulta", id);
    $("#consultas").append('                                                                                                        \
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">   \
    <div class="modal-dialog" role="document">                                                                                      \
        <div class="modal-content">                                                                                                 \
        <div class="modal-header">                                                                                                  \
            <h5 class="modal-title" id="exampleModalLabel">Confirmación</h5>                                                        \
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">                                            \
            <span aria-hidden="true">&times;</span>                                                                                 \
            </button>                                                                                                               \
        </div>                                                                                                                      \
        <div class="modal-body">                                                                                                    \
        ¿Seguro que quiere aceptar la consulta?                                                                                     \                       \
        </div>                                                                                                                      \
        <div class="modal-footer">                                                                                                  \
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                                    \
            <a href="chat_tecnico.html" type="button" class="btn btn-primary">Confirmar</a>                                                        \
        </div>                                                                                                                      \
        </div>                                                                                                                      \
    </div>                                                                                                                          \
    </div>                                                                                                                          \
    ');    
}


