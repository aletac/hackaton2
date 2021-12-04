package com.hackaton.rest.model;

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
}
