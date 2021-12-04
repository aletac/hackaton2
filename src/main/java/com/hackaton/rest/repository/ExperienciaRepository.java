package com.hackaton.rest.repository;

import com.hackaton.rest.model.Experiencia;
import com.hackaton.rest.repository.crud.ExperienciaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienciaRepository {

    @Autowired
    private ExperienciaCrudRepository experienciaCrudRepository;

    public List<Experiencia> getAll(){

        return (List<Experiencia>) experienciaCrudRepository.findAll();
    }

    public Optional<Experiencia> getidExp(long id){

        return experienciaCrudRepository.findById(id);
    }

    public Experiencia save(Experiencia experiencia){
        return experienciaCrudRepository.save(experiencia);
    }

    public void delete(Experiencia experiencia){
        experienciaCrudRepository.delete(experiencia);
    }
}
