/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yellow_cat.java_crud_w_mysql;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Andrés
 */
public class Cusuarios {
    
    //Se declaran las variables
    int id;
    String nombres;
    String apellidos;
    String cedula;
    String correo_electronico;
    String contrasena;
    
    //Se auto-generan Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    //Se crea un método
    public void InsertarUsuario(
            JTextField paramNombres,
            JTextField paramApellidos,
            JTextField paramCedula,
            JTextField paramCorreo_electronico,
            JTextField paramContrasena
    ){
        //Se insertara un usuario sin el id
        
        setNombres(paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setCedula(paramCedula.getText());
        setCorreo_electronico(paramCorreo_electronico.getText());
        setContrasena(paramContrasena.getText());
        
        Cconexion objetoConexion = new Cconexion();
        
        String consulta = "INSERT INTO usuarios (nombres, apellidos, cedula, correo_electronico, contrasena) VALUES (?, ?, ?, ?, ?)";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, getNombres());
            cs.setString(2, getApellidos());
            cs.setString(3, getCedula());
            cs.setString(4, getCorreo_electronico());
            cs.setString(5, getContrasena());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el usuario");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se inserto correctamente el usuario. Error: "+e.toString());
        }        
    }
    
    public void MostrarUsuarios (JTable paramTablaTotalUsuarios){
        
        Cconexion objetoConexion = new Cconexion();
        DefaultTableModel modelo = new DefaultTableModel();
        
        //Ordenar A-Z
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalUsuarios.setRowSorter(OrdenarTabla);
        
        String sql = "";
        
        //Se crean las cabeceras de las columnas
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Cédula");
        modelo.addColumn("E-mail");
        modelo.addColumn("Contraseña");
        
        paramTablaTotalUsuarios.setModel(modelo);
        
        
        sql = "SELECT * FROM usuarios;";
        
        String[] datos = new String[6];
        Statement st;
        
        try {
            st = objetoConexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            //Recorrido
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            paramTablaTotalUsuarios.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron mostrar los registros. Error: " + e.toString());
            
        }
    }
    
}
