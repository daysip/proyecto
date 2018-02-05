package entidades;

import entidades.Detalle;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T01:44:04")
@StaticMetamodel(Adicionales.class)
public class Adicionales_ { 

    public static volatile CollectionAttribute<Adicionales, Detalle> detalleCollection;
    public static volatile SingularAttribute<Adicionales, BigDecimal> precioAdi;
    public static volatile SingularAttribute<Adicionales, String> nombreAdi;
    public static volatile SingularAttribute<Adicionales, String> idAdi;

}