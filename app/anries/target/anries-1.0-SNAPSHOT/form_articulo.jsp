<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOArticuloImpl"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOMarcaImpl"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOUnidadMedidaImpl"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOArticulo"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOMarca"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOUnidadMedida"%>
<%@page import="org.joaquinalvarez.anries.model.Articulo"%>
<%@page import="org.joaquinalvarez.anries.model.Marca"%>
<%@page import="org.joaquinalvarez.anries.model.UnidadMedida"%>
<%
    Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");
    String confirmacion = (String)request.getAttribute("confirmacion");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrar Articulo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- Funcionalidad de botones de la tabla -->
    <script src="./js/articulos.js"></script>
    <!-- Cargamos HTML base -->
    <script>
         $(function(){
            $("#navbar-template").load("./base.jsp");
         });
    </script>

    <!-- MODAL POPUP PARA CONFIRMACION DE ELIMINACION DE LOCALIDAD-->
    <!-- Button trigger modal -->


    <!-- CUERPO DEL ARCHIVO HTML-->
    <div id="navbar-template"></div>
    <h3 class="mt-5 ms-5 mb-4">Formulario de Articulos</h3>

    <div class="d-flex flex-row ms-5 me-5">
        <form action="/anries/form_registro-articulo" id="formulario-articulos" method="post" class="w-50 d-inline-block">
            <input type="hidden" class="dato-formulario" name="id" value="">
            <div class="mb-4 ms-4">
                <label for="nombre" class="form-label"><b>Nombre</b></label>
                <input type="text" name="nombre" id="nombre" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte el nombre del articulo" value="${param.nombre}">
                <%
                    if(errores != null && errores.containsKey("nombre")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombre") + "</small>");
                }%>

                <label for="marca" class="form-label"><b>Marca</b></label>
                <select id="marca" name="marca" class="form-select w-75 mb-3 dato-formulario" aria-label="Default select example">
                    <option selected>Seleccione la marca del articulo</option>
                    <%
                    List<Marca> marcas = new ArrayList<>();
                    DAOMarca daoMarca = new DAOMarcaImpl();
                    marcas = daoMarca.listar();
                    for(Marca marca: marcas) { %>
                        <option value="<%=marca.getId()%>"><%=marca.getNombre()%></option>
                    <%}%>
                </select>

                <!--INPUTS PARA COLOCAR EL PORCENTAJE DE GANANCIA DE CADA MARCA EN LA VISTA-->
                <%
                for(Marca marca: marcas) { %>
                    <input type="hidden" value="<%=marca.getPorcentajeGanancia()%>" id="ganancia-<%=marca.getId()%>">
                <%}%>

                <label for="cantidadDisponible" class="form-label"><b>Cantidad disponible</b></label>
                <input type="number" name="cantidadDisponible" id="cantidadDisponible" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte el stock actual del articulo" value="${param.cantidadDisponible}">
                <%
                    if(errores != null && errores.containsKey("cantidadDisponible")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("cantidadDisponible") + "</small>");
                }%>

                <label for="costoCompra" class="form-label"><b>Costo de compra</b></label>
                <input type="tel" name="costoCompra" id="costoCompra" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte el costo de compra del articulo" value="${param.costoCompra}">
                <%
                    if(errores != null && errores.containsKey("costoCompra")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("costoCompra") + "</small>");
                }%>

                <label for="precioPorUnidad" class="form-label"><b>Precio por unidad</b></label>
                <div class="d-flex flex-row w-75  mb-3">
                    <input type="tel" readonly name="precioPorUnidad" id="precioPorUnidad" class="form-control dato-formulario me-2" placeholder="Inserte el precio por unidad del articulo" value="${param.precioPorUnidad}">
                    <input type="button" id="button_editar-precio" class="btn btn-outline-secondary" value="Editar">
                </div>
                <%
                    if(errores != null && errores.containsKey("precioPorUnidad")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("precioPorUnidad") + "</small>");
                }%>

                <label for="unidadDeMedida" class="form-label"><b>Unidad de medida</b></label>
                <select id="unidadDeMedida" name="unidadDeMedida" class="form-select w-75 mb-3 dato-formulario" aria-label="Default select example">
                    <option selected>Seleccione la unidad de medida</option>
                    <%
                    List<UnidadMedida> unidades = new ArrayList<>();
                    DAOUnidadMedida daoUnidadMedida = new DAOUnidadMedidaImpl();
                    unidades = daoUnidadMedida.listar();
                    for(UnidadMedida unidad: unidades) { %>
                        <option value="<%=unidad.getNombre()%>" id="<%=unidad.getId()%>"><%=unidad.getNombre()%></option>
                    <%}%>
                </select>

                <label for="minimaCantidadStock" class="form-label"><b>Cantidad minima de stock permitida</b></label>
                <input type="tel" name="minimaCantidadStock" id="minimaCantidadStock" class="form-control w-75 mb-3 dato-formulario" placeholder="Inserte la cantidad minima de stock" value="${param.cantidadMinimaStock}">
                <%
                    if(errores != null && errores.containsKey("cantidadMinimaStock")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("fechaNacimiento") + "</small>");
                }%>



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
