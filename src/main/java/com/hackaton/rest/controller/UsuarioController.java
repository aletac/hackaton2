package com.hackaton.rest.controller;

import com.hackaton.rest.model.Usuario;
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
@RequestMapping("/api/Usuario")
@CrossOrigin("*")
/**
 * Esta clase representa el controlador del usuario
 */
public class UsuarioController {
    /**
     * se declara variable privada usuarioController
     *
     *
     */
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") int id) {
        return usuarioService.getUsuario(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUsuario(@PathVariable int id) {
        return usuarioService.deleteUsuario(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }
}
