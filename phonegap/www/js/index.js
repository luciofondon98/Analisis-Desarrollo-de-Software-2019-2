var id = 0;

$(document).ready(function() {
    $("#botoningresar").click(function (e) {
        e.preventDefault();
        let tipo_usuario = document.getElementById("tipo_usuario");
        var email_usuario = document.getElementById("email_usuario");
        var pass_usuario = document.getElementById("contrasena_usuario");
        console.log(tipo_usuario.value);
        if(tipo_usuario.value=="Usuario"){
            console.log("us");
            loguearCliente(id,email_usuario.value,pass_usuario.value);
        } 
        
        else{
            console.log("tec");
            loguearTecnico(id,email_usuario.value,pass_usuario.value);
        }
    });
  });

  function loguearCliente(id,email_usuario, contrasena_usuario){
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/cliente/getAll",
        success: function(data) {
            console.log("si");
            for (let i = 0; i < data.length; i++){ 
                if (data[i].contrasena == contrasena_usuario){
                    if(data[i].correo == email_usuario){
                        console.log(data[i].id)
                        id = data[i].id;
                        window.localStorage.setItem("token", id)
                    }
                }              
            }
            if(id == 0) {
                alert("Cliente no registrado");
            }
            else window.location.href = "/inicio_cliente.html";
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
  }

//------------------------------------------------------------------------/


  function loguearTecnico(id,email_usuario, contrasena_usuario){
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/tecnico/getAll",
        success: function(data) {
            console.log("si");
            for (let i = 0; i < data.length; i++){ 
                if (data[i].contrasena == contrasena_usuario){
                    if(data[i].correo == email_usuario){
                        console.log(data[i].id)
                        id = data[i].id;
                    }
                }              
            }
            if(id == 0) {
                alert("Tecnico no registrado");
            }
            else window.location.href = "/inicio_tecnico.html";
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
  }




