function myFunction() { // Declare a function
    let id = window.localStorage.getItem("token_consulta");
    let comentario = document.getElementById("descripcionProblema");
    let nota = document.getElementById("categoria");
    $.ajax({
        type: "GET",
        url: "http://localhost:8000/v1/consulta/consulta?id="+id,
        success: function(data) {
            $.ajax({				
                type: "POST",
                url: "http://localhost:8000/v1/calificacion/calificacion",
                data: JSON.stringify({"tecnico": data.tecnico, "cliente": data.cliente, "consulta": id, "nota": nota.value, "comentario": comentario.value}),
                contentType: "application/json",
                dataType: "json",
                success: function(new_data) {
                    console.log("Calificacion realizada");
                    $.ajax({
                        type: "PUT",
                        url: "http://localhost:8000/v1/consulta/consulta",
                        data: JSON.stringify({"id":data.id, "tecnico": data.tecnico, "cliente": data.cliente, "titulo": data.titulo,
                         "descripcion": data.descripcion, "categoria": data.categoria, "estado": "finalizado", "pago": data.pago, "mensajeria":data.mensajeria, "calificacion": data.calificacion}),
                        contentType: "application/json",
                        dataType: "json",
                        success: function(new_data) {
                            window.location =  "inicio_cliente.html";
                        },
                        error: function() {
                            console.log("No se ha podido obtener la información 3");
                        }
                    });
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