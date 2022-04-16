package com.tienda.sanjuan.entidades;

import com.tienda.sanjuan.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-15T15:40:49")
@StaticMetamodel(DetalleOrden.class)
public class DetalleOrden_ { 

    public static volatile SingularAttribute<DetalleOrden, Double> total;
    public static volatile SingularAttribute<DetalleOrden, Integer> quantity;
    public static volatile SingularAttribute<DetalleOrden, String> id;
    public static volatile SingularAttribute<DetalleOrden, String> orden;
    public static volatile SingularAttribute<DetalleOrden, Usuario> user;

}