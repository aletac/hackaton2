package com.hackaton.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ruta")
    @JsonIgnoreProperties({"rutas","usuario"})


    private List<Experiencia> experiencias;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    @JsonIgnoreProperties({"rutas","usuarios"})

    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name="idTransporte")
    @JsonIgnoreProperties({"rutas","usuarios"})
    private TipoTransporte tipoTransporte;

}
