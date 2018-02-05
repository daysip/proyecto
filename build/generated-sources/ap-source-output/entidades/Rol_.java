package entidades;

import entidades.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T01:44:04")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> idRol;
    public static volatile CollectionAttribute<Rol, Persona> personaCollection;
    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile CollectionAttribute<Rol, Persona> personaCollection1;

}