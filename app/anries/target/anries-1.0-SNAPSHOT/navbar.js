//EVENTOS ESCUCHADORES DE LOS BOTONES
var buttonMenuNavbar = document.querySelector("#buttonNavbarAction");
var buttonCloseMenuNavbar = document.querySelector("#button-close")

$(document).ready(function () {
    buttonMenuNavbar.addEventListener("click",abrirMenu);
    buttonCloseMenuNavbar.addEventListener("click", cerrarMenu);
});

function abrirMenu() {
    console.log("Me estoy ejecutando bien");
    navbarSection = document.querySelector("#offcanvasNavbar");
    navbarSection.classList.toggle("show");
    navbarSection.classList.toggle("text-bg-dark");
    navbarSection.setAttribute('arial-modal', 'true');
    navbarSection.setAttribute('role', 'dialog');
}

function cerrarMenu() {
    navbarSection.classList.toggle("show");
    navbarSection.classList.toggle("text-bg-dark");
    navbarSection.setAttribute('arial-modal', '');
    navbarSection.setAttribute('role', '');
}
