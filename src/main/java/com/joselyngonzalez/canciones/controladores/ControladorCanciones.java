package com.joselyngonzalez.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.joselyngonzalez.canciones.modelos.Cancion;
import com.joselyngonzalez.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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
    
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "agregarCancion.jsp";
        }

        servicio.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    // mostrar info de la canción
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCacionPorId(idCancion);
        if (cancion == null) {
            return "redirect:/canciones";
        }
        model.addAttribute("cancion", cancion);
        return "editarCancion.jsp";
    }

    // editando canción
    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion, 
    @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, Model model) {
        
        cancion.setId(idCancion);

        if (resultado.hasErrors()) {
            return "editarCancion.jsp";
        }

        Cancion actualizado = servicio.actualizaCancion(cancion);
        if (actualizado == null) {
            return "redirect:/canciones";
        }

        return "redirect:/canciones";
    }
    

}
