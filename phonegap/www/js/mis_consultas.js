$(document).ready(function() {
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/cliente/getAll",
        success: function(data) {
            let id = window.localStorage.getItem("token");
            //console.log(id);
            console.log("mis_consultas");
            for (let i = 0; i < data.length; i++){   
                if (id == data[i].id){
                    console.log(i);
                    for (let j = 0; j < data[i].consulta.length; j++){
                        //console.log("xd");
                        $("#mis_consultas").append('                                                     \
                        <div class="card" style="width: 18rem;">                                                       \
                            <div class="card-body">                                              \
                                <h5 class="card-title">Consulta '+data[i].consulta[j].titulo+'</h5>         \
                                <h6 class="card-subtitle mb-2 text-muted">Categoria: '+ data[i].consulta[j].categoria +'</h6>    \
                                <p class="card-text">Descripción: '+ data[i].consulta[j].descripcion +'</p>    \
                                <a href="#" class="btn btn-success text-light" onclick="myFunction('+data[i].consulta[j].id+')">agarrar id</a>\
                                <a href="chat_cliente.html" id="entrar_chat" class="btn btn-info">Entrar al Chat</a>                        \
                                <a href="#" class="btn btn-danger text-light">Eliminar Consulta</a>\
                             </div>\
                        </div>\
                    ');
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
    console.log(id);
    window.localStorage.setItem("token_consulta", id);


  }
