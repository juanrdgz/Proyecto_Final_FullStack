package com.tienda.sanjuan.entidades;

import com.tienda.sanjuan.enums.Color;
import com.tienda.sanjuan.enums.Material;
import com.tienda.sanjuan.enums.Pantalon;
import com.tienda.sanjuan.enums.RopaBebe;
import com.tienda.sanjuan.enums.RopaNinio;
import com.tienda.sanjuan.enums.RopaNormal;
import com.tienda.sanjuan.enums.TipoMedida;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private Color color;
    private String description;
    private Integer stock;
    @Enumerated(EnumType.STRING)
    private Material material;
    @Enumerated(EnumType.STRING)
    private TipoMedida tm; // preguntar si tenemos que poner 3 Enum por cada medidad de talles
    @Enumerated(EnumType.STRING)
    private RopaNormal rn;
    @Enumerated(EnumType.STRING)
    private Pantalon p ;
    @Enumerated(EnumType.STRING)
    private RopaNinio rni;
    @Enumerated(EnumType.STRING)
    private RopaBebe rb;
   
    private String medida;
    @ManyToOne
    private Categoria categoria;
    private Boolean alta = true;
    private Boolean destacado = false;

    public Articulo() {
    }

    public Articulo(String id, String title, Double price, Color color, String description, Integer stock, Material material, Medida sizea, Categoria categoria, Boolean alta, Boolean destacado) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.color = color;
        this.description = description;
        this.stock = stock;
        this.material = material;
        this.categoria = categoria;
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


    public Categoria getCategorie() {
        return categoria;
    }

    public void setCategorie(Categoria categoria) {
        this.categoria = categoria;
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

}
