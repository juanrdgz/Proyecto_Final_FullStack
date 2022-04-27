
package com.tienda.sanjuan.controladores;

import javax.servlet.http.HttpSession;
import java.util.List;

import com.tienda.sanjuan.entidades.Articulo;
import com.tienda.sanjuan.servicios.OrdenServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orden")
public class OrdenController {
    @Autowired
    private OrdenServicio ordenServicio;

    @GetMapping("")
    public String metodo(Model modelo) {
        return "index";
    }

    @PostMapping("/agregarAlCarrito")
    public String agregar(Model modelo, @ModelAttribute("articulo") Articulo articulo, HttpSession session) {
        List<Articulo> carrito = (List<Articulo>) session.getAttribute("carrito");
        if (carrito == null) {
            // carrito = new List<>();
        }
        carrito.add(articulo);
        session.setAttribute("carrito", carrito);
        return "cart";
    }

    @PostMapping("/quitarDelCarrito")
    public String quitarDelCarrito(Model modelo, @RequestParam("idArticulo") String id, HttpSession session) {
        List<Articulo> carrito = (List<Articulo>) session.getAttribute("carrito");
        for (Articulo articulo : carrito) {
            if (articulo.getId().equals(id)) {
                carrito.remove(articulo);
            }
        }
        session.setAttribute("carrito", carrito);
        // quitar del carrito de la sesion
        return "redirect:/verCarrito";
    }

    @GetMapping("/verCarrito")
    public String verCArrito(Model modelo, HttpSession session) {
        List<Articulo> carrito = (List<Articulo>) session.getAttribute("carrito");
        modelo.addAttribute("carrito", carrito);
        // mostrar carrito de la sesion
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model modelo) {
        // obtener articulos de la sesion
        return "checkout";
    }

    @GetMapping("/hacerPedido")
    public String hacerPedido(Model modelo) {
        // obtener articulos de la sesion
        return "confirmation";
    }
}
