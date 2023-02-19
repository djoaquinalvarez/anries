package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Localidad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_registro-localidad")
public class ServletRegistroLocalidad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nombre = req.getParameter("nombreLocalidad");
        Map<String, String> errores = new HashMap<>();

        if(nombre == null) {
            errores.put("nombreLocalidad", "El nombre de la localidad es requerido.");
        }

        if(errores.isEmpty()) {
            registrarLocalidad(nombre);
            try(PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("    <head>");
                out.print("        <meta charset=\"UTF-8\">");
                out.print("        <title>Registro Localidad</title>");
                out.print("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
                out.print("    </head>");
                out.print("    <body>");
                out.print("        <h1>Localidad de " + nombre + " registrada con éxito</h1>");
                out.print("        <div>");
                out.print("             <a href='http://localhost:8080/anries' class='btn btn-secondary'>Volver</a>");
                out.print("             <a href='http://localhost:8080/anries/form_localidades.jsp' class='btn btn-primary'>Registrar otra localidad</a>");
                out.print("        </div>");
                out.print("    </body>");
                out.print("</html>");
            }
        }
    }

    public void registrarLocalidad(String nombre) {
        Localidad.registrar(nombre);
    }
}
