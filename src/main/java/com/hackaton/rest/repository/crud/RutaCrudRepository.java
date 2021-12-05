package com.hackaton.rest.repository.crud;

import com.hackaton.rest.model.Ruta;
import org.springframework.data.repository.CrudRepository;
/**
 * esta clase representa la interfaz del crud repository de la clase Ruta
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
public interface RutaCrudRepository extends CrudRepository<Ruta, Long> {
}
