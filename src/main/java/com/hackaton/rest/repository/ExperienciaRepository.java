package com.hackaton.rest.repository;

import com.hackaton.rest.model.Experiencia;
import com.hackaton.rest.repository.crud.ExperienciaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * esta clase representa el repository de la clase Experiencia
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Repository
public class ExperienciaRepository {

    @Autowired
    private ExperienciaCrudRepository experienciaCrudRepository;

    /**
     *
     * @return lista experiencias de usuario
     */
    public List<Experiencia> getAll(){

        return (List<Experiencia>) experienciaCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return experiencia por id
     */
    public Optional<Experiencia> getidExp(long id){

        return experienciaCrudRepository.findById(id);
    }

    /**
     *
     * @param experiencia
     * @return guarda la experiencia
     */
    public Experiencia save(Experiencia experiencia){
        return experienciaCrudRepository.save(experiencia);
    }

    /**
     *
     * @param experiencia borra la experiencia
     */
    public void delete(Experiencia experiencia){
        experienciaCrudRepository.delete(experiencia);
    }
}
