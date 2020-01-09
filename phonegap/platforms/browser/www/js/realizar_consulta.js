$(document).ready(function(){
    $("#botonconsulta").click(function (e) {
        e.preventDefault();
        let descrip = document.getElementById("descripcionProblema");
        let proble = document.getElementById("problema");
        let categ = document.getElementById("categoria");
        let id = window.localStorage.getItem("token")
        $.ajax({				
                type: "POST",
                url: "http://localhost:8000/v1/consulta/consulta",
                data: JSON.stringify({"tecnico": 1,"cliente": id ,"titulo": proble.value,
                "descripcion": descrip.value,"estado":"nuevo","categoria": categ.value}), //id 1 es tecnico fantasma
                contentType: "application/json",
                dataType: "json",
                success: function(){
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