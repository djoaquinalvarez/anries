//-----------CARGAMOS EVENTOS EN BOTONES PARA EDITAR LOCALIDAD-------------

$(document).ready(function cargarEventosClicEditar() {
    var table = document.querySelector("#tabla-articulos");
    var botones = table.querySelectorAll(".button-editar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", editarArticulo);

    }
});

function editarArticulo(evento) {
    //obtenemos la fila de la tabla que contiene los datos de la localidad seleccionada
    var fila = document.querySelector("#articulo_" + evento.target.id.substring(14,));
    console.log("#articulo_" + evento.target.id.substring(14,));


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
    var form = document.querySelector("#formulario-articulos");
    form.action = "/anries/form_modificar-articulo";

    //por cada valor leido de la tabla, cargamos el contenido de texto en el input del form
    for(var i = 0; i < datosDeTabla.length; i++) {
        var datoDeTabla = datosDeTabla[i];
        var campoARellenar = camposARellenar[i];
        //console.log(datoDeTabla.textContent);
        //console.log(campoARellenar);
        console.log("En la tabla hay: " + datoDeTabla.textContent);
        campoARellenar.value = datoDeTabla.textContent;
        console.log("El input queda en: " + campoARellenar.value);
    }
}

//----------CARGAMOS EVENTOS CLICK PARA BOTONES BORRAR EMPLEADO---------------
/*

$(document).ready(function cargarEventosClicBorrar() {
    var table = document.querySelector("#tabla-articulos");
    var botones = table.querySelectorAll(".button-borrar");
    //console.log(botones);
    for(var i = 0; i < botones.length; i++){
        //console.log(botones[i]);
        botones[i].addEventListener("click", borrarArticulo);

    }
});


function borrarArticulo(evento) {
    var modal = document.querySelector("#exampleModal");
    var modalBody = modal.querySelector("#modal_body-articulo");
    var inputId = modal.querySelector(".dato-servlet");

    //Buscamos el nombre de la localidad seleccionada
    var fila = document.querySelector("#cliente_" + evento.target.id.substring(14,)); //seleccionamos cada una de las filas de la tabla

    var datosTabla = fila.querySelectorAll(".dato-tabla"); //separamos la fila en campos individuales

    //Modificamos el titulo del modal segun el nombre de la localidad seleccionada
    modalBody.textContent = "¿Está seguro de eliminar a " + datosTabla[1].textContent + " " + datosTabla[2].textContent + " de la lista de clientes?";
    inputId.value = datosTabla[0].textContent;
}*/


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
    document.querySelector("#formulario-articulos").reset();
 }

    $(document).ready(function cargarEventoCampoPrecio() {
        var form = document.querySelector("#formulario-articulos");
        var campo = form.querySelector("#costoCompra");
        //console.log(botones);
        campo.addEventListener("keyup", calcularPrecioArticulo);
    });

    $(document).ready(function cargarEventoCampoSelectMarcas() {
            var form = document.querySelector("#formulario-articulos");
            var campo = form.querySelector("#marca");
            //console.log(botones);
            campo.addEventListener("change", calcularPrecioArticulo);
        });

function calcularPrecioArticulo(evento) {
    var selectMarcas = document.querySelector("#marca");
    var indiceMarcaSeleccionada = selectMarcas.selectedIndex;

    var optionMarcaSeleccionada = selectMarcas.options[indiceMarcaSeleccionada];
    if(optionMarcaSeleccionada.textContent != "Seleccione la marca del articulo") {
        var idMarcaSeleccionada = optionMarcaSeleccionada.value;

        var gananciaMarca = document.querySelector("#ganancia-" + idMarcaSeleccionada).value;

        var costoCompra = document.querySelector("#costoCompra").value;

        var inputPrecioVenta = document.querySelector("#precioPorUnidad");
        if(gananciaMarca != 0 && costoCompra != 0) {
            inputPrecioVenta.value = (Number(costoCompra) + Number(((costoCompra*gananciaMarca)/100)));
        }
    }

}

    $(document).ready(function cargarEventoBotonEditarPrecio() {
            var form = document.querySelector("#formulario-articulos");
            var boton = form.querySelector("#button_editar-precio");
            //console.log(botones);
            boton.addEventListener("click", editarPrecio);
            console.log("verga");
    });

    function editarPrecio() {
        var form = document.querySelector("#formulario-articulos");
        var campoPrecio = form.querySelector("#precioPorUnidad");
        campoPrecio.removeAttribute("readonly");
        campoPrecio.focus();
        console.log("holis");

        var boton = form.querySelector("#button_editar-precio");
        boton.value = "Restablecer";

        boton.removeEventListener("click", editarPrecio);
        boton.addEventListener("click", restablecerPrecio);
    }

    function restablecerPrecio() {
        var form = document.querySelector("#formulario-articulos");
        var boton = form.querySelector("#button_editar-precio");
        var campoPrecio = form.querySelector("#precioPorUnidad");
        campoPrecio.setAttribute("readonly", "");

        boton.value = "Editar";
        console.log("holis ahre");
        calcularPrecioArticulo();

        boton.removeEventListener("click", restablecerPrecio);
        boton.addEventListener("click", editarPrecio);
    }

