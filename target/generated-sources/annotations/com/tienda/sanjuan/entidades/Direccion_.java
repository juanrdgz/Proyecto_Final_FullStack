package com.tienda.sanjuan.entidades;

import com.tienda.sanjuan.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-20T02:09:06")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile SingularAttribute<Direccion, String> address;
    public static volatile SingularAttribute<Direccion, String> province;
    public static volatile SingularAttribute<Direccion, String> receiver;
    public static volatile SingularAttribute<Direccion, String> city;
    public static volatile SingularAttribute<Direccion, String> postalCode;
    public static volatile SingularAttribute<Direccion, String> details;
    public static volatile SingularAttribute<Direccion, String> id;
    public static volatile SingularAttribute<Direccion, Usuario> user;

}