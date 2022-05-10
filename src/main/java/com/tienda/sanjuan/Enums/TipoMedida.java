package com.tienda.sanjuan.enums;

public enum TipoMedida {
    ROPA_COMUN("Ropa Normal"), PANTALONES("Pantalones"), NIÑOS("Niños"), BEBES("Bebes"), PLAZAS("Plazas");

private String nombreVista;

private TipoMedida(String nombreVista) {
    this.nombreVista = nombreVista;
}

public String getNombreVista() {
    return nombreVista;
}
}
