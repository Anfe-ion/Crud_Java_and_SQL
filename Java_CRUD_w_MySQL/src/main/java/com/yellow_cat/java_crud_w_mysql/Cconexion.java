/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yellow_cat.java_crud_w_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class Cconexion {
    
    Connection conectar = null;
    
    String usuario = "root";
    String contrasenia = "Perro@123";
    String bd = "proyecto_ebikes";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar  = DriverManager.getConnection(cadena, usuario, contrasenia);
            JOptionPane.showMessageDialog(null,"La conexión se ha realizado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos. Error: "+ e.toString());
        }
        return conectar;
    }
    
}
