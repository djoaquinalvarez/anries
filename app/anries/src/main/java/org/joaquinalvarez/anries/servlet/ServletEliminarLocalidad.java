package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Localidad;

import java.io.IOException;

@WebServlet("/form_eliminar-localidad")
public class ServletEliminarLocalidad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");
        Integer idNumerico = Integer.valueOf(idString);
        System.out.println(idString);

        try{
            eliminarLocalidad(idNumerico);
            getServletContext().getRequestDispatcher("/form_localidades.jsp").forward(req, resp);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarLocalidad(Integer idLocalidad) throws Exception {
        Localidad.eliminarLocalidad(idLocalidad);
    }
}
