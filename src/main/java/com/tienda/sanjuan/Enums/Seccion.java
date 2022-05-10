package com.tienda.sanjuan.enums;

public enum Seccion {
    HOMBRE("Hombre"), MUJER("Mujer"), NIÑOS("Niños"), BEBES("Bebes"), COLEGIAL("Colegial"), BAÑO("Baño"),
    COCINA_Y_BAZAR("Cocina & Bazar"), DORMITORIO("Dormitorio"), DECO_Y_CO("Deco&Co");

    private String nombreVista;

    private Seccion(String nombreVista) {
        this.nombreVista = nombreVista;
    }

    public String getNombreVista() {
        return nombreVista;
    }
}
