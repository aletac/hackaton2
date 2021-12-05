package com.hackaton.rest.repository;

import com.hackaton.rest.model.TipoTransporte;
import com.hackaton.rest.repository.crud.TipoTransporteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * esta clase representa el repository de la clase TipoTransporte
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Repository
public class TipoTransporteRepository {
    @Autowired
    private TipoTransporteCrudRepository tipoTransporteCrudRepository;

    /**
     *
     * @return lista de tipo de transporte
     */
    public List<TipoTransporte> getAll(){

        return (List<TipoTransporte>) tipoTransporteCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return busqueda de tipo de transporte por id
     */
    public Optional<TipoTransporte> getidTipoTransporte(long id){

        return tipoTransporteCrudRepository.findById(id);
    }

    /**
     *
     * @param tipoTransporte
     * @return guarda el tipo de transporte
     */
    public TipoTransporte save(TipoTransporte tipoTransporte){
        return tipoTransporteCrudRepository.save(tipoTransporte);
    }

    /**
     *
     * @param tipoTransporte borra tipo de transporte
     */
    public void delete(TipoTransporte tipoTransporte){
        tipoTransporteCrudRepository.delete(tipoTransporte);
    }
}
