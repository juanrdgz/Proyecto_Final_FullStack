/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Franc
 */
@Entity
public class Orden {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Date purchaseDate;
    private Usuario user;
    private Double total;
    @OneToMany
    private ArrayList<DetalleOrden> ordenes;
    private static final Logger LOG = Logger.getLogger(Orden.class.getName());

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", purchaseDate=" + purchaseDate + ", user=" + user + ", total=" + total + ", ordenes=" + ordenes + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<DetalleOrden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<DetalleOrden> ordenes) {
        this.ordenes = ordenes;
    }

    public Orden(String id, Date purchaseDate, Usuario user, Double total, ArrayList<DetalleOrden> ordenes) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.total = total;
        this.ordenes = ordenes;
    }

    public Orden() {
    }

}
