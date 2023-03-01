package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.dao.DAOProvinciaImpl;
import org.joaquinalvarez.anries.model.Provincia;

import java.io.IOException;

@WebServlet("/form_eliminar-provincia")
public class ServletEliminarProvincia extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idProvincia = req.getParameter("id");
        Integer idNumerico = Integer.valueOf(idProvincia);


        try{
            eliminarProvincia(idNumerico);
            getServletContext().getRequestDispatcher("/form_provincia.jsp").forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarProvincia(Integer idProvincia) throws Exception {
        Provincia.eliminar(idProvincia);
    }
}
