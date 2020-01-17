$(document).ready(function() {
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/cliente/getAll",
        success: function(data) {
            let id = window.localStorage.getItem("token");
            //console.log("IIIIIIIIIIIIIIIIIIIIIIIID"+id);
            console.log("mis_consultas");
            for (let i = 0; i < data.length; i++){   
                if (id == data[i].id){
                    console.log(i);
                    for (let j = 0; j < data[i].consulta.length; j++){
                        //console.log("xd");
                        if(data[i].consulta[j].estado != "finalizado"){
                            $("#mis_consultas").append('                                                     \
                            <div class="card" style="width: 18rem;">                                                       \
                            <div class="card-header">'+data[i].consulta[j].estado+'</div>\
                                <div class="card-body">                                              \
                                    <h5 class="card-title">'+data[i].consulta[j].titulo+'</h5>         \
                                    <h6 class="card-subtitle mb-2 text-muted">Categoria: '+ data[i].consulta[j].categoria +'</h6>    \
                                    <p class="card-text">Descripción: '+ data[i].consulta[j].descripcion +'</p>    \
                                    <a href="#" id="entrar_chat" class="btn btn-info" onclick="myFunction('+data[i].consulta[j].id+')">Entrar al Chat</a>                        \
                                    <a href="#" class="btn btn-danger text-light" onclick="myFunction3()">Eliminar Consulta</a>\
                                 </div>\
                            </div>\
                        ');
                        }
                    }break;
                }
            }
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
});

function myFunction(id) { // Declare a function
    window.localStorage.setItem("token_consulta", id);
    window.location =  "chat_cliente.html";

  }
  
    function myFunction2() { // Declare a function
        console.log("hola");
        $("#mis_consultas").append('                                                                                                    \
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
            ¿Seguro que quiere eliminar la consulta?                                                                                     \                       \
            </div>                                                                                                                      \
            <div class="modal-footer">                                                                                                  \
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                                    \
                <a href="#" onclick="myFunction3()" type="button" class="btn btn-primary">Confirmar</a>                                                       \
            </div>                                                                                                                      \
            </div>                                                                                                                      \
        </div>                                                                                                                          \
        </div>                                                                                                                          \
        '); 
    }

  function myFunction3() { // Declare a function
    let id = window.localStorage.getItem("token_consulta");
    id = Number(id) + 1 ;
    console.log("id consulta: "+id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8000/v1/consulta/consulta/"+id,
        success: function(data) {
            console.log("Consulta eliminada");
            window.location =  "mis_consultas.html";
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
  }
