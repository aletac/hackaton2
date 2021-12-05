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
    @JoinColumn(name = "experiencia_id_usuario")
    private Usuario experiencia;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="experiencia")
    @JsonIgnoreProperties("experiencia")
    private Ruta ruta;


    public Usuario getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Usuario experiencia) {
        this.experiencia = experiencia;
    }
}
