package com.hackaton.rest.service;

import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.getAll();

    }
    public Optional<Usuario> getUsuario(long id) {
        return usuarioRepository.getUsuario(id);
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getIdUsuario() == null) {
            return usuarioRepository.save(usuario);
        } else {
            Optional<Usuario> elem = usuarioRepository.getUsuario(usuario.getIdUsuario());
            if (elem.isEmpty()) {
                return usuarioRepository.save(usuario);
            } else {
                return usuario;
            }
        }
    }

    public boolean deleteUsuario(long id) {

        Optional<Usuario> usuario = getUsuario(id);

        if (usuario.isEmpty()) {
            return false;
        } else {
            usuarioRepository.delete(usuario.get());
            return true;
        }
    }

    /**
     *   private Long idUsuario;
     *     private Long documento;
     *     private String nombre;
     *     private Integer edad;
     *     private String genero;
     *     private Integer telefono;
     *     private String email;
     * @param usuario
     * @return
     */
    public Usuario update(Usuario usuario) {
        if (usuario.getIdUsuario() != null) {
            Optional<Usuario> usuario1 = usuarioRepository.getUsuario(usuario.getIdUsuario());
            if (!usuario1.isEmpty()) {
                if (usuario.getDocumento() != null) {
                    usuario1.get().setDocumento(usuario.getDocumento());
                }
                if (usuario.getNombre()!=null){
                    usuario1.get().setNombre(usuario.getNombre());
                }
                if (usuario.getEdad()!=null){
                    usuario1.get().setEdad(usuario.getEdad());
                }
                if (usuario.getGenero()!=null){
                    usuario1.get().setGenero(usuario.getGenero());
                }
                if (usuario.getTelefono()!=null){
                    usuario1.get().setTelefono(usuario.getTelefono());
                }
                if (usuario.getEmail()!=null) {
                    usuario1.get().setEmail(usuario.getEmail());
                }

                return usuarioRepository.save(usuario1.get());
            }
        }
        return usuario;
    }

}
