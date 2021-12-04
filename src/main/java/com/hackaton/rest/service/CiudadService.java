package com.hackaton.rest.service;

import com.hackaton.rest.model.Ciudad;
import com.hackaton.rest.model.TipoTransporte;
import com.hackaton.rest.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> getAll(){
        return ciudadRepository.getAll();

    }
    public Optional<Ciudad> getIdCiudad(long id) {
        return ciudadRepository.getIdCiudad(id);
    }

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

    /**
     * private Long idTransporte;
     *     private String tipo;
     *     private String tipoVehiculo;
     *     private String empresa;
     * @param tipoTransporte
     * @return
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
