package com.hackaton.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Ruta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;
    private String origen;
    private String destino;
    private Integer tiempoReal;
    private Integer tiempoEstimado;
    private Integer costo;

    @OneToOne
    @JoinColumn(name="idExp")
    @JsonIgnoreProperties("ruta")
    private Experiencia experiencia;


}
