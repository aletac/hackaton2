package com.hackaton.rest.repository;

import com.hackaton.rest.model.Ruta;
import com.hackaton.rest.repository.crud.RutaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RutaRepository {
    @Autowired
    private RutaCrudRepository rutaCrudRepository;

    public List<Ruta> getAll(){

        return (List<Ruta>) rutaCrudRepository.findAll();
    }

    public Optional<Ruta> getIdRuta(long id){

        return rutaCrudRepository.findById(id);
    }

    public Ruta save(Ruta ruta){
        return rutaCrudRepository.save(ruta);
    }

    public void delete(Ruta ruta){
        rutaCrudRepository.delete(ruta);
    }
}
