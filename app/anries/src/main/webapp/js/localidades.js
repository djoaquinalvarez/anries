//-----------CARGAMOS EVENTOS EN BOTONES PARA EDITAR LOCALIDAD-------------
$(document).ready(function cargarEventosClicEditar() {
    var table = document.querySelector("#tabla-localidades");
    var botones = table.querySelectorAll(".button-editar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", editarLocalidad);

    }
});

function editarLocalidad(evento) {
    //obtenemos la fila de la tabla que contiene los datos de la localidad seleccionada
    var fila = document.querySelector("#localidad_" + evento.target.id.substring(14,));


    //de la tabla, seleccionamos solo aquellos datos que vamos a cargar en los campos
    var datosDeTabla = fila.querySelectorAll(".dato_formulario");
    //obtenemos del formulario los campos que hay que rellenar
    var camposARellenar = document.querySelectorAll(".dato-tabla");
    //obtenemos el boton submit para cambiarle el texto de "Enviar" a "Actualizar"
    var buttonSubmit = document.querySelector("#send-button")
    buttonSubmit.value = "Actualizar";
    //cambiamos el action del formulario del modo "Registrar" a "Modificar"
    var form = document.querySelector("#formulario-localidades");
    form.action = "/anries/form_modificar-localidad";

    //por cada valor leido de la tabla, cargamos el contenido de texto en el input del form
    for(var i = 0; i < datosDeTabla.length; i++) {
        var datoDeTabla = datosDeTabla[i];
        var campoARellenar = camposARellenar[i];
        //console.log(datoDeTabla.textContent);
        //console.log(campoARellenar);
        campoARellenar.value = datoDeTabla.textContent;
    }
}

//----------CARGAMOS EVENTOS CLICK PARA BOTONES BORRAR LOCALIDAD---------------
$(document).ready(function cargarEventosClicEditar() {
    var table = document.querySelector("#tabla-localidades");
    var botones = table.querySelectorAll(".button-borrar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", borrarLocalidad);

    }
});

function borrarLocalidad(evento) {
    console.log("Evento cargado correctamente para el boton " + evento.target.id);
    var modal = document.querySelector("#exampleModal");
    var modalBody = modal.querySelector("#modal_body-localidad");

    //Buscamos el nombre de la localidad seleccionada
    var fila = document.querySelector("#localidad_" + evento.target.id.substring(14,)); //seleccionamos cada una de las filas de la tabla

    var datosTabla = fila.querySelectorAll(".dato_formulario"); //separamos la fila en campos individuales

    modalBody.textContent = "¿Está seguro de eliminar la localidad de " + datosTabla[1].textContent + "?";



    //Modificamos el titulo del modal segun el nombre de la localidad seleccionada
}

