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

@WebServlet("/form_modificar-provincia")
public class ServletModificarProvincia extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idProvincia = req.getParameter("id");
        String nombreProvincia = req.getParameter("nombre");
        Integer idNumerico = Integer.valueOf(idProvincia);

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacionRegistro;

        if(nombreProvincia == null || nombreProvincia.equals("")) {
            errores.put("nombre", "El nombre de la provincia es requerido");
        }

        if (errores.isEmpty()) {
            try{
                modificarProvincia(idNumerico, nombreProvincia);
                mensajeConfirmacionRegistro = "Se ha modificado el registro de provincia con el siguiente nombre: " + nombreProvincia;
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

    public void modificarProvincia(Integer idProvincia, String nombreProvincia) throws Exception {
        Provincia.modificar(idProvincia, nombreProvincia);
    }
}
