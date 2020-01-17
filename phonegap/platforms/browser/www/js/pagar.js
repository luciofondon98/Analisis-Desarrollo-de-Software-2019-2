/*$(document).ready(function() {
    let id = window.localStorage.getItem("token_consulta");
    $.ajax({
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            $.ajax({				
                type: "POST",
                url: "http://localhost:8000/v1/pago/pago",
                data: JSON.stringify({"tecnico": data.tecnico, "cliente": data.cliente, "consulta": id, "monto": 10}),
                contentType: "application/json",
                dataType: "json",
                success: function(new_data) {
                    console.log("Pago realizado");
                },
                error: function() {
                    console.log("No se ha podido obtener la información");
                }
            });
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
});*/

function myFunction() { // Declare a function
    let id = window.localStorage.getItem("token_consulta");
    let monto = document.getElementById("cantidad_dinero");
    $.ajax({
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            $.ajax({				
                type: "POST",
                url: "http://localhost:8000/v1/pago/pago",
                data: JSON.stringify({"tecnico": data.tecnico, "cliente": data.cliente, "consulta": id, "monto": monto.value}),
                contentType: "application/json",
                dataType: "json",
                success: function(new_data) {
                    console.log("Pago realizado");
                    window.location =  "calificacion.html";
                },
                error: function() {
                    console.log("No se ha podido obtener la información");
                }
            });
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
}