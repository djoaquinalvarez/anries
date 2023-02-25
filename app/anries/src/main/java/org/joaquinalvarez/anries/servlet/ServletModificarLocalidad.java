package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Localidad;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_modificar-localidad")
public class ServletModificarLocalidad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String idString = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String provincia = req.getParameter("provincia");

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacionRegistro;

        //System.out.println("El id de la localidad " + nombre + " es: " + idString);
        Integer idNumerico = Integer.valueOf(idString);

        if(nombre == null || nombre.equals("")) {
            errores.put("nombre", "El nombre de la localidad es requerido.");
        } else if(provincia == null || provincia.equals("")) {
            errores.put("provincia", "La provincia es requerida.");
        }

        if (errores.isEmpty()) {
            try{
                modificarLocalidad(idNumerico, nombre, provincia);
                mensajeConfirmacionRegistro = "Se ha modificado el registro de localidad de la siguiente manera: " +  nombre + ", " + provincia;
                req.setAttribute("confirmacion", mensajeConfirmacionRegistro);
                getServletContext().getRequestDispatcher("./form_localidades.jsp").forward(req, resp);
            }catch(RuntimeException e) {
                e.printStackTrace();
            }
        }else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("./form_localidades.jsp").forward(req, resp);
        }
    }

    public void modificarLocalidad(Integer id, String nombre, String provincia) {
        Localidad.modificarLocalidad(id, nombre, provincia);
    }
}
