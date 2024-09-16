package com.sigap.SIGAP.reserva_especial.service;


import com.sigap.SIGAP.excepciones.GlobalExcepcion;

import com.sigap.SIGAP.reserva_especial.entity.ReservaEspecial;
import com.sigap.SIGAP.reserva_especial.repository.ReservaEspecialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ReservaEspecialServiceImpl implements ReservaEspecialService {


    private final ReservaEspecialRepository reservaEspecialRepository;


    @Override
    public ReservaEspecial registrar(ReservaEspecial reservaEspecial) {

        //validarReservaEspecial(reservaEspecial);


        reservaEspecialRepository.findByNumeroIdentificacion(reservaEspecial.getNumeroIdentificacion()).ifPresent(existeNumIdentificacion -> {
            throw new GlobalExcepcion("El Numero de Identificacion " + existeNumIdentificacion.getNumeroIdentificacion() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return reservaEspecialRepository.save(reservaEspecial);


    }

    @Override
    public  ReservaEspecial actualizar(long id, ReservaEspecial reservaEspecial) {
        validarReservaEspecial(reservaEspecial);
        ReservaEspecial reservaEspecialBd = reservaEspecialRepository.findById(reservaEspecial.getId()).orElseThrow();



        reservaEspecialBd.setTipoIdentificacion(reservaEspecial.getTipoIdentificacion());
        reservaEspecialBd.setTipoPersona(reservaEspecial.getTipoPersona());
        reservaEspecialBd.setNumeroIdentificacion(reservaEspecial.getNumeroIdentificacion());
        reservaEspecialBd.setDigitoVerificacion(reservaEspecial.getDigitoVerificacion());
        reservaEspecialBd.setRazonSocial(reservaEspecial.getRazonSocial());
        reservaEspecialBd.setPrimerApeliido(reservaEspecial.getPrimerApeliido());
        reservaEspecialBd.setSegundoApeliido(reservaEspecial.getSegundoApeliido());
        reservaEspecialBd.setPrimerNombre(reservaEspecial.getPrimerNombre());
        reservaEspecialBd.setSegundoNombre(reservaEspecial.getSegundoNombre());
        reservaEspecialBd.setTarjetaProfecional(reservaEspecial.getTarjetaProfecional());
        reservaEspecialBd.setCodigoMunicipio(reservaEspecial.getCodigoMunicipio());
        reservaEspecialBd.setTelefono(reservaEspecial.getTelefono());
        reservaEspecialBd.setDireccion(reservaEspecial.getDireccion());
        reservaEspecialBd.setEmail(reservaEspecial.getEmail());



        return reservaEspecialRepository.save(reservaEspecialBd);


    }

    @Override
    public  ReservaEspecial obtenerPorId(Long id) {
        return reservaEspecialRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Usuario no encontrado"
                        , HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ReservaEspecial> ObtenerTodos() { return reservaEspecialRepository.findAll();
    }

    private void validarReservaEspecial(ReservaEspecial reservaEspecial) {
        if (reservaEspecial.getTipoIdentificacion() == null || reservaEspecial.getTipoIdentificacion().isEmpty()) {
            throw new GlobalExcepcion("El tipo de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getTipoPersona() < 1 || reservaEspecial.getTipoPersona() > 3) {
            throw new GlobalExcepcion("El tipo de persona debe estar entre 1 y 3.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getNumeroIdentificacion() == null || reservaEspecial.getNumeroIdentificacion() <= 0) {
            throw new GlobalExcepcion("El número de identificación no puede estar vacío o ser negativo.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getDigitoVerificacion() < 0 || reservaEspecial.getDigitoVerificacion() > 9) {
            throw new GlobalExcepcion("El dígito de verificación debe estar entre 0 y 9.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getRazonSocial() != null && reservaEspecial.getRazonSocial().length() > 200) {
            throw new GlobalExcepcion("La razón social no puede exceder los 200 caracteres.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getPrimerApeliido() == null || reservaEspecial.getPrimerApeliido().isEmpty()) {
            throw new GlobalExcepcion("El primer apellido no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getSegundoApeliido() != null && reservaEspecial.getSegundoApeliido().length() > 60) {
            throw new GlobalExcepcion("El segundo apellido no puede exceder los 60 caracteres.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getPrimerNombre() == null || reservaEspecial.getPrimerNombre().isEmpty()) {
            throw new GlobalExcepcion("El primer nombre no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getSegundoNombre() != null && reservaEspecial.getSegundoNombre().length() > 60) {
            throw new GlobalExcepcion("El segundo nombre no puede exceder los 60 caracteres.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getTarjetaProfecional() != null && reservaEspecial.getTarjetaProfecional().length() > 20) {
            throw new GlobalExcepcion("La tarjeta profesional no puede exceder los 20 caracteres.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getCodigoMunicipio() == null || reservaEspecial.getCodigoMunicipio().isEmpty()) {
            throw new GlobalExcepcion("El código de municipio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getTelefono() == null || reservaEspecial.getTelefono().isEmpty()) {
            throw new GlobalExcepcion("El teléfono no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getDireccion() == null || reservaEspecial.getDireccion().isEmpty()) {
            throw new GlobalExcepcion("La dirección no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (reservaEspecial.getEmail() == null || !reservaEspecial.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new GlobalExcepcion("El email no es válido.", HttpStatus.BAD_REQUEST);
        }

    }



}



