package com.sigap.SIGAP.representante_legal.service;


import com.sigap.SIGAP.excepciones.GlobalExcepcion;
import com.sigap.SIGAP.representante_legal.entity.RepresentanteLegal;
import com.sigap.SIGAP.representante_legal.repository.RepresentanteLegalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RepresentanteLegalServiceImpl implements RepresentateLegalService {


    private final RepresentanteLegalRepository representanteLegalRepository;


    @Override
    public RepresentanteLegal registrar(RepresentanteLegal representanteLegal) {

        validarRepresentanteLegal(representanteLegal);


        representanteLegalRepository.findByNumeroIdentificacion(representanteLegal.getNumeroIdentificacion()).ifPresent(existeNumIdentificacion -> {
            throw new GlobalExcepcion("El Numero de Identificacion " + existeNumIdentificacion.getNumeroIdentificacion() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return representanteLegalRepository.save(representanteLegal);


    }

    @Override
    public RepresentanteLegal actualizar(long id,RepresentanteLegal representanteLegal) {
        validarRepresentanteLegal(representanteLegal);
        RepresentanteLegal representanteLegalBd = representanteLegalRepository.findById(representanteLegal.getId()).orElseThrow();



        representanteLegalBd.setTipoIdentificacion(representanteLegal.getTipoIdentificacion());
        representanteLegalBd.setNumeroIdentificacion(representanteLegal.getNumeroIdentificacion());
        representanteLegalBd.setPrimerApeliido(representanteLegal.getPrimerApeliido());
        representanteLegalBd.setSegundoApeliido(representanteLegal.getSegundoApeliido());
        representanteLegalBd.setPrimerNombre(representanteLegal.getPrimerNombre());
        representanteLegalBd.setSegundoNombre(representanteLegal.getSegundoNombre());
        representanteLegalBd.setCodigoMunicipio(representanteLegal.getCodigoMunicipio());
        representanteLegalBd.setTelefono(representanteLegal.getTelefono());
        representanteLegalBd.setDireccion(representanteLegal.getDireccion());
        representanteLegalBd.setEmail(representanteLegal.getEmail());



        return representanteLegalRepository.save(representanteLegalBd);


    }

    @Override
    public RepresentanteLegal obtenerPorId(Long id) {
        return representanteLegalRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Usuario no encontrado"
                        , HttpStatus.NOT_FOUND));
    }

    @Override
    public List<RepresentanteLegal> ObtenerTodos() { return representanteLegalRepository.findAll();
    }

    private void validarRepresentanteLegal(RepresentanteLegal representanteLegal) {
        if (representanteLegal.getTipoIdentificacion() == null || representanteLegal.getTipoIdentificacion().isEmpty()) {
            throw new GlobalExcepcion("El tipo de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (representanteLegal.getNumeroIdentificacion() == null) {
            throw new GlobalExcepcion("El número de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (representanteLegal.getPrimerApeliido() == null || representanteLegal.getPrimerApeliido().isEmpty()) {
            throw new GlobalExcepcion("El primer apellido no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        // Segundo apellido es opcional, no se valida si está vacío.

        if (representanteLegal.getPrimerNombre() == null || representanteLegal.getPrimerNombre().isEmpty()) {
            throw new GlobalExcepcion("El primer nombre no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        // Segundo nombre es opcional, no se valida si está vacío.

        if (representanteLegal.getCodigoMunicipio() == null || representanteLegal.getCodigoMunicipio().isEmpty()) {
            throw new GlobalExcepcion("El código del municipio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (representanteLegal.getTelefono() == null || representanteLegal.getTelefono().isEmpty()) {
            throw new GlobalExcepcion("El teléfono no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (representanteLegal.getDireccion() == null || representanteLegal.getDireccion().isEmpty()) {
            throw new GlobalExcepcion("La dirección no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (representanteLegal.getEmail() == null || representanteLegal.getEmail().isEmpty()) {
            throw new GlobalExcepcion("El correo electrónico no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
    }



}



