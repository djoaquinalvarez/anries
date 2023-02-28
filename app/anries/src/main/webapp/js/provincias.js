//-----------CARGAMOS EVENTOS EN BOTONES PARA EDITAR LOCALIDAD-------------
$(document).ready(function cargarEventosClicEditar() {
    var table = document.querySelector("#tabla-provincias");
    var botones = table.querySelectorAll(".button-editar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", editarProvincia);

    }
});

function editarProvincia(evento) {
    //obtenemos la fila de la tabla que contiene los datos de la localidad seleccionada
    var fila = document.querySelector("#provincia_" + evento.target.id.substring(14,));


    //de la tabla, seleccionamos solo aquellos datos que vamos a cargar en los campos
    var datosDeTabla = fila.querySelectorAll(".dato-tabla");

    //obtenemos del formulario los campos que hay que rellenar
    var camposARellenar = document.querySelectorAll(".campo-formulario");

    //obtenemos el boton submit para cambiarle el texto de "Enviar" a "Actualizar"
    var buttonSubmit = document.querySelector("#send-button")
    buttonSubmit.value = "Actualizar";


    //mostramos el boton de cancelar edicion;
    var buttonHidden = document.querySelector("#hidden-button_cancelar");
    buttonHidden.classList.remove("visually-hidden");

    //cambiamos el action del formulario del modo "Registrar" a "Modificar"
    var form = document.querySelector("#formulario-provincias");
    form.action = "/anries/form_modificar-provincia";

    //por cada valor leido de la tabla, cargamos el contenido de texto en el input del form
    for(var i = 0; i < datosDeTabla.length; i++) {
        var datoDeTabla = datosDeTabla[i];
        var campoARellenar = camposARellenar[i];
        //console.log(datoDeTabla.textContent);
        //console.log(campoARellenar);
        campoARellenar.value = datoDeTabla.textContent;
    }
}

//----------CARGAMOS EVENTOS CLICK PARA BOTONES BORRAR PROVINCIA---------------
$(document).ready(function cargarEventosClicBorrar() {
    var table = document.querySelector("#tabla-provincias");
    var botones = table.querySelectorAll(".button-borrar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", borrarProvincia);

    }
});

function borrarProvincia(evento) {
    console.log("hol;is");
    var modal = document.querySelector("#exampleModal");
    var modalBody = modal.querySelector("#modal_body-provincia");
    var inputId = modal.querySelector(".dato-servlet");

    //Buscamos el nombre de la localidad seleccionada
    var fila = document.querySelector("#provincia_" + evento.target.id.substring(14,)); //seleccionamos cada una de las filas de la tabla
    console.log(fila);
    var datosTabla = fila.querySelectorAll(".dato-tabla"); //separamos la fila en campos individuales
    console.log(datosTabla);
    //Modificamos el titulo del modal segun el nombre de la localidad seleccionada
    modalBody.textContent = "¿Está seguro de eliminar la provincia de " + datosTabla[1].textContent + "?";
    inputId.value = datosTabla[0].textContent;
}

$(document).ready(function cargarEventoBotonCancelarEdicion() {
    var buttonHidden = document.querySelector("#hidden-button_cancelar");
    //console.log(botones);
    buttonHidden.addEventListener("click", cancelarEdicion);
});

function cancelarEdicion() {
    //Ocultamos el boton de cancelar edicion
    var buttonHidden = document.querySelector("#hidden-button_cancelar");
    buttonHidden.classList.add("visually-hidden");

    //obtenemos el boton submit para cambiarle el texto de "Actualizar" a "Enviar"
    var buttonSubmit = document.querySelector("#send-button")
    buttonSubmit.value = "Enviar";

    //vaciamos los campos del formulario]
    document.querySelector("#formulario-provincias").reset();

}

