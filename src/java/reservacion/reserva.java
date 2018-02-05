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

/**
 *
 * @author miguelrecalde
 */
public class reserva {
    String id_orden,cedula, fecha , formaPago;
    double subtotal, iva , total;
    int ordenActual, dias;
    detalle1 unDetalle;

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    
    
    
    
    private LinkedList <detalle1> DetalleReserva;

    public detalle1 getUnDetalle() {
        return unDetalle;
    }

    public void setUnDetalle(detalle1 unDetalle) {
        this.unDetalle = unDetalle;
    }
   

    public int getOrdenActual() {
        return ordenActual;
    }

    public void setOrdenActual(int ordenActual) {
        this.ordenActual = ordenActual;
    }

    public LinkedList<detalle1> getDetalleReserva() {
        return DetalleReserva;
    }

    public void setDetalleReserva(LinkedList<detalle1> DetalleReserva) {
        this.DetalleReserva = DetalleReserva;
    }
    
    
    
    public String darNumeroOrden(){
        String num_orden;
        String sql = "select count(id_orden) from orden" ;
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                ordenActual = rs.getInt(1) + 1 ;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        num_orden = "" + ordenActual;
        return num_orden;
    }
    
    public String darSubtotal(){
        String num_orden = "";
        String sql = "select count(id_orden) from orden" ;
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                ordenActual = rs.getInt(1) + 1 ;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        num_orden = "" + ordenActual;
        return num_orden;
    }
    
    
    
    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
