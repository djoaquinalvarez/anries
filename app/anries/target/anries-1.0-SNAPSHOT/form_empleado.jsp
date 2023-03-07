<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.joaquinalvarez.anries.dao.DAORolImpl"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOEmpleadoImpl"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAORol"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOEmpleado"%>
<%@page import="org.joaquinalvarez.anries.model.Rol"%>
<%@page import="org.joaquinalvarez.anries.model.Empleado"%>
<%
    Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");
    String confirmacion = (String)request.getAttribute("confirmacion");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrar Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- Funcionalidad de botones de la tabla -->
    <script src="./js/empleados.js"></script>
    <!-- Cargamos HTML base -->
    <script>
         $(function(){
            $("#navbar-template").load("./base.jsp");
         });
    </script>

    <!-- MODAL POPUP PARA CONFIRMACION DE ELIMINACION DE LOCALIDAD-->
    <!-- Button trigger modal -->

    <!-- Modal -->
    <form action="/anries/form_eliminar-empleado" method="post" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmar eliminación de empleado</h1>
                    <input type="hidden" class="dato-servlet" name="id" value="">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="modal_body-empleado">
                    ¿Está seguro de borrar a este empleado?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-danger">Borrar</button>
                </div>
            </div>
        </div>
    </form>


    <!-- CUERPO DEL ARCHIVO HTML-->
    <div id="navbar-template"></div>
    <h3 class="mt-5 ms-5 mb-4">Formulario de Empleados</h3>

    <div class="d-flex flex-row ms-5 me-5">
        <form action="/anries/form_registro-empleado" id="formulario-empleados" method="post" class="w-50 d-inline-block">
            <input type="hidden" class="dato-formulario" name="id" value="">
            <div class="mb-4 ms-4">
                <label for="nombre" class="form-label"><b>Nombre</b></label>
                <input type="text" name="nombre" id="nombre" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte el nombre del empleado" value="${param.nombre}">
                <%
                    if(errores != null && errores.containsKey("nombre")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombre") + "</small>");
                }%>

                <label for="apellido" class="form-label"><b>Apellido</b></label>
                <input type="text" name="apellido" id="apellido" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte el apellido del empleado" value="${param.apellido}">
                <%
                    if(errores != null && errores.containsKey("apellido")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("apellido") + "</small>");
                }%>

                <label for="direccion" class="form-label"><b>Direccion</b></label>
                <input type="text" name="direccion" id="direccion" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte una direccion" value="${param.direccion}">
                <%
                    if(errores != null && errores.containsKey("direccion")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("direccion") + "</small>");
                }%>

                <label for="dni" class="form-label"><b>Numero de DNI</b></label>
                <input type="tel" name="dni" id="dni" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte el DNI del empleado" value="${param.dni}">
                <%
                    if(errores != null && errores.containsKey("dni")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("dni") + "</small>");
                }%>

                <label for="numeroTelefono" class="form-label"><b>Numero de telefono</b></label>
                <input type="tel" name="numeroTelefono" id="numeroTelefono" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte un numero de telefono" value="${param.numeroTelefono}">
                <%
                if(errores != null && errores.containsKey("numeroTelefono")) {
                out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("numeroTelefono") + "</small>");
                }%>

                <label for="fechaIngreso" class="form-label"><b>Fecha de ingreso</b></label>
                <input type="date" name="fechaIngreso" id="fechaIngreso" class="form-control w-75 mb-3 dato-formulario" placeholder="" value="${param.fechaIngreso}">
                <%
                if(errores != null && errores.containsKey("fechaIngreso")) {
                out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("fechaIngreso") + "</small>");
                }%>

                <label for="fechaNacimiento" class="form-label"><b>Fecha de nacimiento</b></label>
                <input type="date" name="fechaNacimiento" id="fechaNacimiento" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte la fecha de nacimiento del empleado" value="${param.fechaNacimiento}">
                <%
                    if(errores != null && errores.containsKey("fechaNacimiento")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("fechaNacimiento") + "</small>");
                }%>

                <label for="rol" class="form-label"><b>Rol</b></label>
                <select id="rol" name="rol" class="form-select w-75 mb-3 dato-formulario" aria-label="Default select example">
                    <option selected>Seleccione el rol del empleado</option>
                    <%
                    List<Rol> roles = new ArrayList<>();
                    DAORol daoRol = new DAORolImpl();
                    roles = daoRol.listar();
                    for(Rol rol: roles) { %>
                        <option value="<%=rol.getNombre()%>" id="<%=rol.getId()%>"><%=rol.getNombre()%></option>
                    <%}%>
                </select>

                <!-- Mensaje de confirmacion de registro-->
                <%
                if(confirmacion != null){
                    out.println("<small class='alert alert-success d-block w-75'>" + confirmacion + "</small>");
                }
                %>

                <input type="submit" id="send-button" value="Enviar" class="btn btn-primary mt-2">
                <input type="button" id="hidden-button_cancelar" value="Cancelar" class="btn btn-secondary mt-2 visually-hidden">
            </div>
        </form>

        <div class="vr"></div>
        <table id="tabla-empleados" class="table w-50 me-4 ms-4">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Direccion</th>
                <th scope="col">DNI</th>
                <th scope="col">Telefono</th>
                <th scope="col">Fecha Ingreso</th>
                <th scope="col">Nacimiento</th>
                <th scope="col">Rol</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
            List<Empleado> empleados = new ArrayList<>();
                DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
                empleados = daoEmpleado.listar();
                for(Empleado empleado: empleados) {
                for(Rol rol: roles) {
                if(rol.getId().equals(empleado.getRol())) {
                %>
                <tr id="empleado_<%=empleado.getId()%>">
                    <th class="dato-tabla" scope="row"><%=empleado.getId()%></th>
                    <td class="dato-tabla"><%=empleado.getNombre()%></td>
                    <td class="dato-tabla"><%=empleado.getApellido()%></td>
                    <td class="dato-tabla"><%=empleado.getDireccion()%></td>
                    <td class="dato-tabla"><%=empleado.getDni()%></td>
                    <td class="dato-tabla"><%=empleado.getNumeroTelefono()%></td>
                    <td class="dato-tabla"><%=empleado.getFechaIngreso()%></td>
                    <td class="dato-tabla"><%=empleado.getFechaNacimiento()%></td>
                    <td class="dato-tabla"><%=rol.getNombre()%></td>
                    <td class="d-flex flex-row-reverse flex-shrink-1">
                        <button type="button" id="button_borrar-<%=empleado.getId()%>" class="btn btn-outline-danger btn-sm button-borrar"  data-bs-toggle="modal" data-bs-target="#exampleModal">Borrar</button>
                        <button type="button" id="button_editar-<%=empleado.getId()%>" class="btn btn-outline-success btn-sm button-editar me-2">Editar</button>
                    </td>
                </tr>
                <%}
                }
                }%>
            </tbody>
        </table>

    </div>
</body>

