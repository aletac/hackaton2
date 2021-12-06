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
    @GetMapping("/{documento}")
    public Optional<Usuario> getUsuario(@PathVariable("documento") long documento) {
        return usuarioService.getUsuario(documento);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    @DeleteMapping("/{documento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUsuario(@PathVariable long documento) {
        return usuarioService.deleteUsuario(documento);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return usuarioService.emailExists(email);
    }

    @GetMapping("/{email}/{password}")
    public Usuario autenticateUser(@PathVariable("email") String email, @PathVariable("password") String contrasena) {
        return usuarioService.autenticateUser(email, contrasena);
    }
    @GetMapping("/documentoexist/{documento}")
    public boolean emailExists(@PathVariable("documento") Long documento) {
        return usuarioService.documentoExists(documento);
    }
}
