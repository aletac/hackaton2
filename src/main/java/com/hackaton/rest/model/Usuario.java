package com.hackaton.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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








}
