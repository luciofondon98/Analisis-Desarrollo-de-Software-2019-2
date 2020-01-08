$(document).ready(function() {
        $.ajax({				
            type: "GET",
            url: "http://localhost:8000/v1/consulta/getAll",
            success: function(data) {
                console.log("consulta");
                //console.log(data[0].id);
                for (let i = 0; i < data.length; i++){ 
                    //id = data[i].id;
                    //window.localStorage.setItem("token", id);
   
                    $("#consultas").append('                                                     \
                    <div class="card" style="width: 18rem;">                                                       \
                        <div class="card-body">                                              \
                            <h5 class="card-title">Consulta '+data[i].titulo+' Hecha por el usuario de ID '+data[i].cliente+'</h5>         \
                            <h6 class="card-subtitle mb-2 text-muted">Categoria: '+ data[i].categoria +'</h6>    \
                            <p class="card-text">Descripción: '+ data[i].descripcion +'</p>    \
                            <a href="#" class="btn btn-success text-light" onclick="myFunction('+data[i].id+')">Aceptar Consulta</a>                            \
                            <a href="#" class="btn btn-danger text-light">Rechazar Consulta</a>                         \
                        </div>                                                               \
                    </div>                                                                   \
                ');    
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
    $("#titulo").append('                                                     \
    <a href="chat.html" class="btn btn-warning text-dark">¿Confirmar consulta?</a>                            \
    ');    

  }

