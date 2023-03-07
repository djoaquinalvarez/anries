package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Cliente;

import java.io.IOException;

@WebServlet("/form_eliminar-cliente")
public class ServletEliminarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idCliente = req.getParameter("id");

        try{
            eliminar(Integer.valueOf(idCliente));
            getServletContext().getRequestDispatcher("/form_cliente.jsp").forward(req, resp);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Integer idCliente) throws Exception {
        Cliente.eliminar(idCliente);
    }
}
