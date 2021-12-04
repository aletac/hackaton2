package com.hackaton.rest.repository.crud;

import com.hackaton.rest.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Long> {

}
