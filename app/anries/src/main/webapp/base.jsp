<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="http://localhost:8080/anries">ANRIES</a>
        <div class="navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="http://localhost:8080/anries">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Reportes</a>
                </li>
                <li class="nav-item dropdown disabled">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Opciones
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item disabled" href="#">Modo oscuro</a></li>
                        <li><a class="dropdown-item disabled" href="#">Configuración</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item disabled" href="#">Cerrar sesión</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<aside class="navbar bg-body-tertiary position-absolute top-0 end-0 me-3">
    <button class="navbar-toggler" id="buttonNavbarAction" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasNavbarLabel">MENU</h5>
            <button type="button" class="btn-close me-1" id="button-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                <ul class="list-unstyled">
                    <li class="ps-3"><a href="#" class="nav-link btn btn-secondary text-light border border-1 border-dark-subtle disabled">Mi Cuenta</a></li>
                </ul>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Localidades
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="http://localhost:8080/anries/form_localidades.jsp">Registrar nueva localidad</a></li>
                        <li><a class="dropdown-item disabled" href="#">Modificar localidad existente</a></li>
                        <li><a class="dropdown-item disabled" href="#">Eliminar localidad</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item disabled" href="#">Visualizar localidades registradas</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Provincias
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="http://localhost:8080/anries/form_provincia.jsp">Registrar nueva provincia</a></li>
                        <li><a class="dropdown-item disabled" href="#">Modificar provincia existente</a></li>
                        <li><a class="dropdown-item disabled" href="#">Eliminar provincia</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item disabled" href="#">Visualizar provincias registradas</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Empleados
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="http://localhost:8080/anries/form_empleado.jsp">Registrar nuevo empleado</a></li>
                        <li><a class="dropdown-item disabled" href="#">Modificar empleado existente</a></li>
                        <li><a class="dropdown-item disabled" href="#">Eliminar empleado</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item disabled" href="#">Visualizar empleados registrados</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Clientes
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="http://localhost:8080/anries/form_cliente.jsp">Registrar nuevo cliente</a></li>
                        <li><a class="dropdown-item disabled" href="#">Modificar cliente existente</a></li>
                        <li><a class="dropdown-item disabled" href="#">Eliminar cliente</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item disabled" href="#">Visualizar clientes registrados</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Articulos
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="http://localhost:8080/anries/form_articulo.jsp">Registrar nuevo articulo</a></li>
                        <li><a class="dropdown-item disabled" href="#">Modificar articulo existente</a></li>
                        <li><a class="dropdown-item disabled" href="#">Eliminar articulo</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item disabled" href="#">Visualizar articulos registrados</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- scripts -->
    <script src="./js/navbar.js"></script>
</aside>
