package com.hackaton.rest.controller;

import com.hackaton.rest.model.Experiencia;
import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.service.ExperienciaService;
import com.hackaton.rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@RestController
@RequestMapping("/api/Experiencia")
@CrossOrigin("*")
/**
 * Esta clase representa el controlador de experiencia
 */
public class ExperienciaController {
    /**
     * se declara variable privada experienciaService
     *
     *
     */
    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping("/all")
    public List<Experiencia> getAll(){
        return experienciaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Experiencia> getExperiencia(@PathVariable("id") long id) {
        return experienciaService.getExperiencia(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Experiencia save(@RequestBody Experiencia experiencia) {
        return experienciaService.save(experiencia);
    }


}
