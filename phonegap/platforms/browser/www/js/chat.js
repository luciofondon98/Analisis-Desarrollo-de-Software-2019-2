$(document).ready(function() {
    $.ajax({				
        type: "GET",
        url: "http://localhost:8000/v1/mensajeria/getAll",
        success: function(data) {
            console.log("mensajeria");
            for (let i = 0; i < data.length; i++){    
                $("#chat").append('                                                     \
                <div class="card" style="width: 18rem;">                                                       \
                    <div class="card-body">                                              \
                        <h5 class="card-title">'+data[i].cliente+'</h5>        \
                        <p class="card-text">Mensaje: '+ data[i].mensaje+'</p>    \                       \
                    </div>                                                               \
                </div>                                                                   \
            ');    
            }
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
});
});