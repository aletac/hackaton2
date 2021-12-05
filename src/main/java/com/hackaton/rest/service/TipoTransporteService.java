package com.hackaton.rest.service;

import com.hackaton.rest.model.TipoTransporte;
import com.hackaton.rest.model.Usuario;
import com.hackaton.rest.repository.TipoTransporteRepository;
import com.hackaton.rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Esta clase define la lógica de negocio de la Entidad TipoTransporte.
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Service
public class TipoTransporteService {
    @Autowired
    private TipoTransporteRepository tipoTransporteRepository;

    /**
     *
     * @return lista de tipo de transporte
     */
    public List<TipoTransporte> getAll(){
        return tipoTransporteRepository.getAll();

    }

    /**
     *
     * @param id
     * @return transporte por id
     */
    public Optional<TipoTransporte> getIdTransporte(long id) {
        return tipoTransporteRepository.getidTipoTransporte(id);
    }

    /**
     *
     * @param tipoTransporte
     * @return guarda un tipo de transporte
     */
    public TipoTransporte save(TipoTransporte tipoTransporte) {
        if (tipoTransporte.getIdTransporte() == null) {
            return tipoTransporteRepository.save(tipoTransporte);
        } else {
            Optional<TipoTransporte> elem = tipoTransporteRepository.getidTipoTransporte(tipoTransporte.getIdTransporte());
            if (elem.isEmpty()) {
                return tipoTransporteRepository.save(tipoTransporte);
            } else {
                return tipoTransporte;
            }
        }
    }

    /**
     *
     * @param id
     * @return elimina tipo de transporte
     */
    public boolean deleteTipoTransporte(long id) {

        Optional<TipoTransporte> tipotrans = getIdTransporte(id);

        if (tipotrans.isEmpty()) {
            return false;
        } else {
            tipoTransporteRepository.delete(tipotrans.get());
            return true;
        }
    }

    /**
     *
     * @param tipoTransporte
     * @return actualiza un transporte
     */
    public TipoTransporte update(TipoTransporte tipoTransporte) {
        if (tipoTransporte.getIdTransporte() != null) {
            Optional<TipoTransporte> tipotrans1 = tipoTransporteRepository.getidTipoTransporte(tipoTransporte.getIdTransporte());
            if (!tipotrans1.isEmpty()) {
                if (tipoTransporte.getTipo() != null) {
                    tipotrans1.get().setTipo(tipoTransporte.getTipo());
                }
                if (tipoTransporte.getTipoVehiculo()!=null){
                    tipotrans1.get().setTipoVehiculo(tipoTransporte.getTipoVehiculo());
                }
                if (tipoTransporte.getEmpresa()!=null){
                    tipotrans1.get().setEmpresa(tipoTransporte.getEmpresa());
                }

                return tipoTransporteRepository.save(tipotrans1.get());
            }
        }
        return tipoTransporte;
    }
}
