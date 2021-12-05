package com.hackaton.rest.service;

import com.hackaton.rest.model.Ciudad;
import com.hackaton.rest.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase define la lógica de negocio de la Entidad Ciudad.
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Service
public class CiudadService {
    @Autowired

    private CiudadRepository ciudadRepository;

    /**
     *
     * @return lista de ciudades
     */
    public List<Ciudad> getAll(){
        return ciudadRepository.getAll();

    }

    /**
     *
     * @param id
     * @return ciudad por id
     */
    public Optional<Ciudad> getIdCiudad(long id) {
        return ciudadRepository.getIdCiudad(id);
    }

    /**
     *
     * @param ciudad
     * @return guarda la ciudad
     */
    public Ciudad save(Ciudad ciudad) {
        if (ciudad.getIdCiudad() == null) {
            return ciudadRepository.save(ciudad);
        } else {
            Optional<Ciudad> elem = ciudadRepository.getIdCiudad(ciudad.getIdCiudad());
            if (elem.isEmpty()) {
                return ciudadRepository.save(ciudad);
            } else {
                return ciudad;
            }
        }
    }

    /**
     *
     * @param id
     * @return elimina la ciudad
     */
    public boolean deleteCiudad(long id) {

        Optional<Ciudad> ciudad1 = getIdCiudad(id);

        if (ciudad1.isEmpty()) {
            return false;
        } else {
            ciudadRepository.delete(ciudad1.get());
            return true;
        }
    }

    /**
     *
     * @param ciudad
     * @return actualiza la ciudad
     */
    public Ciudad update(Ciudad ciudad) {
        if (ciudad.getIdCiudad() != null) {
            Optional<Ciudad> ciudad1 = ciudadRepository.getIdCiudad(ciudad.getIdCiudad());
            if (!ciudad1.isEmpty()) {
                if (ciudad.getCiudad() != null) {
                    ciudad1.get().setCiudad(ciudad.getCiudad());
                }


                return ciudadRepository.save(ciudad1.get());
            }
        }
        return ciudad;
    }
}
