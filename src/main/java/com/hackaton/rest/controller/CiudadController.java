package com.hackaton.rest.controller;

import com.hackaton.rest.model.Ciudad;
import com.hackaton.rest.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@RestController
@RequestMapping("/api/Ciudad")
@CrossOrigin("*")
/**
 * controlador Ciudad
 */
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/all")
    public List<Ciudad> getAll() {
        return ciudadService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ciudad> getIdCiudad(@PathVariable("id") long id) {
        return ciudadService.getIdCiudad(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad save(@RequestBody Ciudad ciudad) {
        return ciudadService.save(ciudad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCiudad(@PathVariable long id) {
        return ciudadService.deleteCiudad(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad updateCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.update(ciudad);
    }
}
