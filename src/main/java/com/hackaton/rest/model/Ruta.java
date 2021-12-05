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
/**
 * Esta clase representa a la entidad Ruta
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id de la ruta
     */
    private Long idRuta;
    /**
     * origen ruta
     */
    private String origen;
    /**
     * destino ruta
     */
    private String destino;
    /**
     * tiempo real ruta
     */
    private Integer tiempoReal;
    /**
     * tiempo estimado ruta
     */
    private Integer tiempoEstimado;
    /**
     * costo ruta
     */
    private Integer costo;
    /**
     * relaciones entre entidades
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ruta")
    @JsonIgnoreProperties({"rutas","usuario"})
/**
 * experiencias del usuario en la ruta
 */

    private List<Experiencia> experiencias;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    @JsonIgnoreProperties({"rutas","usuarios"})
    /**
     * ciudad ruta
     */

    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name="idTransporte")
    @JsonIgnoreProperties({"rutas","usuarios"})
    /**
     * tipo de transporte empleado en la ruta
     */
    private TipoTransporte tipoTransporte;

}
