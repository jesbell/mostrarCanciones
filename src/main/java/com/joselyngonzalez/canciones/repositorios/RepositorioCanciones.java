package com.joselyngonzalez.canciones.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joselyngonzalez.canciones.modelos.Cancion;

public interface RepositorioCanciones extends CrudRepository <Cancion, Long> {

    List<Cancion> findAll();
    
}
