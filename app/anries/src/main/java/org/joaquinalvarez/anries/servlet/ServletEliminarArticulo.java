package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Articulo;

import java.io.IOException;

@WebServlet("/form_eliminar-articulo")
public class ServletEliminarArticulo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idArticulo = req.getParameter("id");

        try{
            eliminar(Integer.valueOf(idArticulo));
            getServletContext().getRequestDispatcher("/form_articulo.jsp").forward(req, resp);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void eliminar(Integer idArticulo) throws Exception {
        Articulo.eliminar(idArticulo);
    }
}
