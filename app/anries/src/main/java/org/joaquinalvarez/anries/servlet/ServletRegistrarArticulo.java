package org.joaquinalvarez.anries.servlet;

import jakarta.faces.validator.DoubleRangeValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.spi.WebServiceFeatureAnnotation;
import org.joaquinalvarez.anries.model.Articulo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_registro-articulo")
public class ServletRegistrarArticulo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String idMarca = req.getParameter("marca");
        String cantidadDisponible = req.getParameter("cantidadDisponible");
        String costoCompra = req.getParameter("costoCompra");
        String precioPorUnidad = req.getParameter("precioPorUnidad");
        String nombreUnidadMedida = req.getParameter("unidadDeMedida");
        String minimaCantidadStock = req.getParameter("minimaCantidadStock");
        System.out.println(nombre);
        System.out.println(idMarca);
        System.out.println(cantidadDisponible);
        System.out.println(costoCompra);
        System.out.println(precioPorUnidad);
        System.out.println(nombreUnidadMedida);
        System.out.println(minimaCantidadStock);

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacion;

        if(nombre == null || nombre.equals("")) {
            errores.put("nombre", "El nombre del articulo es requerido.");
        }else if(idMarca == null || idMarca.equals("")){
            errores.put("nombreMarca", "La marca del articulo es requerida.");
        }else if(cantidadDisponible == null || cantidadDisponible.equals("")) {
            errores.put("cantidadDisponible", "La cantidad disponible del articulo es requerida.");
        }else if(costoCompra == null || costoCompra.equals("")) {
            errores.put("costoCompra","El costo de compra es requerido.");
        }else if(precioPorUnidad == null || precioPorUnidad.equals("")) {
            errores.put("precioPorUnidad","El precio por unidad es requerido.");
        }else if(nombreUnidadMedida == null || nombreUnidadMedida.equals("")) {
            errores.put("nombreUnidadMedida", "La unidad de medida del articulo es requerida");
        }else if(minimaCantidadStock == null || minimaCantidadStock.equals("")) {
            errores.put("minimaCantidadStock", "La minima cantidad de stock es requerida");
        }

        if(errores.isEmpty()) {
            try{
                registrar(nombre, Integer.valueOf(idMarca), Integer.valueOf(cantidadDisponible), Double.valueOf(costoCompra), Double.valueOf(precioPorUnidad), nombreUnidadMedida, Integer.valueOf(minimaCantidadStock));
                mensajeConfirmacion = "El articulo " + nombre + " ha sido registrado correctamente";
                req.setAttribute("confirmacion", mensajeConfirmacion);
                getServletContext().getRequestDispatcher("/form_articulo.jsp").forward(req, resp);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form_articulo.jsp").forward(req, resp);
        }
    }

    public void registrar(String nombre, Integer idMarca, Integer cantidadDisponible, Double costoCompra, Double precioPorUnidad, String nombreUnidadMedida, Integer minimaCantidadStock) throws Exception {
        Articulo.registrar(nombre, idMarca, cantidadDisponible, costoCompra, precioPorUnidad, nombreUnidadMedida, minimaCantidadStock);
    }
}
