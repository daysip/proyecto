package entidades;

import entidades.Detalle;
import entidades.TipoHab;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T01:44:04")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> estado;
    public static volatile CollectionAttribute<Habitacion, Detalle> detalleCollection;
    public static volatile SingularAttribute<Habitacion, String> fotoPath;
    public static volatile SingularAttribute<Habitacion, String> informacionHab;
    public static volatile SingularAttribute<Habitacion, TipoHab> idTipo;
    public static volatile SingularAttribute<Habitacion, String> numHab;

}