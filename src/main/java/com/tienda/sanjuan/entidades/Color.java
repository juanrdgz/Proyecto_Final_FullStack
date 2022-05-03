/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Equipo6
 */
@Entity
public class Color {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String color;
    private String colorExadecimal;

    public Color() {
    }

    public Color(String id, String color, String colorExadecimal) {
        this.id = id;
        this.color = color;
        this.colorExadecimal = colorExadecimal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorExadecimal() {
        return colorExadecimal;
    }

    public void setColorExadecimal(String colorExadecimal) {
        this.colorExadecimal = colorExadecimal;
    }
    
    
}
