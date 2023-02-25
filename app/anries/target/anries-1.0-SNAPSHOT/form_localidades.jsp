<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Optional"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOProvinciaImpl"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOLocalidadImpl"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOProvincia"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOLocalidad"%>
<%@page import="org.joaquinalvarez.anries.model.Provincia"%>
<%@page import="org.joaquinalvarez.anries.model.Localidad"%>
<%
Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");
String confirmacion = (String)request.getAttribute("confirmacion");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrar Localidad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- Funcionalidad de botones de la tabla -->
    <script src="./js/localidades.js"></script>
    <!-- Cargamos HTML base -->
    <script>
         $(function(){
         $("#navbar-template").load("./base.jsp");
         });
    </script>

    <!-- CUERPO DEL ARCHIVO HTML-->
    <div id="navbar-template"></div>
    <h3 class="mt-5 ms-5 mb-4">Formulario de Localidades</h3>

    <div class="d-flex flex-row ms-5 me-5">
        <form action="/anries/form_registro-localidad" id="formulario-localidades" method="post" class="w-50 d-inline-block">
            <div class="mb-4 ms-4">
                <label for="nombreLocalidad" class="form-label">Nombre</label>
                <input type="text" name="nombreLocalidad" id="nombreLocalidad" class="form-control w-75 mb-3 campo-formulario" placeholder="Inserte un nombre..." value="${param.nombreLocalidad}">
                <%
                if(errores != null && errores.containsKey("nombreLocalidad")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombreLocalidad") + "</small>");
                }
                %>


                <label for="provincia" class="form-label">Provincia</label>
                <select id="provincia" name="provincia" class="form-select w-75 mb-3 campo-formulario" aria-label="Default select example">
                    <option selected>Seleccione una provincia</option>
                    <%
                        List<Provincia> provincias = new ArrayList<>();
                        DAOProvincia daoProvincia = new DAOProvinciaImpl();
                        provincias = daoProvincia.listar();
                        for(Provincia provincia: provincias) { %>
                            <%System.out.println("Nombre de la provincia: " + provincia.getNombre());%>
                            <option value="<%=provincia.getNombre()%>"><%=provincia.getNombre()%></option>
                        <%}%>
                </select>

                <!-- Mensaje de confirmacion de registro-->
                <%
                    if(confirmacion != null){
                    out.println("<small class='alert alert-success d-block w-75'>" + confirmacion + "</small>");
                    }
                %>

                <input type="submit" id="send-button" value="Enviar" class="btn btn-outline-primary mt-2">
            </div>

            <input type="hidden" name="secreto" value="12345">
        </form>
        <div class="vr"></div>
        <table id="tabla-localidades" class="table w-50 me-4 ms-4">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Provincia</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Localidad> localidades = new ArrayList<>();
                DAOLocalidad daoLocalidad = new DAOLocalidadImpl();
                localidades = daoLocalidad.listar();
                    for(Localidad localidad: localidades) {
                        for(Provincia provincia: provincias) {
                            System.out.println("Listado de localidades: " + provincia.getLocalidades());
                            if(provincia.getLocalidades().contains(localidad.getId())) {
                                System.out.println("ID Localidad: " + localidad.getId() + "|| ID Localidad en Provincia: " + provincia.getId());
                                %>
                                <tr id="localidad_<%=localidad.getId()%>">
                                    <th scope="row"><%=localidad.getId()%></th>
                                    <td class="dato_formulario"><%=localidad.getNombre()%></td>
                                    <td class="dato_formulario"><%=provincia.getNombre()%></td>
                                    <td>
                                        <button type="button" id="button_<%=localidad.getId()%>" class="btn btn-outline-success btn-sm button">Editar</button>
                                    </td>
                                </tr>
                            <%}
                        }
                    }%>
            </tbody>
        </table>
    </div>
    </body>
</html>