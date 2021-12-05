package com.hackaton.rest.repository;

import com.hackaton.rest.model.Ruta;
import com.hackaton.rest.repository.crud.RutaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * esta clase representa el repository de la clase Ruta
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Repository
public class RutaRepository {
    @Autowired
    private RutaCrudRepository rutaCrudRepository;

    /**
     *
     * @return lista de rutas
     */
    public List<Ruta> getAll(){

        return (List<Ruta>) rutaCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return ruta por id
     */
    public Optional<Ruta> getIdRuta(long id){

        return rutaCrudRepository.findById(id);
    }

    /**
     *
     * @param ruta
     * @return guarda la ruta
     */
    public Ruta save(Ruta ruta){
        return rutaCrudRepository.save(ruta);
    }

    /**
     *
     * @param ruta borra la ruta
     */
    public void delete(Ruta ruta){
        rutaCrudRepository.delete(ruta);
    }
}
