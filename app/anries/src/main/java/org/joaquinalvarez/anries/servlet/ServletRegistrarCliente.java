package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Cliente;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_registro-cliente")
public class ServletRegistrarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String direccion = req.getParameter("direccion");
        String dni = req.getParameter("dni");
        String numeroTelefono = req.getParameter("numeroTelefono");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String nombreLocalidad = req.getParameter("localidad");


        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacion;

        //Validamos que los campos sean correctos
        if (nombre == null || nombre.equals("")) {
            errores.put("nombre", "El nombre del empleado es requerido.");
        } else if (apellido == null || apellido.equals("")) {
            errores.put("apellido", "El apellido del empleado es requerido.");
        } else if (direccion == null || direccion.equals("")) {
            errores.put("direccion", "La direccion del empleado es requerida");
        } else if (dni == null || dni.equals("")) {
            errores.put("dni", "El DNI del empleado es requerido");
        } else if (fechaNacimiento == null || fechaNacimiento.equals("")) {
            errores.put("fechaNacimiento", "La fecha de nacimiento del empleado es requerida.");
        } else if (numeroTelefono == null || numeroTelefono.equals("")) {
            errores.put("numeroTelefono", "Se requiere registrar un numero de telefono");
        } else if (nombreLocalidad == null || nombreLocalidad.equals("")) {
            errores.put("localidad", "La localidad es requerida.");
        }

        if(errores.isEmpty()){
            try{
                registrar(nombre, apellido, direccion, Integer.valueOf(dni), fechaNacimiento, Integer.valueOf(numeroTelefono), nombreLocalidad);
                mensajeConfirmacion = "El cliente " +apellido + ", " + nombre  + " ha sido registrado correctamente.";
                req.setAttribute("confirmacion", mensajeConfirmacion);
                getServletContext().getRequestDispatcher("/form_cliente.jsp").forward(req, resp);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form_cliente.jsp").forward(req, resp);
        }

    }

    public void registrar(String nombre, String apellido, String direccion, Integer dni, String fechaNacimiento, Integer numeroTelefono, String nombreLocalidad) throws Exception {
        Cliente.registrar(nombre, apellido, direccion, dni, fechaNacimiento, numeroTelefono, nombreLocalidad);
    }
}
