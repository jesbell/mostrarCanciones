package com.joselyngonzalez.canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselyngonzalez.canciones.modelos.Artista;
import com.joselyngonzalez.canciones.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repoArtistas;

    public List<Artista> obtenerTodosLosArtistas() {
        return repoArtistas.findAll();
    }

    public Artista obtenerArtistaPorId(Long id) {
        return repoArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista) {
        return repoArtistas.save(artista);
    }
    
}
