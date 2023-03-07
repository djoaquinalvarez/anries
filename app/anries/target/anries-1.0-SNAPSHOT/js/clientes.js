//-----------CARGAMOS EVENTOS EN BOTONES PARA EDITAR LOCALIDAD-------------
$(document).ready(function cargarEventosClicEditar() {
    var table = document.querySelector("#tabla-clientes");
    var botones = table.querySelectorAll(".button-editar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", editarLocalidad);

    }
});

function editarLocalidad(evento) {
    //obtenemos la fila de la tabla que contiene los datos de la localidad seleccionada
    var fila = document.querySelector("#cliente_" + evento.target.id.substring(14,));
    console.log("#cliente_" + evento.target.id.substring(14,));


    //de la tabla, seleccionamos solo aquellos datos que vamos a cargar en los campos
    var datosDeTabla = fila.querySelectorAll(".dato-tabla");

    //obtenemos del formulario los campos que hay que rellenar
    var camposARellenar = document.querySelectorAll(".dato-formulario");

    //obtenemos el boton submit para cambiarle el texto de "Enviar" a "Actualizar"
    var buttonSubmit = document.querySelector("#send-button")
    buttonSubmit.value = "Actualizar";


    //mostramos el boton de cancelar edicion;
    var buttonHidden = document.querySelector("#hidden-button_cancelar");
    buttonHidden.classList.remove("visually-hidden");

    //cambiamos el action del formulario del modo "Registrar" a "Modificar"
    var form = document.querySelector("#formulario-clientes");
    form.action = "/anries/form_modificar-cliente";

    //por cada valor leido de la tabla, cargamos el contenido de texto en el input del form
    for(var i = 0; i < datosDeTabla.length; i++) {
        var datoDeTabla = datosDeTabla[i];
        var campoARellenar = camposARellenar[i];
        //console.log(datoDeTabla.textContent);
        //console.log(campoARellenar);
        console.log(datoDeTabla.textContent);
        campoARellenar.value = datoDeTabla.textContent;
    }
}

//----------CARGAMOS EVENTOS CLICK PARA BOTONES BORRAR EMPLEADO---------------
/*

$(document).ready(function cargarEventosClicBorrar() {
    var table = document.querySelector("#tabla-clientes");
    var botones = table.querySelectorAll(".button-borrar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", borrarEmpleado);

    }
});


function borrarEmpleado(evento) {
    var modal = document.querySelector("#exampleModal");
    var modalBody = modal.querySelector("#modal_body-empleado");
    var inputId = modal.querySelector(".dato-servlet");

    //Buscamos el nombre de la localidad seleccionada
    var fila = document.querySelector("#empleado_" + evento.target.id.substring(14,)); //seleccionamos cada una de las filas de la tabla

    var datosTabla = fila.querySelectorAll(".dato-tabla"); //separamos la fila en campos individuales

    //Modificamos el titulo del modal segun el nombre de la localidad seleccionada
    console.log("¿Está seguro de eliminar al empleado " + datosTabla[1].textContent + " " + datosTabla[2].textContent + "?");
    modalBody.textContent = "¿Está seguro de eliminar a " + datosTabla[1].textContent + " " + datosTabla[2].textContent + " de la lista de empleados?";
    inputId.value = datosTabla[0].textContent;
}
*/

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
    document.querySelector("#formulario-clientes").reset();

}

