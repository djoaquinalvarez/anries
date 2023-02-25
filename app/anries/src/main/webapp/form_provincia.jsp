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
    <div id="navbar-template"></div>
    <h3 class="mt-5 ms-5 mb-4">Formulario de Provincias</h3>

    <div class="d-flex flex-row ms-5 me-5">
        <form action="/anries/form_registro-provincia" method="post" class="w-50 d-inline-block">
            <div class="mb-4 ms-4">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" name="nombre" id="nombre" class="form-control w-75 mb-3" placeholder="Inserte un nombre..." value="${param.nombre}">
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

                <input type="submit" value="Enviar" class="btn btn-outline-primary mt-2">
            </div>

        </form>
        <div class="vr"></div>
        <table class="table w-50 me-4 ms-4">
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
                        <tr>
                            <th scope="row"><%=provincia.getId()%></th>
                            <td><%=provincia.getNombre()%></td>
                        </tr>
                    <%}%>
            </tbody>
        </table>
    </div>
    </body>
</html>