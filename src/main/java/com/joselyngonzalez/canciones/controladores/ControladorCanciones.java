package com.joselyngonzalez.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.joselyngonzalez.canciones.servicios.ServicioCanciones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("listaCanciones", servicio.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("cancion", servicio.obtenerCacionPorId(id));
        return "detalleCancion.jsp";
    }
    
    
    
}
