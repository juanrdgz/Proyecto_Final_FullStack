/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Franc
 */
@Entity
public class DetalleOrden {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    private String orden;
    private Usuario user;
    private Integer quantity;
    private Double total;

    public DetalleOrden() {
    }

    public DetalleOrden(String id, String order, Usuario user, Integer quantity, Double total) {
        this.id = id;
        this.orden = orden;
        this.user = user;
        this.quantity = quantity;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return orden;
    }

    public void setOrder(String order) {
        this.orden = orden;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" + "id=" + id + ", orden=" + orden + ", user=" + user + ", quantity=" + quantity + ", total=" + total + '}';
    }

    
}
