package com.hackaton.rest.repository;

import com.hackaton.rest.model.Ciudad;
import com.hackaton.rest.model.TipoTransporte;
import com.hackaton.rest.repository.crud.CiudadCrudRepository;
import com.hackaton.rest.repository.crud.TipoTransporteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CiudadRepository {
    @Autowired
    private CiudadCrudRepository ciudadCrudRepository;

    public List<Ciudad> getAll(){

        return (List<Ciudad>) ciudadCrudRepository.findAll();
    }

    public Optional<Ciudad> getIdCiudad(long id){

        return ciudadCrudRepository.findById(id);
    }

    public Ciudad save(Ciudad ciudad){
        return ciudadCrudRepository.save(ciudad);
    }

    public void delete(Ciudad ciudad){
        ciudadCrudRepository.delete(ciudad);
    }
}
