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
    <title>Registrar Localidad</title>
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
    <h3 class="mt-5 ms-5 mb-4">Formulario de Localidades</h3>

    <div>
        <form action="/anries/form_registro-localidad" method="post" class="w-75 ms-5">
            <div class="mb-4 ms-4">
                <label for="nombreLocalidad" class="form-label">Nombre</label>
                <input type="text" name="nombreLocalidad" id="nombreLocalidad" class="form-control w-50 mb-3" placeholder="Inserte un nombre..." value="${param.nombreLocalidad}">
                <%
                if(errores != null && errores.containsKey("nombreLocalidad")) {
                    out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombreLocalidad") + "</small>");
                }
                if(confirmacion != null){
                    out.println("<small class='alert alert-success d-block w-50'>" + confirmacion + "</small>");
                }
                %>
                <input type="submit" value="Enviar" class="btn btn-outline-primary mt-2">
            </div>

            <input type="hidden" name="secreto" value="12345">
        </form>
    </div>
    </body>
</html>