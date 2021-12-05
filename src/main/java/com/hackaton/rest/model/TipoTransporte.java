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
public class TipoTransporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransporte;
    private String tipo;
    private String tipoVehiculo;
    private String empresa;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tipoTransporte")
    @JsonIgnoreProperties({"tipoTransporte","rutas","experiencias"})
    private List<Usuario> usuarios;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="tipoTransporte")
    @JsonIgnoreProperties({"tipoTransportes","rutas","experiencias"})
    private List<Ruta> rutas;

}
