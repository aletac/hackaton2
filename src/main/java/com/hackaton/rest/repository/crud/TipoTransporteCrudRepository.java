package com.hackaton.rest.repository.crud;

import com.hackaton.rest.model.TipoTransporte;
import org.springframework.data.repository.CrudRepository;
/**
 * esta clase representa la interfaz del crud repository de la clase TipoTransporte
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
public interface TipoTransporteCrudRepository extends CrudRepository<TipoTransporte, Long> {
}
