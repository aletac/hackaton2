package com.hackaton.rest.repository.crud;

import com.hackaton.rest.model.Ciudad;
import org.springframework.data.repository.CrudRepository;

public interface CiudadCrudRepository extends CrudRepository<Ciudad, Long> {
}
