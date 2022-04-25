package com.tienda.sanjuan.entidades;

import com.tienda.sanjuan.entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-21T21:51:01")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, Date> purchaseDate;
    public static volatile SingularAttribute<Orden, Double> total;
    public static volatile SingularAttribute<Orden, String> id;
    public static volatile SingularAttribute<Orden, Usuario> user;

}