package com.hackaton.rest.repository.crud;

import com.hackaton.rest.model.Usuario;
import org.springframework.data.repository.CrudRepository;
/**
 * esta clase representa la interfaz del crud repository de la clase Usuario
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
public interface UsuarioCrudRepository extends CrudRepository<Usuario,Long> {

}
