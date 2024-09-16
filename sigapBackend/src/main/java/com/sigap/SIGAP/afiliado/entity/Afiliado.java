package com.sigap.SIGAP.afiliado.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;



import java.time.LocalDate;
@Entity //esto es una eintidad en la base de datos
@Table(name = "afiliados")
@Data
@RequiredArgsConstructor

public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("tipo_documento")
    @Column(length = 2, nullable = false)
    private String tipoDocumento;

    @JsonProperty("numero_identificacion")
    @Column(length = 12, nullable = false, unique = true)
    private Integer numeroIdentificacion;

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

    @JsonProperty("fecha_nacimiento")
    @Column(length = 10, nullable = false)
    private LocalDate fechaNacimiento;


    @Column(length = 1, nullable = false)
    private String genero;

    @JsonProperty("codigo_municipio")
    @Column(length = 5, nullable = false)
    private String codigoMunicipio;

    @Column(length = 1, nullable = false)
    private String indicador;

    @Column(length = 22, nullable = false)
    private String telefono;

    @Column(length = 200, nullable = false)
    private String direccion;

    @Column(length = 80)
    private String email;

    @JsonProperty("fecha_ingreso")
    @Column(length = 10, nullable = false)
    private LocalDate fechaIngreso;

    @JsonProperty("fecha_retiro")
    @Column(length = 10)
    private LocalDate fechaRetiro;

    /*@PrePersist
    private void prePersist() {
        tipoIdentificacion = "NI";
        tipoEntidad = 3;

    }*/

}
