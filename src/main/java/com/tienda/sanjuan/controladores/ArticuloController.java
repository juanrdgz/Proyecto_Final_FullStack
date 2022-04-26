/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.controladores;

import com.tienda.sanjuan.entidades.Articulo;
import com.tienda.sanjuan.servicios.ArticuloServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Equipo6
 */

@Controller
@RequestMapping("/articulo")

public class ArticuloController {
    
    
    @Autowired
    ArticuloServicio articuloServicio;

    
    @GetMapping("")
    public String formularioArticulo(Model modelo) {
	Articulo articulo = new Articulo();
	modelo.addAttribute("articulo", articulo);
	return "articulo";
    }

    @PostMapping("/save")
    public String formularioData(@RequestParam("title") String title, @RequestParam("id") String id,
            @RequestParam("price") Double price, @RequestParam("color") String color, 
            @RequestParam("description") String description, @RequestParam("stock") Integer stock,
            @RequestParam("material") String material, @RequestParam("sizea") String sizea, 
            @RequestParam("categorie") String categorie, Model modelo, 
            @RequestParam(name="modificar", required = false) String modificar ) {
	Articulo articulo = new Articulo();
	try {
	    articulo.setTitle(title);
            articulo.setPrice(price);
            articulo.setColor(color);
            articulo.setDescription(description);
            articulo.setStock(stock);
            articulo.setMaterial(material);
            System.out.println("sizea: " + sizea);
            articulo.setSizea(sizea);
            articulo.setCategorie(categorie);
	    articulo.setAlta(true);
	    articulo.setId(id);
	    modelo.addAttribute("articulo", articulo);
	     if(id!= null && !id.isEmpty()) {
		articuloServicio.modificarArticulo(articulo);
	    }
             else{
                 articuloServicio.guardarArticulo(articulo);
             }
             modelo.addAttribute("exito", "articulo guardado con exito");
	    return "articulo";
	} catch (Exception ex) {
	    ex.printStackTrace();
	    modelo.addAttribute("articulo", articulo);
	    modelo.addAttribute("error", ex.getMessage());
	    return "articulo";
	}
    }

    @GetMapping("/modificar")
    public String formulario(@RequestParam(name = "id", required = true) String id, Model modelo) {
	Articulo articulo = articuloServicio.buscarPorId(id);
	modelo.addAttribute("articulo", articulo);
	return "articulo";
    }

    @GetMapping("/list")
    public String listAll(Model modelo) {
	List<Articulo> articulos = articuloServicio.listarArticulos();
	modelo.addAttribute("listaDeArticulos", articulos);
	return "articulo-listar";
    }

    @GetMapping("/alta")
    public String alta(@RequestParam("id") String id) {
	try {
	    articuloServicio.altaArticulo(id);
	    return "redirect:/articulo/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/articulo/list";
	}
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
	try {
	    articuloServicio.bajaArticulo(id);
	    return "redirect:/articulo/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/articulo/list";
	}
    }

    @GetMapping("/eliminar")
    public String eliminarArticulo(@RequestParam("id") String id) {
	try {
	    articuloServicio.eliminarArticulo(id);
	    return "redirect:/articulo/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/articulo/list";
	}
    }
    
    @GetMapping("/compra")
    public String prestamo(@RequestParam("id") String id, RedirectAttributes attributes){
        try {
            articuloServicio.compra(id);
            attributes.addFlashAttribute("exito", "compra realizada");
            return "redirect:/articulo/list";
        } catch (Exception e) {
             e.printStackTrace();
             attributes.addFlashAttribute("error", e.getMessage());
             return "redirect:/articulo/list";    
        }
    }
}
