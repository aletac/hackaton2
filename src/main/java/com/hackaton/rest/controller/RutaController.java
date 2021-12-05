package com.hackaton.rest.controller;

import com.hackaton.rest.model.Ruta;
import com.hackaton.rest.service.CiudadService;
import com.hackaton.rest.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ruta")
@CrossOrigin("*")
/**
 * controlador Ruta
 */
public class RutaController {
    @Autowired
    private RutaService rutaService;

    @GetMapping("/all")
    public List<Ruta> getAll() {
        return rutaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ruta> getIdRuta(@PathVariable("id") long id) {
        return rutaService.getIdRuta(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ruta save(@RequestBody Ruta ruta) {
        return rutaService.save(ruta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteRuta(@PathVariable long id) {
        return rutaService.deleteRuta(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ruta updateRuta(@RequestBody Ruta ruta) {
        return rutaService.update(ruta);
    }
}
