package com.hackaton.rest.repository;

import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.repository.crud.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<Usuario> getAll(){

        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    public Optional<Usuario> getUsuario(long id){

        return usuarioCrudRepository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return usuarioCrudRepository.save(usuario);
    }

    public void delete(Usuario usuario){
        usuarioCrudRepository.delete(usuario);
    }

}
