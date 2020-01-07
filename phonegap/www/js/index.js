var id = 0;
var url_inicio = "";
var url_api = "";

$(document).ready(function() {
    $("#botoningresar").click(function (e) {
        e.preventDefault();
        let tipo_usuario = document.getElementById("tipo_usuario");
        console.log(tipo_usuario.value);
        if(tipo_usuario.value=="Usuario"){
            console.log("si");

            url_api = "http://localhost:8000/v1/cliente/getAll";
            url_inicio = "/inicio_cliente.html"
        } 
        
        else{
            console.log("si");

            url_api = "http://localhost:8000/v1/tecnico/getAll";
           
        
        }
    });
  });

  function loguearCliente(id,email_registro, pass_registro){
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/cliente/getAll",
        success: function(data) {
            console.log("si");
            for (let i = 0; i < data.length; i++){ 
                if (data[i].contrasena == pass_registro){
                    if(data[i].correo == email_registro){
                        console.log(data[i].id)
                        id = data[i].id;
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


  function registrarTecnico(idCliente,email_registro, pass_registro){
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/tecnico/tecnico",
        data: JSON.stringify({"nombre": nombre_registro,"correo": email_registro,"contrasena":pass_registro}),
        contentType: "application/json",
        dataType: "json",
        success: function(){
            alert("Te haz registrado correctamente")
            window.location.href = "/index.html"
        },
        failure: function() {
            alert("error")
        }
    });
  }




