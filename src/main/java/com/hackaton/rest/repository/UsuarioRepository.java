package com.hackaton.rest.repository;

import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.repository.crud.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * esta clase representa el repository de la clase Usuario
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Repository
public class UsuarioRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    /**
     *
     * @return la lista de usuarios
     */
    public List<Usuario> getAll(){

        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    /**
     *
     * @param documento
     * @return usuario por documento
     */
    public Optional<Usuario> getUsuario(long documento){

        return usuarioCrudRepository.findByDocumento(documento);
    }

    /**
     *
     * @param usuario
     * @return guarda usuario
     */
    public Usuario save(Usuario usuario){
        return usuarioCrudRepository.save(usuario);
    }

    /**
     *
     * @param usuario borra el usuario
     */
    public void delete(Usuario usuario){
        usuarioCrudRepository.delete(usuario);
    }

    /**
     *
     * @param email
     * @return boolean validación de existencia de email
     */
    public boolean emailExists(String email) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
     *
     * @param email
     * @param contrasena
     * @return busqueda por email y contraseña
     */
    public Optional<Usuario> autenticateUser(String email, String contrasena) {
        return usuarioCrudRepository.findByEmailAndContrasena(email, contrasena);
    }

    /**
     *
     * @param documento
     * @return booleano de validación de existencia de documento
     */
    public boolean documentoExists(Long documento) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByDocumento(documento);
        return !usuario.isEmpty();
    }
}
