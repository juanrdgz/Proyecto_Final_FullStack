/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.sanjuan.controladores;

import com.tienda.sanjuan.entidades.Usuario;
import com.tienda.sanjuan.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Franc
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("")
    private String formularioUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "signin";
    }

    @PostMapping("/guardar")
    private String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        try {
            usuarioServicio.registrarUsuario(usuario);
            modelo.addAttribute("success", "Tarea guardada con exito");
        } catch (Exception ex) {
            modelo.addAttribute("error", ex.getMessage());
        }
        return "signin";
    }

    @GetMapping("/listar")
    private String listarUsuarios(Model modelo) {
        List<Usuario> usuarios = usuarioServicio.findAll();
        modelo.addAttribute("usuarios", usuarios);
        return "";
    }

}
