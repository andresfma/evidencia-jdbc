package com.mycompany.evidenciajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EvidenciaJDBC {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/sonyco";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            
            // Consulta de datos
            rs = statement.executeQuery("SELECT * FROM usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Inserción de datos
            statement.execute("INSERT INTO `usuario` (`id`, `nombre`, `email`, `contrasena`, `rol_id`) VALUES (NULL, 'felipe', 'felipe@gmail.com', '1234', NULL);");
            System.out.println("");
                    
            rs = statement.executeQuery("SELECT * FROM usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Actualización de datos
            statement.execute("UPDATE `usuario` SET `nombre` = 'mercado', `email` = 'mercado@gmail.com' WHERE `usuario`.`id` = 6;");
            System.out.println("");
                    
            rs = statement.executeQuery("SELECT * FROM usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Eliminación de datos
            statement.execute("DELETE FROM `usuario` WHERE `usuario`.`id` = 6");
            System.out.println("");
                    
            rs = statement.executeQuery("SELECT * FROM usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            System.getLogger(EvidenciaJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
