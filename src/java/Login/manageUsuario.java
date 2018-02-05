/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.LinkedList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author miguelrecalde
 */
@ManagedBean 
@ApplicationScoped

public class manageUsuario {
    public String nombreUsuario, password;
    public Usuario usuario;
    public LinkedList<Usuario> ListaNuevo;

    
    
    
    public LinkedList<Usuario> getListaNuevo() {
        return ListaNuevo;
    }

    public void setListaNuevo(LinkedList<Usuario> ListaNuevo) {
        this.ListaNuevo = ListaNuevo;
    }

   
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void esUsuario(){
        
    }
    
    
    public String respuestaLogin(){
       String pagina ="errorLogeo";
       usuario = new Usuario(nombreUsuario);
      try{    
       if(usuario.pass.equals(password)){
        pagina = "Bienvenido";
      
            if(usuario.rol.equals("1")){
            pagina = "index_admin";
            } 
            if(usuario.rol.equals("2")){
            pagina = "index_cliente";
            } 
        
    }else{
        pagina = "errorLogeo";
    }
       }catch(Exception ex){
           System.out.println("no es cliente"); 
           pagina = "errorLogeo";
       }
       
       
    return pagina;
  }
    
    public void llenarNueva(){
      ListaNuevo = new LinkedList <Usuario>();
      Usuario obj = new Usuario();
      obj.cedula = "";
      obj.nombre = "";
      obj.apellido = "";
      obj.correo = "";
      obj.pass = "";
      obj.telefono= "";
      obj.rol = "";
      ListaNuevo.add(obj);
  }
    
   public String respuestaIngresar(String cedula, String nombres, String apellidos,
   String correo, String password,String Telefono){
       Usuario obj = new Usuario();
       obj.cedula = cedula;
       obj.nombre = nombres;
       obj.apellido = apellidos;
       obj.correo = correo;
       obj.pass = password;
       obj.telefono = Telefono;
       obj.rol = "2";
       obj.Ingresar(obj);
       return "index";
   }
    
    
}
