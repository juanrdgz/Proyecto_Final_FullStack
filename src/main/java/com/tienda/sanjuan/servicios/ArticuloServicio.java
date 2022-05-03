/*
Articulo change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.servicios;

import com.tienda.sanjuan.entidades.Articulo;
import com.tienda.sanjuan.repositorios.ArticuloRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Equipo6
 */
@Service
public class ArticuloServicio {

    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    public Articulo guardarArticulo(Articulo articulo) throws Exception {
        if (articulo.getTitle().isEmpty()) {
            throw new Exception("El titulo del articulo no puede estar vacio");
        }
        if(articuloRepositorio.buscarPorTitle(articulo.getTitle()) != null){
            throw new Exception("Ya existe el articulo");
        }
        if (articulo.getPrice() == 0 || articulo.getPrice() == null) {
            throw new Exception("El precio del articulo no puede ser 0 o vacio");
        }
        if (articulo.getColor() == null) {
            throw new Exception("El color del articulo no puede estar vacio");
        }
        if (articulo.getMaterial() == null) {
            throw new Exception("El material del articulo no puede estar vacio");
        }
        if (articulo.getCategorie()== null) {
            throw new Exception("La categoría del articulo no puede estar vacio");
        }
        if (articulo.getStock() == 0 || articulo.getStock() == null) {
            throw new Exception("El stock del articulo no puede ser 0 o vacio");
        }
        if (articulo.getSizea()== null) {
                    throw new Exception("El talle del articulo no puede estar vacio");
                }
        return articuloRepositorio.save(articulo);
    }

    public Articulo modificarArticulo(Articulo articulo) throws Exception {
                if (articulo.getTitle().isEmpty()) {
                    throw new Exception("El nuevo titulo del articulo no puede estar vacio");
                }
                if (articulo.getPrice() == 0 || articulo.getPrice()== null) {
                    throw new Exception("El nuevo preciodel articulo no puede estar vacio o nulo");
                }
                if (articulo.getColor() == null) {
                    throw new Exception("El nuevo color no puede estar vacio");
                }
                if (articulo.getMaterial() == null) {
                    throw new Exception("El nuevo material del articulo no puede estar vacio");
                }
                if (articulo.getCategorie()==null) {
                    throw new Exception("La nueva categoria no puede estar vacia");
                }
                if (articulo.getSizea() == null) {
                    throw new Exception("El nuevo talle del articulo no puede estar vacio");
                }
        return articuloRepositorio.save(articulo);
    }

    public List<Articulo> listarArticulos() {
        return articuloRepositorio.findAll();
    }

    public Articulo buscarPorTitle(String title) {
        return articuloRepositorio.buscarPorTitle(title);
    }

     public void articuloDestacado(String id) throws Error {
        Optional<Articulo> respuesta = articuloRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Articulo articulo = respuesta.get();
            articulo.setDestacado(true);
            articuloRepositorio.save(articulo);
        } else {
            throw new Error("No se encontró un articulo con ese nombre");

        }
    }
     public Articulo articuloNoDestacado(Articulo articulo) {
        articulo.setDestacado(false);
        return articuloRepositorio.save(articulo);
    }
     
     public List<Articulo> listardestacados(){
         return articuloRepositorio.findDestacados();
     }
    
    public Articulo buscarPorId(String id) {
        return articuloRepositorio.getById(id);
    }

    
    public void altaArticulo(String id) throws Error {
        Optional<Articulo> respuesta = articuloRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Articulo articulo = respuesta.get();
            articulo.setAlta(true);
            articuloRepositorio.save(articulo);
        } else {
            throw new Error("No se encontró un articulo con ese nombre");

        }
    }

    public Articulo darBaja(Articulo articulo) {
        articulo.setAlta(false);
        return articuloRepositorio.save(articulo);
    }
    
    public void bajaArticulo(String id) throws Error {
        Optional<Articulo> respuesta = articuloRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Articulo articulo = respuesta.get();
            articulo.setAlta(false);
            articuloRepositorio.save(articulo);
        } else {
            throw new Error("No se encontró una libro con ese nombre");
        }
    }

    public void eliminarArticulo(String id) throws Error {
        Articulo articulo = articuloRepositorio.getById(id);
        if (articulo == null) {
            throw new Error("El autor no existe en la base de datos");
        } else {
            articuloRepositorio.delete(articulo);
        }
    }
    
     public void compra(String id) throws Exception{
         Articulo articulo= articuloRepositorio.getById(id);
         if(articulo.getStock()-1 <0){
             throw new Exception("Sin stock");
         }
         
         articulo.setStock(articulo.getStock() - 1);
         articuloRepositorio.save(articulo);
     }
}
