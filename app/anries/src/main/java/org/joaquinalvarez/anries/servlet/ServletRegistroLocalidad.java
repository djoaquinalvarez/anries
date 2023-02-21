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
                out.print("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">\n");
                out.print("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>\n");
                out.print("    </head>");
                out.print("    <body>");
                out.print("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\" integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\" crossorigin=\"anonymous\"></script>");
                out.print("<script>");
                out.print("     $(function(){");
                out.print("     $(\"#navbar-template\").load(\"./base.jsp\");");
                out.print("     });");
                out.print("</script>");
                out.print("<div id=\"navbar-template\"></div>");

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
