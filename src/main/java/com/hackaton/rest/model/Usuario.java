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
     * telefono usuario
     */
    private Integer telefono;
    /**
     * email usuario
     */
    private String email;
    /**
     * password usuario
     */
    private String contrasena;



    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "experiencia")
    @JsonIgnoreProperties({"usuario"})
    /**
     * Reservaciones asociadas con la bicileta
     */
    public List<Experiencia> experiencias;

    @ManyToOne
    @JoinColumn(name = "usuario_id_ciudad")
    private Ciudad usuario;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tipotransporte")
    @JsonIgnoreProperties({"usuario"})
    public List<TipoTransporte> tipoTransportes;

    public Ciudad getUsuario() {
        return usuario;
    }

    public void setUsuario(Ciudad usuario) {
        this.usuario = usuario;
    }


}







