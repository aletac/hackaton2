package com.hackaton.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase representa a la entidad Usuario
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Entity
@Table(name ="Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario implements Serializable {
    /**
     * Codigo del usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    /**
     * documento usuario
     */
    @Column(unique=true)
    private Long documento;
    /**
     * nombre usuario
     */
    private String nombre;
    /**
     * edad usuario
     */
    private Integer edad;
    /**
     * genero usuario
     */
    private String genero;
    /**
     * teléfono usuario
     */
    private Integer telefono;
    /**
     * email usuario
     */
    @Column(unique=true)
    private String email;
    /**
     * password usuario
     */
    private String contrasena;
    /**
     * rol usuario
     */
    private String role;


    /**
     * relaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "usuario")
    @JsonIgnoreProperties({"usuario","tipoTransporte"})

    public List<Experiencia> experiencias;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    @JsonIgnoreProperties({"usuarios","rutas"})
    /**
     * ciudades
     */
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "idTransporte")
    @JsonIgnoreProperties({"usuarios","rutas"})
    /**
     * tipo de transporte
     */
    private TipoTransporte tipoTransporte;



}







