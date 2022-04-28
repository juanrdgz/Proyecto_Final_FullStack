/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author carop
 */
public class Color {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    String color;
    String colorExadecimal;

    public Color() {
    }

    public Color(String id, String color, String colorExadecimal) {
        this.id = id;
        this.color = color;
        this.colorExadecimal = colorExadecimal;
    }
    
    
}
