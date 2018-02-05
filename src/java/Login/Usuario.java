/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import baseDatos.ClsConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelrecalde
 */
public class Usuario {
    String cedula , nombre , apellido, correo, telefono, pass, rol;

    public Usuario() {
        
    }

    
    
    public Usuario(String correo) {
        this.correo = correo;
        String sql = "select * from persona where correo = '"+correo+"'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                cedula = rs.getString(1);
                nombre = rs.getString(2);
                apellido = rs.getString(3);
                telefono = rs.getString(5);
                pass = rs.getString(6);
                rol = rs.getString(7);
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
                cedula = "";
                nombre = "";
                apellido = "";
                telefono = "";
                pass = "";
                rol = "";
                
        }
    }

    
    
    public void Ingresar(Usuario nd){
            String sql = "insert into persona values "
                    + "('"+nd.cedula+"','"+nd.nombre+"','"+nd.apellido+"','"+nd.correo+"','"+nd.telefono+"','"+nd.pass+"','"+nd.rol+"');";
         ClsConexion con=new ClsConexion();
         String error = "<h1 align=center>"+con.Ejecutar(sql)+"</h1>";
         System.out.println(error +"--------------------------------------------");
    }
    
    
    
    //Metodos Get y Set
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
