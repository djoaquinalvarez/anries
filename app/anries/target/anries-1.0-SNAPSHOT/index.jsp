<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrar Localidad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<h3>Formulario de Localidades</h3>

<%
if(errores != null && errores.size()>0) {
%>
<ul class="alert alert-danger mx-5">
    <% for(String error: errores.values()) {%>
    <li><%=error%></li>
    <%}%>
</ul>
<% } %>
<div class="px-5">
    <form action="/anries/form_registro-localidad" method="post">
        <div class="row mb-3">
            <label for="nombreLocalidad" class="col-form-label col-sm-2">Nombre</label>
            <div class="col-sm-4">
                <input type="text" name="nombreLocalidad" id="nombreLocalidad" class="form-control" value="${param.nombreLocalidad}">
            </div>
            <%
            if(errores != null && errores.containsKey("nombreLocalidad")) {
            out.println("<small class='alert alert-danger col-sm-4'>"+ errores.get("nombreLocalidad") + "</small>");
            }
            %>
        </div>

        <div class="row mb-3">
            <div>
                <input type="submit" value="Enviar" class="btn btn-primary">
            </div>
        </div>

        <input type="hidden" name="secreto" value="12345">
    </form>
</div>
</body>
