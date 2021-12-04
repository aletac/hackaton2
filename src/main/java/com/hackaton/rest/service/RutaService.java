package com.hackaton.rest.service;

import com.hackaton.rest.model.Ciudad;
import com.hackaton.rest.model.Ruta;
import com.hackaton.rest.repository.CiudadRepository;
import com.hackaton.rest.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> getAll(){
        return rutaRepository.getAll();

    }
    public Optional<Ruta> getIdRuta(long id) {
        return rutaRepository.getIdRuta(id);
    }

    public Ruta save(Ruta ruta) {
        if (ruta.getIdRuta() == null) {
            return rutaRepository.save(ruta);
        } else {
            Optional<Ruta> elem = rutaRepository.getIdRuta(ruta.getIdRuta());
            if (elem.isEmpty()) {
                return rutaRepository.save(ruta);
            } else {
                return ruta;
            }
        }
    }

    public boolean deleteRuta(long id) {

        Optional<Ruta> ruta1 = getIdRuta(id);

        if (ruta1.isEmpty()) {
            return false;
        } else {
            rutaRepository.delete(ruta1.get());
            return true;
        }
    }



    public Ruta update(Ruta ruta) {
        if (ruta.getIdRuta() != null) {
            Optional<Ruta> ruta1 = rutaRepository.getIdRuta(ruta.getIdRuta());
            if (!ruta1.isEmpty()) {
                if (ruta.getOrigen() != null) {
                    ruta1.get().setOrigen(ruta.getOrigen());
                }
                if (ruta.getDestino()!=null){
                    ruta1.get().setDestino(ruta.getDestino());
                }
                if (ruta.getTiempoReal()!=null){
                    ruta1.get().setTiempoReal(ruta.getTiempoReal());
                }
                if (ruta.getTiempoEstimado()!=null){
                    ruta1.get().setTiempoEstimado(ruta.getTiempoEstimado());
                }
                if (ruta.getCosto()!=null){
                    ruta1.get().setCosto(ruta.getCosto());

                }

                return rutaRepository.save(ruta1.get());
            }
        }
        return ruta;
    }
}
/**
 * private Long idRuta;
 *     private String origen;
 *     private String destino;
 *     private Integer tiempoReal;
 *     private Integer tiempoEstimado;
 *     private Integer costo;
 */