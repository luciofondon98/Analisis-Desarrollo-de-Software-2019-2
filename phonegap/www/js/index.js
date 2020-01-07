var idCliente = 0;
var url_inicio = "";
var url_api = "";

$(document).ready(function() {
    $("#botoningresar").click(function (e) {

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
            url_inicio = "/inicio_tecnico.html"
        
        }
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: url_api,
            success: function(data) {
                console.log("si");
                let pass = document.getElementById("contrasena_usuario");
                let correo = document.getElementById("email_usuario");
                for (let i = 0; i < data.length; i++){ 
                    if (data[i].contrasena == pass.value){
                        if(data[i].correo == correo.value){
                            console.log(data[i].id)
                            idCliente = data[i].id;
                        }
                    }              
                }
                if(idCliente == 0) {
                    alert("Cliente no registrado");
                }
                else window.location.href = url_inicio;
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });
        return false;
    });
  });


