$(document).ready(function(){
    $("#boton_enviar_mensaje_tecnico").click(function (e) {
        e.preventDefault();
        let id = window.localStorage.getItem("token_tec")
        let id_consulta = window.localStorage.getItem("token_consulta")
        let mensaje = document.getElementById("mensaje");
        //console.log("tecnicoo consulta"+id+id_consulta);
        //console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaa: "+id);
        $.ajax({
            type: "GET",
            url: "http://localhost:8000/v1/consulta/consulta?id="+id_consulta,
            success: function(data){
                $.ajax({				
                        type: "POST",
                        url: "http://localhost:8000/v1/mensajeria/mensajeria",
                        data: JSON.stringify({"tecnico": id,"cliente": data.cliente ,"mensaje": mensaje.value,
                        "consulta": id_consulta, "destinatario": data.cliente}), //id 1 es tecnico fantasma, ESTO CAMBIARLO SE NECESITA EL ID DEL TECNICO
                        contentType: "application/json",
                        dataType: "json",
                        success: function(){
                            //console.log(id);
                            //console.log("HOOOMEEEEEEROOOOOOOO");
                            window.location.href ="/chat_tecnico.html"
                            //window.location.href = "/inicio_cliente.html"
                        },
                        failure: function() {
                            alert("error")
                            console.log("No");
                        }
                    });
            },
            failure: function() {
                alert("error")
                console.log("No");
            }
            });
    });
});    