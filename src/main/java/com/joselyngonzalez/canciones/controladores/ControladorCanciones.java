package com.joselyngonzalez.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.joselyngonzalez.canciones.modelos.Artista;
import com.joselyngonzalez.canciones.modelos.Cancion;
import com.joselyngonzalez.canciones.servicios.ServicioArtistas;
import com.joselyngonzalez.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;
    @Autowired
    private ServicioArtistas servicioArtistas;

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

        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("cancion", new Cancion());
        model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult resultado, @RequestParam(value = "artistaId", required = false) Long artistaId, Model model) {

        // Validación del artista
        if (artistaId == null) {
            model.addAttribute("errorArtista", "Debe seleccionar un artista.");
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion.jsp";
        }
        
        if (resultado.hasErrors()) {
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion.jsp";
        }

        

        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancion.setArtista(artista);

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
        model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        model.addAttribute("artistaId", cancion.getArtista().getId()); 
        return "editarCancion.jsp";
    }

    // editando canción
    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion, 
    @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, 
      @RequestParam(value = "artistaId", required = false) Long artistaId, Model model) {
        
        cancion.setId(idCancion);

        if (artistaId == null) {
            model.addAttribute("errorArtista", "Debe seleccionar un artista.");
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion.jsp";
        }

        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancion.setArtista(artista);

        if (resultado.hasErrors()) {
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion.jsp";
        }

        

        servicio.actualizaCancion(cancion);

        return "redirect:/canciones";
    }

    //eliminar cancion
    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long id) {
        servicio.eliminaCancion(id);
        return "redirect:/canciones";
    }
    

}
