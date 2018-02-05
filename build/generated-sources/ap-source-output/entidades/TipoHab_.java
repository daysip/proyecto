package entidades;

import entidades.Habitacion;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T01:44:04")
@StaticMetamodel(TipoHab.class)
public class TipoHab_ { 

    public static volatile SingularAttribute<TipoHab, String> nombreTipo;
    public static volatile SingularAttribute<TipoHab, BigDecimal> precioTipo;
    public static volatile CollectionAttribute<TipoHab, Habitacion> habitacionCollection;
    public static volatile SingularAttribute<TipoHab, String> idTipo;
    public static volatile SingularAttribute<TipoHab, BigInteger> personasTipo;

}