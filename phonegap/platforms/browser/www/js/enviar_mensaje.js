$(document).ready(function(){
    $("#boton_enviar_mensaje").click(function (e) {
        e.preventDefault();
        let id = window.localStorage.getItem("token")
        $.ajax({				
                type: "POST",
                url: "http://localhost:8000/v1/mensajeria/mensajeria",
                data: JSON.stringify({"tecnico": 4,"cliente": id ,"mensaje": mensaje.value,
                "consulta": id_consulta}), //id 4 es tecnico fantasma, ESTO CAMBIARLO SE NECESITA EL ID DEL TECNICO
                contentType: "application/json",
                dataType: "json",
                success: function(){
                    console.log(id);
                    console.log(id_consulta);
                    window.location.href ="/chat.html"
                    //window.location.href = "/inicio_cliente.html"
                },
                failure: function() {
                    alert("error")
                    console.log("No");
                }
            });
    });
});    