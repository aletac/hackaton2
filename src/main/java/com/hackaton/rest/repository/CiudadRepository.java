package com.hackaton.rest.repository;

import com.hackaton.rest.model.Ciudad;
import com.hackaton.rest.repository.crud.CiudadCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * esta clase representa el repository de la clase Ciudad
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Repository
public class CiudadRepository {
    @Autowired
    /**
     * se declara variable privada ciudadCrudRepository
     */
    private CiudadCrudRepository ciudadCrudRepository;

    /**
     * este metodo
     * @return lista de ciudades
     */
    public List<Ciudad> getAll(){

        return (List<Ciudad>) ciudadCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return findById busqueda por id
     */
    public Optional<Ciudad> getIdCiudad(long id){

        return ciudadCrudRepository.findById(id);
    }

    /**
     *
     * @param ciudad
     * @return guarda una ciudad
     */
    public Ciudad save(Ciudad ciudad){
        return ciudadCrudRepository.save(ciudad);
    }

    /**
     *
     * @param ciudad borra una ciudad
     */
    public void delete(Ciudad ciudad){
        ciudadCrudRepository.delete(ciudad);
    }
}
