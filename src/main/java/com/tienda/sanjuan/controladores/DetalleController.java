package com.tienda.sanjuan.controladores;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import com.tienda.sanjuan.entidades.Articulo;
import com.tienda.sanjuan.entidades.Detalle;
import com.tienda.sanjuan.servicios.DetalleServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/detalle")
public class DetalleController {
    @Autowired
    private DetalleServicio detalleServicio;

    @PostMapping("/agregarAlCarrito")
    public String agregar(Model modelo, @ModelAttribute("articulo") Articulo articulo,
            @RequestParam("cantidad") Integer cantidad, HttpSession session) {
        // agregar al carrito y si ya se encuenta sumarlo
        Boolean esta = false;
        ArrayList<Detalle> carrito = (ArrayList<Detalle>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        } else {
            for (Detalle item : carrito) {
                if (item.getArticulo().getId().equals(articulo.getId())) {
                    // aqui otro if verificando mismo color y tamanio
                    item.setQuantity(item.getQuantity() + cantidad);
                    esta = true;
                }
            }
        }
        if (!esta) {
            Detalle detalle = new Detalle();
            detalle.setArticulo(articulo);
            detalle.setQuantity(cantidad);
            detalle.setPrecioUnit(articulo.getPrice());
            detalle.setSubTotal(cantidad * articulo.getPrice());
            // detalle.setColor(color);
            // detalle.setTamanio(tamanio);
            carrito.add(detalle);
        }
        session.setAttribute("carrito", carrito);
        return "cart";
    }

    @PostMapping("/quitarDelCarrito")
    public String quitarDelCarrito(Model modelo, @RequestParam("posicion") String posicion, HttpSession session) {
        ArrayList<Detalle> carrito = (ArrayList<Detalle>) session.getAttribute("carrito");
        carrito.remove(posicion);
        session.setAttribute("carrito", carrito);
        // quitar un item del carrito de la sesion
        return "redirect:/verCarrito";
    }

    @GetMapping("/verCarrito")
    public String verCArrito(Model modelo, HttpSession session) {
        ArrayList<Detalle> carrito = (ArrayList<Detalle>) session.getAttribute("carrito");
        if (carrito != null) {
            modelo.addAttribute("carrito", carrito);
        } else {
            modelo.addAttribute("vacio", "El carrito esta vacio");
        }
        // mostrar carrito de la sesion
        return "cart";
    }

    @PostMapping("/listar") // ---- Listar los detalles de una orden
    public String listar(Model modelo, @RequestParam("idOrden") String idOrden) {
        modelo.addAttribute("listaDetalles", detalleServicio.listarPorCompra(idOrden));
        return "";
    }
}
