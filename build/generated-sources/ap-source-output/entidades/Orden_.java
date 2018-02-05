package entidades;

import entidades.Detalle;
import entidades.Persona;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T01:44:04")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, Date> fecha;
    public static volatile SingularAttribute<Orden, BigDecimal> total;
    public static volatile CollectionAttribute<Orden, Detalle> detalleCollection;
    public static volatile SingularAttribute<Orden, BigDecimal> iva;
    public static volatile SingularAttribute<Orden, BigDecimal> subtotal;
    public static volatile SingularAttribute<Orden, Persona> cedula;
    public static volatile SingularAttribute<Orden, String> formaPago;
    public static volatile SingularAttribute<Orden, String> idOrden;

}