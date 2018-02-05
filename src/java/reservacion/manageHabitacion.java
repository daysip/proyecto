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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author miguelrecalde
 */

@ManagedBean 
@ApplicationScoped
public class manageHabitacion {
    public LinkedList<habitacion> ListaNuevo;
     public LinkedList<habitacion> TablaHab;
    public LinkedList<habitacion> ComboHab;
    public LinkedList<adicionales> CheckAdi;
    private Map <String, String> adicional; 
    private List <String> valores;
    
    
    public void cargarHabitaciones(String tipo_hab){
        TablaHab = new LinkedList <habitacion>();
        String sql = "select num_hab, informacion_hab, estado from habitacion where id_tipo = '1'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                habitacion obj = new habitacion();
                obj.num_hab = rs.getString(1);
                obj.info = rs.getString(2);
                obj.estado = rs.getString(3);
                ListaNuevo.add(obj);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void DartablaHab(String tipo_hab){
        TablaHab = new LinkedList <habitacion>();
        String sql = "select num_hab, informacion_hab, estado from habitacion where id_tipo = '1'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                habitacion obj = new habitacion();
                obj.num_hab = rs.getString(1);
                obj.info = rs.getString(2);
                obj.estado = rs.getString(3);
                ListaNuevo.add(obj);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public LinkedList<habitacion> getTablaHab() {
        return TablaHab;
    }

    public void setTablaHab(LinkedList<habitacion> TablaHab) {
        this.TablaHab = TablaHab;
    }
    
    
    
    
    public void addDetalle(String num_orden, String hab , List <String> valores){
        for(int i = 0 ; i <valores.size() ; i++){
           String id_ad = valores.get(i);
           String sql = "insert into detalle values('"+num_orden+"','"+hab+"','"+id_ad+"',0,'NINGUNO')";
           ClsConexion con = new ClsConexion();
           con.Ejecutar(sql);
        }
    }
    
    
    public LinkedList<adicionales> getCheckAdi() {
        return CheckAdi;
    }

    public void setCheckAdi(LinkedList<adicionales> CheckAdi) {
        this.CheckAdi = CheckAdi;
    }

    public Map<String, String> getAdicional() {
        return adicional;
    }

    public void setAdicional(Map<String, String> adicional) {
        this.adicional = adicional;
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }
    
    public double darPrecioAdicional(String id){
        String sql = "select precio_adi from adicionales where id_adi = '"+id+"'";
        ResultSet rs = null;
        double precio = 0;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                precio = rs.getDouble(1);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return precio;
    }

    public double getPrecioAdicional() {
        return precioAdicional;
    }

    public void setPrecioAdicional(double precioAdicional) {
        this.precioAdicional = precioAdicional;
    }
    
    
    private double precioAdicional ;
    
    
    
    public void mostrarAdicionales(){
        double acum = 0;
        System.out.println("adiocionales: " + valores);
        for(int i = 0 ; i <valores.size() ; i++){
           String id = valores.get(i);
           double precio = darPrecioAdicional(id);
           acum = acum + precio;
        }
        precioAdicional = acum;
    }
    
    public void llenarAdicionales(){
        adicional = new HashMap<String,String>();
        CheckAdi = new LinkedList <adicionales>();
        valores = new ArrayList<>();
        String sql = "select * from adicionales";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                adicionales objeto = new adicionales();
                objeto.id = rs.getString(1);
                objeto.nombre = rs.getString(2);
                objeto.precio = rs.getDouble(3);
                CheckAdi.add(objeto);
                adicional.put(objeto.nombre,objeto.id);
                
                
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    public LinkedList<habitacion> getComboHab() {
        return ComboHab;
    }

    public void setComboHab(LinkedList<habitacion> ComboHab) {
        this.ComboHab = ComboHab;
    }

    public LinkedList<reserva> getListaOrden() {
        return ListaOrden;
    }

    public void setListaOrden(LinkedList<reserva> ListaOrden) {
        this.ListaOrden = ListaOrden;
    }
    
    
    
    public void llenarcombo(){
        ComboHab = new LinkedList <habitacion>();
        String sql = "select * from tipo_hab order by id_tipo";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                habitacion objeto = new habitacion();
                objeto.num_hab = rs.getString(1);
                objeto.precio = rs.getDouble(2);
                objeto.info = rs.getString(3);
                objeto.capacidad = rs.getInt(4);
                ComboHab.add(objeto);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void llenarLista(String s){
        ListaNuevo = new LinkedList <habitacion>();
        String sql = "select num_hab, informacion_hab, estado, precio_tipo ,personas_tipo from habitacion , tipo_hab  where habitacion.id_tipo = tipo_hab.id_tipo and habitacion.id_tipo = '"+s+"'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                habitacion objeto = new habitacion();
                objeto.num_hab = rs.getString(1);
                objeto.info = rs.getString(2);
                objeto.estado = rs.getString(3);
                objeto.precio = rs.getDouble(4);
                objeto.capacidad = rs.getInt(5);
                
                ListaNuevo.add(objeto);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public LinkedList<reserva> ListaOrden;
    
    public void llenarListaOrden(String numHab){
        
        ListaOrden = new LinkedList <reserva>();
        String sql = "select * from orden where id_orden = '"+numHab+"'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                reserva objeto = new reserva();
                objeto.fecha = rs.getString(2);
                objeto.cedula = rs.getString(3);
                objeto.subtotal = rs.getDouble(4);
                objeto.total = rs.getDouble(5);
                objeto.iva = rs.getDouble(6);
                
                ListaOrden.add(objeto);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public String anadirDetalle(String id_hab, double precio, int dias){
        manageReserva obj = new manageReserva();
        obj.anadirDetalle(id_hab, precio, dias);
        return "respuesta_reserva";
    }
    
    

    public LinkedList<habitacion> getListaNuevo() {
        return ListaNuevo;
    }

    public void setListaNuevo(LinkedList<habitacion> ListaNuevo) {
        this.ListaNuevo = ListaNuevo;
    }
    

    
    
    
    
    
}
