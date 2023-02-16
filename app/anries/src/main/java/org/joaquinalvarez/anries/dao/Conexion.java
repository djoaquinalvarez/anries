package org.joaquinalvarez.anries.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class Conexion {

    protected Connection conexion;
    //JDBC Driver nombre y Base de datos
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=anries;user=sa;password=jey; Encrypt=True;TrustServerCertificate=True";


    public void conectar() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(connectionUrl);
        }catch(Exception e) {
            throw e;
        }
    }

    public void cerrar() throws SQLException{
        if (this.conexion != null) {
            if(!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}
