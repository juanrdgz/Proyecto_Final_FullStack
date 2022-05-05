/*
 * To change this license header("36"), choose License Headers in Project Properties.
 * To change this template file("36"), choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.enums;

/**
 *
 * @author carop
 */
public enum Pantalon {
    P36("36"),P38("38"),P40("40"),P42("42"),P44("44"),P46("46"),P48("48"),P50("50"),P52("52"),P54("54"),
    P56("56"),P58("58"),P60("60");
    
    private Pantalon(String text) {
        this.text = text;
    }
    
    private String text;
    
    public String getText() {
        return text;
    }
}
