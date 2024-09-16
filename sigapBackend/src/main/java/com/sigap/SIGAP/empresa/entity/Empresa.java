package com.sigap.SIGAP.empresa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity //esto es una eintidad en la base de datos
@Table(name = "empresas")
@Data
@RequiredArgsConstructor
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("tipo_identificacion")
    @Column(length = 2, nullable = false)
    private String tipoIdentificacion;

    @JsonProperty("razon_social")
    @Column(length = 200, nullable = false)
    private String razonSocial;

    @JsonProperty("numero_nit")
    @Column(length = 12, nullable = false, unique = true)
    private Integer numeroNit;

    @JsonProperty("digito_verificacion")
    @Column(length = 1, nullable = false)
    private int digitoVerificacion;

    @JsonProperty("tipo_entidad")
    @Column(length = 1, nullable = false)
    private int tipoEntidad;

    @JsonProperty("codigo_municipio")
    @Column(length = 5, nullable = false)
    private String codigoMunicipio;

    @JsonProperty("actividad_economica")
    @Column(length = 4, nullable = false)
    private int actividadEconomica;

    @Column(length = 22, nullable = false)
    private String telefono;

    @Column(length = 200, nullable = false)
    private String direccion;

    @Column(length = 80, nullable = false)
    private String email;

    @JsonProperty("valor_activo")
    @Column(length = 20, nullable = false)
    private Integer valorActivo;

    @JsonProperty("valor_pasivo")
    @Column(length = 20, nullable = false)
    private Integer valorPasivo;

    @JsonProperty("valor_patrimonio")
    @Column(length = 20, nullable = false)
    private Integer valorPatrimonio;

    @JsonProperty("valor_patrimonio_sin_re")
    @Column(length = 20, nullable = false)
    private Integer valorPatrimonioSin;

    @JsonProperty("valor_reserva_especial")
    @Column(length = 20, nullable = false)
    private Integer valorReservaE;

    @JsonProperty("codigo_Contable")
    @Column(length = 8, nullable = false)
    private Integer valorContable;


    @PrePersist
    private void prePersist() {
        tipoIdentificacion = "NI";
        tipoEntidad = 3;

    }

}

