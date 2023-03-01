<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.joaquinalvarez.anries.dao.DAOProvinciaImpl"%>
<%@page import="org.joaquinalvarez.anries.interfaces.DAOProvincia"%>
<%@page import="org.joaquinalvarez.anries.model.Provincia"%>
<%
Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");
String confirmacion = (String)request.getAttribute("confirmacion");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrar Provincia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script>
         $(function(){
         $("#navbar-template").load("./base.jsp");
         });
    </script>
    <!-- Funcionalidad de botones de la tabla -->
    <script src="./js/provincias.js"></script>

    <!-- Modal -->
    <form action="/anries/form_eliminar-provincia" method="post" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmar eliminación de provincia</h1>
                    <input type="hidden" class="dato-servlet" name="id" value="">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="modal_body-provincia">
                    ¿Está seguro de borrar esta localidad?
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
    <h3 class="mt-5 ms-5 mb-4">Formulario de Provincias</h3>

    <div class="d-flex flex-row ms-5 me-5">
        <form action="/anries/form_registro-provincia" id="formulario-provincias" method="post" class="w-50 d-inline-block">
            <input type="hidden" class="campo-formulario" name="id" value="">
            <div class="mb-4 ms-4">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" name="nombre" id="nombre" class="form-control w-75 mb-3 campo-formulario" placeholder="Inserte un nombre..." value="${param.nombre}">
                <%
                if(errores != null && errores.containsKey("nombre")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombre") + "</small>");
                }
                %>

                <!-- Mensaje de confirmacion de registro-->
                <%
                    if(confirmacion != null){
                    out.println("<small class='alert alert-success d-block w-75'>" + confirmacion + "</small>");
                    }
                %>

                <input type="submit" id="send-button" value="Enviar" class="btn btn-outline-primary mt-2">
                <input type="button" id="hidden-button_cancelar" value="Cancelar" class="btn btn-secondary mt-2 visually-hidden">
            </div>

        </form>
        <div class="vr"></div>
        <table class="table w-50 me-4 ms-4" id="tabla-provincias">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Nombre</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Provincia> provincias = new ArrayList<>();
                DAOProvincia daoProvincia = new DAOProvinciaImpl();
                provincias = daoProvincia.listar();
                    for(Provincia provincia: provincias) {%>
                        <tr id="provincia_<%=provincia.getId()%>">
                            <th class="dato-tabla" scope="row"><%=provincia.getId()%></th>
                            <td class="dato-tabla"><%=provincia.getNombre()%></td>
                            <td class="d-flex flex-row-reverse flex-shrink-1">
                                <button type="button" id="button_borrar-<%=provincia.getId()%>" class="btn btn-outline-danger btn-sm button-borrar" data-bs-toggle="modal" data-bs-target="#exampleModal">Borrar</button>
                                <button type="button" id="button_editar-<%=provincia.getId()%>" class="btn btn-outline-success btn-sm button-editar me-2">Editar</button>
                            </td>
                        </tr>
                    <%}%>
            </tbody>
        </table>
    </div>
    </body>
</html>