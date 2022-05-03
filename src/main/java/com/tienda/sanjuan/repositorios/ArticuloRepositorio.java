package com.tienda.sanjuan.repositorios;

import com.tienda.sanjuan.entidades.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticuloRepositorio extends JpaRepository<Articulo, String>{
     @Query("select a from Articulo a where a.title= :title")
    public Articulo buscarPorTitle(@Param("title") String title);
}
