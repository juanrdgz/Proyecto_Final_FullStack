/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.repositorios;

import com.tienda.sanjuan.entidades.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Equipo6
 */

public interface ArticuloRepositorio extends JpaRepository<Articulo, String>{
     @Query("select a from Articulo a where a.title= :title")
    public Articulo buscarPorTitle(@Param("title") String title);
    
     @Query("select a from Articulo a where a.destacado= :destacado")
    public Articulo articuloDestacado(@Param("destacado") Boolean destacado);
}
  
