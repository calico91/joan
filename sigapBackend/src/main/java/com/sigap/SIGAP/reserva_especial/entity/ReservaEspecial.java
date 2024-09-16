package com.sigap.SIGAP.reserva_especial.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity //esto es una eintidad en la base de datos
@Table(name = "reservaespecial")
@Data
@RequiredArgsConstructor
public class ReservaEspecial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("tipo_identificacion")
    @Column(length = 2, nullable = false)
    private String tipoIdentificacion;

    @JsonProperty("tipo_persona")
    @Column(length = 1, nullable = false)
    private Integer tipoPersona;


    @JsonProperty("numero_identificacion")
    @Column(length = 12, nullable = false, unique = true)
    private Integer numeroIdentificacion;

    @JsonProperty("digito_verificacion")
    @Column(length = 1)
    private int digitoVerificacion;

    @JsonProperty("razon_social")
    @Column(length = 200)
    private String razonSocial;

    @JsonProperty("primer_apellido")
    @Column(length = 60, nullable = false)
    private String primerApeliido;

    @JsonProperty("segundo_apellido")
    @Column(length = 60)
    private String segundoApeliido;

    @JsonProperty("primer_nombre")
    @Column(length = 60, nullable = false)
    private String primerNombre;

    @JsonProperty("segundo_nombre")
    @Column(length = 60)
    private String segundoNombre;

    @JsonProperty("tarjeta_profecional")
    @Column(length = 20)
    private String tarjetaProfecional;

    @JsonProperty("codigo_municipio")
    @Column(length = 5, nullable = false)
    private String codigoMunicipio;


    @Column(length = 22, nullable = false)
    private String telefono;


    @Column(length = 200, nullable = false)
    private String direccion;


    @Column(length = 80,nullable = false)
    private String email;



}
