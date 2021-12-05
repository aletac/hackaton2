package com.hackaton.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
     * Esta clase representa a la entidad Experiencia
     * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
     */
@Entity
@Table(name ="Experiencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia implements Serializable {
    /**
     * Codigo experiencia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExp;
    /**
     * comentario
     */
    private String comentario;
    /**
     * calificación
     */
    private Integer califica;

    @ManyToOne
    @JoinColumn(name = "documento")
    @JsonIgnoreProperties({"experiencias","rutas","tipoTransporte"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    @JsonIgnoreProperties({"experiencias","rutas"})
    private Ruta ruta;

}
