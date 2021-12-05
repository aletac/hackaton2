package com.hackaton.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase representa a la entidad Ciudad
 * @author Grupo hackaton Edgar, Elías, Adolfo, Jorge, Juan
 */
@Entity
@Table(name = "Ciudad")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ciudad implements Serializable {
    /**
     * id de la ciudad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;
    /**
     * Ciudad
     */
    private String Ciudad;

     @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "usuario")
    @JsonIgnoreProperties({"ciudad"})



    private List<Usuario> usuarios;
}
