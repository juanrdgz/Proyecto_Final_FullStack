/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.servicios;

import com.tienda.sanjuan.repositorios.DireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Franc
 */
@Service
public class DireccionServicio {
    
    @Autowired
    private DireccionRepositorio direccionRepositorio;
    
    
}
