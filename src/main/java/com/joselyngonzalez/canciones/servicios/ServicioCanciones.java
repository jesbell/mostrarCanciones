package com.joselyngonzalez.canciones.servicios;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselyngonzalez.canciones.modelos.Cancion;
import com.joselyngonzalez.canciones.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    
    @Autowired
    private RepositorioCanciones repoCanciones;

    public List<Cancion> obtenerTodasLasCanciones(){
        return this.repoCanciones.findAll();
    }

    public Cancion obtenerCacionPorId(Long id){
        return repoCanciones.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion){
        return repoCanciones.save(cancion);
    }

     public Cancion actualizaCancion(Cancion cancion) {
        if (cancion == null || cancion.getId() == null) {
            return null; 
        }

        Optional<Cancion> opt = repoCanciones.findById(cancion.getId());
        if (opt.isPresent()) {
            Cancion existente = opt.get();
            // tomamos campos editables
            existente.setTitulo(cancion.getTitulo());
            existente.setArtista(cancion.getArtista());
            existente.setAlbum(cancion.getAlbum());
            existente.setGenero(cancion.getGenero());
            existente.setIdioma(cancion.getIdioma());
            // guardamos
            return repoCanciones.save(existente);
        } else {
            return null;
        }
    }

    public void eliminaCancion(Long id) {
        repoCanciones.deleteById(id);
    }


}
