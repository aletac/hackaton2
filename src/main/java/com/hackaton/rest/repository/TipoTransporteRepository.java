package com.hackaton.rest.repository;

import com.hackaton.rest.model.TipoTransporte;
import com.hackaton.rest.repository.crud.TipoTransporteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoTransporteRepository {
    @Autowired
    private TipoTransporteCrudRepository tipoTransporteCrudRepository;

    public List<TipoTransporte> getAll(){

        return (List<TipoTransporte>) tipoTransporteCrudRepository.findAll();
    }

    public Optional<TipoTransporte> getidTipoTransporte(long id){

        return tipoTransporteCrudRepository.findById(id);
    }

    public TipoTransporte save(TipoTransporte tipoTransporte){
        return tipoTransporteCrudRepository.save(tipoTransporte);
    }

    public void delete(TipoTransporte tipoTransporte){
        tipoTransporteCrudRepository.delete(tipoTransporte);
    }
}
