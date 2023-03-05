package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Empleado;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_modificar-empleado")
public class ServletModificarEmpleado extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idEmpleado = req.getParameter("id");
        String nombreEmpleado = req.getParameter("nombre");
        String apellidoEmpleado = req.getParameter("apellido");
        String direccion = req.getParameter("direccion");
        String dni = req.getParameter("dni");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String numeroTelefono = req.getParameter("numeroTelefono");
        String fechaIngreso = req.getParameter("fechaIngreso");
        String rol = req.getParameter("rol");

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacion;

        //Validamos que los campos sean correctos
        if (nombreEmpleado == null || nombreEmpleado.equals("")) {
            errores.put("nombre", "El nombre del empleado es requerido.");
        } else if (apellidoEmpleado == null || apellidoEmpleado.equals("")) {
            errores.put("apellido", "El apellido del empleado es requerido.");
        } else if (direccion == null || direccion.equals("")) {
            errores.put("direccion", "La direccion del empleado es requerida");
        } else if (dni == null || dni.equals("")) {
            errores.put("dni", "El DNI del empleado es requerido");
        } else if (fechaNacimiento == null || fechaNacimiento.equals("")) {
            errores.put("fechaNacimiento", "La fecha de nacimiento del empleado es requerida.");
        } else if (numeroTelefono == null || numeroTelefono.equals("")) {
            errores.put("numeroTelefono", "Se requiere registrar un numero de telefono");
        } else if (fechaIngreso == null || fechaIngreso.equals("")) {
            errores.put("fechaIngreso", "La fecha de ingreso del empleado es requerida.");
        } else if (rol == null || rol.equals("")) {
            errores.put("rol", "El rol del empleado es requerido");
        }

        if (errores.isEmpty()){
            try{
                modificar(Integer.valueOf(idEmpleado), nombreEmpleado, apellidoEmpleado, direccion, Integer.valueOf(dni), fechaNacimiento, Integer.valueOf(numeroTelefono), fechaIngreso, rol);
                mensajeConfirmacion = "Los datos del empleado han sido modificados correctamente";
                req.setAttribute("confirmacion", mensajeConfirmacion);
                getServletContext().getRequestDispatcher("/form_empleado.jsp").forward(req, resp);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else{
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form_empleado.jsp").forward(req, resp);
        }
    }

    public void modificar(Integer idEmpleado, String nombreEmpleado, String apellidoEmpleado, String direccion, Integer dni, String fechaNacimiento, Integer numeroTelefono, String fechaIngreso, String rol) throws Exception {
        Empleado.modificar(idEmpleado, nombreEmpleado, apellidoEmpleado, direccion, dni, fechaNacimiento, numeroTelefono, fechaIngreso, rol);
    }
}
