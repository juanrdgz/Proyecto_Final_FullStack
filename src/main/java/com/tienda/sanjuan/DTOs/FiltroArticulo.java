package com.tienda.sanjuan.DTOs;

import com.tienda.sanjuan.entidades.Categoria;
import java.util.List;

public class FiltroArticulo {

    private Double precioMinimo;
    private Double precioMaximo;
    private String categoria;
    //private List<Color> colores;

    public Double getPrecioMinimo() {
        return precioMinimo;
    }
    public void setPrecioMinimo(Double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }
    public Double getPrecioMaximo() {
        return precioMaximo;
    }
    public void setPrecioMaximo(Double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}