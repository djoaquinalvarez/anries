<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
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

    <!-- CUERPO DEL ARCHIVO HTML-->
    <div id="navbar-template"></div>
    <h3 class="mt-5 ms-5 mb-4">Formulario de Empleados</h3>

    <div class="d-flex flex-row ms-5 me-5">
        <form action="/anries/form_registro-empleado" id="formulario-empleados" method="post" class="w-50 d-inline-block">
            <input type="hidden" class="dato-tabla" name="id" value="">
            <div class="mb-4 ms-4">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" name="nombre" id="nombre" class="form-control w-75 mb-3 dato-tabla" placeholder="Inserte el nombre del empleado" value="${param.nombre}">
                <%
                    if(errores != null && errores.containsKey("nombre")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombre") + "</small>");
                }%>

                <label for="apellido" class="form-label">Apellido</label>
                <input type="text" name="apellido" id="apellido" class="form-control w-75 mb-3 dato-tabla" placeholder="Inserte el apellido del empleado" value="${param.apellido}">
                <%
                    if(errores != null && errores.containsKey("apellido")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("apellido") + "</small>");
                }%>

                <label for="direccion" class="form-label">Direccion</label>
                <input type="text" name="direccion" id="direccion" class="form-control w-75 mb-3 dato-tabla" placeholder="Inserte una direccion" value="${param.direccion}">
                <%
                    if(errores != null && errores.containsKey("direccion")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("direccion") + "</small>");
                }%>

                <label for="dni" class="form-label">Numero de DNI</label>
                <input type="text" name="dni" id="dni" class="form-control w-75 mb-3 dato-tabla" placeholder="Inserte el DNI del empleado" value="${param.dni}">
                <%
                    if(errores != null && errores.containsKey("dni")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("dni") + "</small>");
                }%>

                <label for="fechaNacimiento" class="form-label">Fecha de nacimiento</label>
                <input type="text" name="fechaNacimiento" id="fechaNacimiento" class="form-control w-75 mb-3 dato-tabla" placeholder="Inserte la fecha de nacimiento del empleado" value="${param.fechaNacimiento}">
                <%
                    if(errores != null && errores.containsKey("fechaNacimiento")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("fechaNacimiento") + "</small>");
                }%>

                <label for="numeroTelefono" class="form-label">Numero de telefono</label>
                <input type="text" name="numeroTelefono" id="numeroTelefono" class="form-control w-75 mb-3 dato-tabla" placeholder="Inserte un numero de telefono" value="${param.numeroTelefono}">
                <%
                    if(errores != null && errores.containsKey("numeroTelefono")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("numeroTelefono") + "</small>");
                }%>

                <label for="fechaIngreso" class="form-label">Fecha de ingreso</label>
                <input type="text" name="fechaIngreso" id="fechaIngreso" class="form-control w-75 mb-3 dato-tabla" placeholder="" value="${param.fechaIngreso}">
                <%
                    if(errores != null && errores.containsKey("fechaIngreso")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("fechaIngreso") + "</small>");
                }%>


                <label for="rol" class="form-label">Provincia</label>
                <select id="rol" name="rol" class="form-select w-75 mb-3 dato-tabla" aria-label="Default select example">
                    <option selected>Seleccione el rol del empleado</option>
                    <%
                    List<Rol> roles = new ArrayList<>();
                    DAORol daoRol = new DAORolImpl();
                    roles = daoRol.listar();
                    for(Rol rol: roles) { %>
                        <option value="<%=rol.getNombre()%>"><%=rol.getNombre()%></option>
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
    </div>
</body>

