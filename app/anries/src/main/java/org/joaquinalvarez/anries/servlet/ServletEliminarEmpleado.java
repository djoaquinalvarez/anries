package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Empleado;

import java.io.IOException;

@WebServlet("/form_eliminar-empleado")
public class ServletEliminarEmpleado extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idEmpleado = req.getParameter("id");

        try {
            eliminar(Integer.valueOf(idEmpleado));
            getServletContext().getRequestDispatcher("/form_empleado.jsp").forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Integer idEmpleado) throws Exception {
        Empleado.eliminar(idEmpleado);
    }
}
