package entidades;

import entidades.Adicionales;
import entidades.DetallePK;
import entidades.Habitacion;
import entidades.Orden;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T01:44:04")
@StaticMetamodel(Detalle.class)
public class Detalle_ { 

    public static volatile SingularAttribute<Detalle, String> fechaIni;
    public static volatile SingularAttribute<Detalle, Adicionales> adicionales;
    public static volatile SingularAttribute<Detalle, BigInteger> diasHab;
    public static volatile SingularAttribute<Detalle, Orden> orden;
    public static volatile SingularAttribute<Detalle, DetallePK> detallePK;
    public static volatile SingularAttribute<Detalle, Habitacion> habitacion;

}