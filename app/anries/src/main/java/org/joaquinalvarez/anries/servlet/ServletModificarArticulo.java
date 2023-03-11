package org.joaquinalvarez.anries.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.joaquinalvarez.anries.model.Articulo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form_modificar-articulo")
public class ServletModificarArticulo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idArticulo = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String nombreMarca = req.getParameter("marca");
        String cantidadDisponible = req.getParameter("cantidadDisponible");
        String costoCompra = req.getParameter("costoCompra");
        String precioPorUnidad = req.getParameter("precioPorUnidad");
        String nombreUnidad = req.getParameter("unidadDeMedida");
        String minimaCantidadStock = req.getParameter("minimaCantidadStock");

        Map<String, String> errores = new HashMap<>();
        String mensajeConfirmacion;

        if(nombre == null || nombre.equals("")) {
            errores.put("nombre", "El nombre del articulo es requerido.");
        }else if(nombreMarca == null || nombreMarca.equals("")){
            errores.put("nombreMarca", "La marca del articulo es requerida.");
        }else if(cantidadDisponible == null || cantidadDisponible.equals("")) {
            errores.put("cantidadDisponible", "La cantidad disponible del articulo es requerida.");
        }else if(costoCompra == null || costoCompra.equals("")) {
            errores.put("costoCompra","El costo de compra es requerido.");
        }else if(precioPorUnidad == null || precioPorUnidad.equals("")) {
            errores.put("precioPorUnidad","El precio por unidad es requerido.");
        }else if(nombreUnidad == null || nombreUnidad.equals("")) {
            errores.put("nombreUnidadMedida", "La unidad de medida del articulo es requerida");
        }else if(minimaCantidadStock == null || minimaCantidadStock.equals("")) {
            errores.put("minimaCantidadStock", "La minima cantidad de stock es requerida");
        }

        if(errores.isEmpty()) {
            try{
                modificar(Integer.valueOf(idArticulo), nombre, nombreMarca, Integer.valueOf(cantidadDisponible), Double.valueOf(costoCompra), Double.valueOf(precioPorUnidad), nombreUnidad, Integer.valueOf(minimaCantidadStock));
                mensajeConfirmacion = "Los datos del articulo han sido modificados correctamente.";
                req.setAttribute("confirmacion", mensajeConfirmacion);
                getServletContext().getRequestDispatcher("/form_articulo.jsp").forward(req, resp);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form_articulo.jsp").forward(req, resp);
        }
    }

    public void modificar(Integer idArticulo, String nombre, String nombreMarca, Integer cantidadDisponible, Double costoCompra, Double precioPorUnidad, String nombreUnidad, Integer minimaCantidadStock) throws Exception {
        Articulo.modificar(idArticulo, nombre, nombreMarca, cantidadDisponible, costoCompra, precioPorUnidad, nombreUnidad, minimaCantidadStock);
    }
}
