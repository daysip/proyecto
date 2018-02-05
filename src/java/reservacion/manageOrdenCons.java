/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservacion;

import Login.Usuario;
import baseDatos.ClsConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author miguelrecalde
 */
@ManagedBean
public class manageOrdenCons {
 public LinkedList<ordenCons> ListaConsulta;   
 
    public void cargarOrdenes(){
        ListaConsulta = new LinkedList <ordenCons>();
        String sql = "select id_orden, nombre, apellido , fecha , total from orden ,persona where orden.cedula = persona.cedula order by fecha ";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                ordenCons obj = new ordenCons();
                obj.id_orden = rs.getString(1);
                obj.nombre = rs.getString(2);
                obj.apellido = rs.getString(3);
                obj.fecha = rs.getString(4);
                obj.total = rs.getDouble(5);
                ListaConsulta.add(obj);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
     public void cargarOrdenesCliente(String cedula){
        ListaConsulta = new LinkedList <ordenCons>();
        String sql = "select id_orden, nombre, apellido , fecha , total from orden ,persona where orden.cedula = persona.cedula and persona.cedula = '"+cedula+"' order by fecha";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                ordenCons obj = new ordenCons();
                obj.id_orden = rs.getString(1);
                obj.nombre = rs.getString(2);
                obj.apellido = rs.getString(3);
                obj.fecha = rs.getString(4);
                obj.total = rs.getDouble(5);
                ListaConsulta.add(obj);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 

    public LinkedList<ordenCons> getListaConsulta() {
        return ListaConsulta;
    }

    public void setListaConsulta(LinkedList<ordenCons> ListaConsulta) {
        this.ListaConsulta = ListaConsulta;
    }
 
 
 
 
}
