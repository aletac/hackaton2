package com.hackaton.rest.controller;

import com.hackaton.rest.model.TipoTransporte;
import com.hackaton.rest.service.TipoTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@RestController
@RequestMapping("/api/Tipotransporte")
@CrossOrigin("*")
/**
 * Esta clase representa el controlador del TipoTransporte
 */
public class TipoTransporteController {
    /**
     * se declara variable privada tipoTransporteService
     */
    @Autowired
    private TipoTransporteService tipoTransporteService;

    @GetMapping("/all")
    public List<TipoTransporte> getAll() {
        return tipoTransporteService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoTransporte> getidTransporte(@PathVariable("id") long id) {
        return tipoTransporteService.getIdTransporte(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoTransporte save(@RequestBody TipoTransporte tipoTransporte) {
        return tipoTransporteService.save(tipoTransporte);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteTipoTransporte(@PathVariable long id) {
        return tipoTransporteService.deleteTipoTransporte(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoTransporte updateTipoTransporte(@RequestBody TipoTransporte tipoTransporte) {
        return tipoTransporteService.update(tipoTransporte);
    }
}
