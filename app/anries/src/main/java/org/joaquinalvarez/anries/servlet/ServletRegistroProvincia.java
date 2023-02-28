package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Provincia;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_registro-provincia")
public class ServletRegistroProvincia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String nombre = req.getParameter("nombre");

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacionRegistro;

        if(nombre == null || nombre.equals("")) {
            errores.put("nombre", "El nombre de la provincia es requerido.");
        }

        if (errores.isEmpty()) {
            try {
                registrarProvincia(nombre);
                mensajeConfirmacionRegistro = "La provincia '" + nombre + "' ha sido registrada correctamente.";
                System.out.println(mensajeConfirmacionRegistro);
                req.setAttribute("confirmacion", mensajeConfirmacionRegistro);
                getServletContext().getRequestDispatcher("/form_provincia.jsp").forward(req, resp);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form_provincia.jsp").forward(req, resp);
        }

    }

    public void registrarProvincia(String nombreProvincia) throws Exception {
        Provincia.registrar(nombreProvincia);
    }
}
