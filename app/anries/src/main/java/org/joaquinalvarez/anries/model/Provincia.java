package org.joaquinalvarez.anries.model;

import jakarta.validation.constraints.PastOrPresent;
import org.joaquinalvarez.anries.dao.DAOProvinciaImpl;
import org.joaquinalvarez.anries.interfaces.DAOProvincia;

import java.util.ArrayList;

public class Provincia {
    private Integer id;
    private String nombre;
    private ArrayList<Integer> localidades;

    public Provincia(String nombre, ArrayList<Integer> localidades) {
        this.nombre = nombre;
        this.localidades = localidades;
    }

    public Provincia() {
        this.localidades = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(ArrayList<Integer> localidades) {
        this.localidades = localidades;
    }

    public static void registrar(String nombreProvincia) throws Exception {
        Provincia provincia = new Provincia();
        provincia.setNombre(nombreProvincia);
        DAOProvincia daoProvincia = new DAOProvinciaImpl();
        daoProvincia.registrar(provincia);
        //buscamos el id del elemento registrado y lo guardamos en el objeto
        provincia.setId(daoProvincia.buscarProvinciaPorNombre(provincia.getNombre()).getId());
    }

    public static void modificar(Integer idProvincia, String nombreProvincia) throws Exception {
        Provincia provincia = new Provincia();
        provincia.setId(idProvincia);
        provincia.setNombre(nombreProvincia);

        DAOProvincia daoProvincia = new DAOProvinciaImpl();
        daoProvincia.modificar(provincia);
    }
}
