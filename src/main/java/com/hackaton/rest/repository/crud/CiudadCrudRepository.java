package com.hackaton.rest.repository.crud;

import com.hackaton.rest.model.Ciudad;
import org.springframework.data.repository.CrudRepository;

/**
 * esta clase representa la interfaz del crud repository de la clase Ciudad
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
public interface CiudadCrudRepository extends CrudRepository<Ciudad, Long> {
}
