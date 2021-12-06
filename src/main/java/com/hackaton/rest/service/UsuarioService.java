package com.hackaton.rest.service;

import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Esta clase define la lógica de negocio de la Entidad Usuario.
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     *
     * @return lista de usuarios
     */
    public List<Usuario> getAll(){
        return usuarioRepository.getAll();

    }

    /**
     *
     * @param documento
     * @return usuario por id
     */
    public Optional<Usuario> getUsuario(long documento) {
        return usuarioRepository.getUsuario(documento);
    }

    /**
     *
     * @param usuario
     * @return guarda el usuario
     */
    public Usuario save(Usuario usuario) {
        if (usuario.getDocumento() == null) {
            return usuarioRepository.save(usuario);
        } else {
            Optional<Usuario> elem = usuarioRepository.getUsuario(usuario.getDocumento());
            if (elem.isEmpty()) {
                return usuarioRepository.save(usuario);
            } else {
                return usuario;
            }
        }
    }

    /**
     *
     * @param documento
     * @return elimina usuario por documento
     */
    public boolean deleteUsuario(long documento) {

        Optional<Usuario> usuario = getUsuario(documento);

        if (usuario.isEmpty()) {
            return false;
        } else {
            usuarioRepository.delete(usuario.get());
            return true;
        }
    }

    /**
     *
     * @param usuario
     * @return actualiza usuario
     */
    public Usuario update(Usuario usuario) {
        if (usuario.getDocumento() != null) {
            Optional<Usuario> usuario1 = usuarioRepository.getUsuario(usuario.getDocumento());
            if (!usuario1.isEmpty()) {
                if (usuario.getDocumento() != null) {
                    usuario1.get().setDocumento(usuario.getDocumento());
                }
                if (usuario.getNombre()!=null){
                    usuario1.get().setNombre(usuario.getNombre());
                }
                if (usuario.getApellido()!=null){
                    usuario1.get().setApellido(usuario.getApellido());
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
                if (usuario.getContrasena()!=null) {
                    usuario1.get().setContrasena(usuario.getContrasena());
                }
                if (usuario.getRole()!=null) {
                    usuario1.get().setRole(usuario.getRole());
                }
                if (usuario.getCiudad()!=null) {
                    usuario1.get().setCiudad(usuario.getCiudad());
                }
                if (usuario.getTipoTransporte()!=null) {
                    usuario1.get().setTipoTransporte(usuario.getTipoTransporte());
                }

                return usuarioRepository.save(usuario1.get());
            }
        }
        return usuario;
    }

    /**
     *
     * @param email
     * @return boolean validación existencia de email.
     */
    public boolean emailExists(String email) {
        return usuarioRepository.emailExists(email);
    }

    /**
     *
     * @param email
     * @param password
     * @return datos de usuario autenticado
     */
    public Usuario autenticateUser(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new Usuario();
        } else {
            return usuario.get();
        }
    }

    /**
     *
     * @param documento
     * @return booleano validación documento
     */
    public boolean documentoExists(Long documento) {
        return usuarioRepository.documentoExists(documento);
    }
}
