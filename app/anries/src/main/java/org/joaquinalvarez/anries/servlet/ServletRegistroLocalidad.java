package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Localidad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_registro-localidad")
public class ServletRegistroLocalidad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nombre = req.getParameter("nombre");
        String provincia = req.getParameter("provincia");

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacionRegistro;

        if(nombre == null || nombre.equals("")) {
            errores.put("nombreLocalidad", "El nombre de la localidad es requerido.");
        }
        if(provincia == null || provincia.equals("")) {
            errores.put("provincia", "La provincia es requerida.");
        }



        if(errores.isEmpty()) {
            try {
                registrarLocalidad(nombre, provincia);
                mensajeConfirmacionRegistro =  "La localidad '" + nombre  + "' de la provincia de '" + provincia + "' ha sido registrada correctamente.";
                req.setAttribute("confirmacion", mensajeConfirmacionRegistro);
                getServletContext().getRequestDispatcher("/form_localidades.jsp").forward(req, resp);//pasamos el request y el response a la jsp
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form_localidades.jsp").forward(req, resp);//pasamos el request y el response a la jsp
        }
    }

    public void registrarLocalidad(String nombre, String provincia) throws Exception {
        Localidad.registrar(nombre, provincia);
    }
}
