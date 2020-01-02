$(document).ready(function(){
    $("#botonconsulta").click(function (e) {
        e.preventDefault();
        let descrip = document.getElementById("descripcionProblema");
        let proble = document.getElementById("problema");
        let categ = document.getElementById("categoria");
        $.ajax({				
                type: "POST",
                url: "http://localhost:8000/v1/consulta/consulta",
                data: JSON.stringify({"tecnico": -1,"cliente": idCliente,"titulo": proble.value,
                "descripcion": descrip.value,"categoria": categ.value}),
                contentType: "application/json",
                dataType: "json",
                success: function(data){
                    console.log("si");
                    window.location.href = "/inicio_cliente.html"
                },
                failure: function() {
                    alert("error")
                    console.log("No");
                }
            });
    });
});