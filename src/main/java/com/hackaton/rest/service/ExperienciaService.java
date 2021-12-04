package com.hackaton.rest.service;

import com.hackaton.rest.model.Experiencia;
import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.repository.ExperienciaRepository;
import com.hackaton.rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> getAll(){
        return experienciaRepository.getAll();

    }
    public Optional<Experiencia> getExperiencia(long id) {
        return experienciaRepository.getidExp(id);
    }

    public Experiencia save(Experiencia experiencia) {
        if (experiencia.getIdExp() == null) {
            return experienciaRepository.save(experiencia);
        } else {
            Optional<Experiencia> elem = experienciaRepository.getidExp(experiencia.getIdExp());
            if (elem.isEmpty()) {
                return experienciaRepository.save(experiencia);
            } else {
                return experiencia;
            }
        }
    }



}
