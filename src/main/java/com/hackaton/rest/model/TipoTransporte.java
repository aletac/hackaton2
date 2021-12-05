package com.hackaton.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="TipoTransporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Esta clase representa a la entidad Tipo Transporte
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
public class TipoTransporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id del Tipo de transporte
     */
    private Long idTransporte;
    /**
     * tipo de transporte
     */
    private String tipo;
    /**
     * tipo de vehículo
     */
    private String tipoVehiculo;
    /**
     * empresa del vehículo
     */
    private String empresa;

    /**
     * relaciones entre entidades
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tipoTransporte")
    @JsonIgnoreProperties({"tipoTransporte","rutas","experiencias"})
    /**
     * lista de usuarios
     */
    private List<Usuario> usuarios;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="tipoTransporte")
    @JsonIgnoreProperties({"tipoTransportes","rutas","experiencias"})
    /**
     * Lista de rutas
     */
    private List<Ruta> rutas;
}

