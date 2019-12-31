var idCliente = 0;
$(document).ready(function() {
    $("#botoningresar").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: "http://localhost:8000/v1/cliente/getAll",
            success: function(data) {
                console.log("si");
                let pass = document.getElementById("contrasena_usuario");
                let correo = document.getElementById("email_usuario");
                for (let i = 0; i < data.length; i++){ 
                    if (data[i].contrasena == pass.value){
                        if(data[i].correo == correo.value){
                            idCliente = data[i].id;
                        }
                    }              
                }
                if(idCliente == 0) {
                    alert("Cliente no registrado");
                }
                else window.location.href = "/inicio.html";
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });
        return false;
    });
  });


