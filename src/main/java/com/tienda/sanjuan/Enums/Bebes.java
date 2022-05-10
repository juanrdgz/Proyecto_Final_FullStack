package com.tienda.sanjuan.enums;

public enum Bebes {
    M00("0m"), M03("3m"), M6("6m"), M09("9m"), M12("12m");

    private String nombreVista;

    private Bebes(String nombreVista) {
        this.nombreVista = nombreVista;
    }

    public String getNombreVista() {
        return nombreVista;
    }
}
