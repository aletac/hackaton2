package com.hackaton.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="TipoTransporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoTransporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransporte;
    private String tipo;
    private String tipoVehiculo;
    private String empresa;
}
