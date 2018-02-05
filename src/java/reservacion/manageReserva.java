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
import java.util.List;
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
public class manageReserva {
    
    String usuario , fecha ,etiqueta, etiqueta2;
    String numOrden ;
    reserva Reserva;
    detalle1 detalle = new detalle1();

    public String getEtiqueta2() {
        return etiqueta2;
    }

    public void setEtiqueta2(String etiqueta2) {
        this.etiqueta2 = etiqueta2;
    }

    
    
    public void darFecha(){
        fecha ="dd/mm/aa";
      
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
    
    public void armarReserva(){
        Reserva = new reserva();
    }
    
    public String selecHab(String num_hab, double Precio){
        detalle.num_hab = num_hab;
        detalle.costo = Precio;
        return "confirmar_reserva";
        
    }
    
    public String estaReservada(String num_hab){
        String valor= "true";
        String estado ="disponible";
        String sql = "SELECT estado from habitacion where num_hab = '"+num_hab+"'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                estado = rs.getString(1);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(estado.equals("RESERVADA")){
            valor = "true";
        }else{
            valor = "false";
        }
        return valor;
    }
    
    public void consultaHab(String id_orden){
        String sql = "select num_hab from detalle where id_orden = '"+id_orden+"'";
        String adicion = "";
         ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                adicion = rs.getString(1);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         con.Ejecutar(sql);
        etiqueta2 = adicion;
     
    }
    
    public void consultaReservacion(String id_orden){
        String sql = "select nombre_adi from detalle, adicionales where id_orden = '"+id_orden+"' \n" +
"and detalle.id_adi = adicionales.id_adi";
        String adicion = "";
         ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                adicion += rs.getString(1) + " ";
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         con.Ejecutar(sql);
        etiqueta = adicion;
     
    }
    
    
    public String darHabitacion(String tipo_hab){
        String num_hab = "";
        String sql = "select num_hab from habitacion, tipo_hab \n" +
"where habitacion.id_tipo = tipo_hab.id_tipo\n" +
"and habitacion.id_tipo = '"+tipo_hab+"' and estado = 'DISPONIBLE'";
         ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                num_hab = rs.getString(1);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         con.Ejecutar(sql);
         return num_hab;
        
    }
    
    public String ingresarOrden(String hab,String numOrden,String tipo_hab,String cedula,String fecha,double subtotal, double iva, double total , List <String> valores){
        String sql = "insert into orden values('"+numOrden+"','"+cedula+"','"+fecha+"',"+subtotal+","+iva+","+total+",'EFECTIVO')";
        ClsConexion con = new ClsConexion();
        System.out.println("reservacion.manageReserva.ingresarOrden()" + con.Ejecutar(sql));
        reservarHab(hab);
        manageHabitacion s = new manageHabitacion();
        s.addDetalle(numOrden, hab, valores);

        return "respReserva";
    }
    
    public void reservarHab(String num_hab){
        String sql = "update habitacion set estado = 'RESERVADA' where num_hab = '"+num_hab+"'";
        ClsConexion con = new ClsConexion();
        con.Ejecutar(sql);
    }
    
    
    public void valorTotal(double precioHab, double precioAdi){
        Reserva.subtotal = ((precioHab * detalle.personas * Reserva.dias) + (detalle.personas * precioAdi * Reserva.dias)) ;
        Reserva.iva = Reserva.subtotal * 0.12;
        Reserva.total = Reserva.subtotal + Reserva.iva;
    }
    
    public double darCosto(String tipohab, int personas){
        
        double precio = darPrecio(tipohab);
        detalle.costo  = precio * personas;
        return detalle.costo;
    }
    
    
    public double darPrecio(String tipoHab){
        double precio = 1;
        String sql = "select precio_tipo from tipo_hab where id_tipo = '"+tipoHab+"'";
        ResultSet rs = null;
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
         con.Ejecutar(sql);
         return precio;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    public detalle1 getDetalle() {
        return detalle;
    }

    public void setDetalle(detalle1 detalle) {
        this.detalle = detalle;
    }
    
    

    public reserva getReserva() {
        return Reserva;
    }

    public void setReserva(reserva Reserva) {
        this.Reserva = Reserva;
    }
    
    
    
    
    public String darOrden(){
        reserva obj = new reserva();
        this.numOrden = obj.darNumeroOrden();
        return "" + numOrden;
    }
    
    public String darOrden2(){
        reserva obj = new reserva();
        int numOrden2 = Integer.parseInt(obj.darNumeroOrden()) - 1;
        numOrden = ""+numOrden2;
        return ""+numOrden;
    }
    
    public void crearOrden(){
        String sql = "insert into orden values('"+numOrden+"','123456789','2012-12-12',0,0,0,'EFECTIVO')";
        ClsConexion con = new ClsConexion();
        con.Ejecutar(sql);
    }
    
    
    
    public void anadirDetalle(String num_hab, double precioHab, int dias){
        double subtotalAnt = 0;
        double ivaAnt = 0;
        double totalAnt = 0;
        String sql = "select subtotal, iva, total from orden where id_orden= '"+numOrden+"'";
        ResultSet rs = null;
        ClsConexion con = new ClsConexion();
        rs = con.Consulta(sql);
        if(rs != null){
        try {
            while(rs.next()){
                subtotalAnt= rs.getDouble(1);
                ivaAnt = rs.getDouble(2);
                totalAnt= rs.getDouble(3);
            
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Double nuevoSub = subtotalAnt + (precioHab * dias);
        Double nuevoiva = nuevoSub * 0.14;
        Double total = nuevoSub + nuevoiva;
        String sqlUp = "update orden set subtotal = "+nuevoSub+", iva = "+nuevoiva+" , total = "+total+" where id_orden = '"+numOrden+"'" ;
        con.Ejecutar(sqlUp);
        
    }
    
    
    public LinkedList<reserva> ListaOrden;
    public void llenarListaOrden(){
        
        ListaOrden = new LinkedList <reserva>();
        String sql = "select * from orden where id_orden = '"+numOrden+"'";
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
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public LinkedList<reserva> getListaOrden() {
        return ListaOrden;
    }

    public void setListaOrden(LinkedList<reserva> ListaOrden) {
        this.ListaOrden = ListaOrden;
    }
    
    
}
