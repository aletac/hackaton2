package com.hackaton.rest.service;

import com.hackaton.rest.model.Experiencia;
import com.hackaton.rest.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Esta clase define la lógica de negocio de la Entidad Experiencia.
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    /**
     * @return lista de experiencias de usuario
     */
    public List<Experiencia> getAll() {
        return experienciaRepository.getAll();

    }

    /**
     *
     * @param id
     * @return busqueda de experiencia por id
     */
    public Optional<Experiencia> getExperiencia(long id) {
        return experienciaRepository.getidExp(id);
    }

    /**
     *
     * @param experiencia
     * @return guarda una experiencia de usuario
     */
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
