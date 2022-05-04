package com.tienda.sanjuan.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String title;
    private Double price;
    @OneToOne
    private Color color;
    private String description;
    private Integer stock;
    @OneToOne
    private Material material;
    @OneToOne
    private Medida sizea;
    private String dimension;
    @ManyToOne
    private Categoria categorie;
    private Boolean alta = true;
    private Boolean destacado = false;

    public Articulo() {
    }

    public Articulo(String id, String title, Double price, Color color, String description, Integer stock, Material material, Medida sizea, Categoria categorie, Boolean alta, Boolean destacado) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.color = color;
        this.description = description;
        this.stock = stock;
        this.material = material;
        this.sizea = sizea;
        this.categorie = categorie;
        this.alta = alta;
        this.destacado = destacado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Medida getSizea() {
        return sizea;
    }

    public void setSizea(Medida sizea) {
        this.sizea = sizea;
    }

    public Categoria getCategorie() {
        return categorie;
    }

    public void setCategorie(Categoria categorie) {
        this.categorie = categorie;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Boolean getDestacado() {
        return destacado;
    }

    public void setDestacado(Boolean destacado) {
        this.destacado = destacado;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", title=" + title + ", price=" + price + ", color=" + color + 
                ", description=" + description + ", stock=" + stock + ", material=" + material + ", sizea=" + sizea
                + ", categorie=" + categorie + ", alta=" + alta + ", destacado=" + destacado + '}';
    }
}
