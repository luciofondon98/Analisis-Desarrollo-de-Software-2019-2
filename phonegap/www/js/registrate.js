$(document).ready(function() {
    $("#botonregistrar").click(function (e) {
        e.preventDefault();
        var nombre_registro = document.getElementById("nombre_registro");
        var email_registro = document.getElementById("email_registro");
        var pass_registro = document.getElementById("pass_registro");
        var tipo_usuario = document.getElementById("tipo_usuario");
        console.log(tipo_usuario.value);
        if(tipo_usuario.value=="Usuario"){
            console.log("us");
            registrarCliente(nombre_registro.value,email_registro.value,pass_registro.value)
        } 
        
        else{
            console.log("tec");      
            registrarTecnico(nombre_registro,email_registro,pass_registro)
        }
    });
  });

//------------------------------------------------------------------------/

  function registrarCliente(nombre_registro, email_registro, pass_registro){
    $.ajax({				
        type: "POST",
        url: "http://localhost:8000/v1/cliente/cliente",
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

//------------------------------------------------------------------------/


  function registrarTecnico(nombre_registro, email_registro, pass_registro){
    $.ajax({				
        type: "POST",
        url: "http://localhost:8000/v1/tecnico/tecnico",
        data: JSON.stringify({"nombre": nombre_registro,"correo": email_registro.value,"contrasena":pass_registro.value,}),
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


