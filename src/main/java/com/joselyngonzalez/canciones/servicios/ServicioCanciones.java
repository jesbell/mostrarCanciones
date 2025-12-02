package com.joselyngonzalez.canciones.servicios;

import java.util.List;

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
}
