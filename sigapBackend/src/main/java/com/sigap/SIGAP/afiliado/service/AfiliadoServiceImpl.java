package com.sigap.SIGAP.afiliado.service;


import com.sigap.SIGAP.afiliado.entity.Afiliado;
import com.sigap.SIGAP.afiliado.repository.AfiliadoRepository;
import com.sigap.SIGAP.excepciones.GlobalExcepcion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AfiliadoServiceImpl implements AfiliadoService{

    private final AfiliadoRepository afiliadoRepository;


    @Override
    public Afiliado registrar(Afiliado afiliado) {
        validarAfiliado(afiliado);
        afiliadoRepository.findByNumeroIdentificacion(afiliado.getNumeroIdentificacion()).ifPresent(existeNumIdentificacion -> {
            throw new GlobalExcepcion("El Numero de Identificacion " + existeNumIdentificacion.getNumeroIdentificacion() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return afiliadoRepository.save(afiliado);
    }

    @Override
    public Afiliado actualizar(long id,Afiliado afiliado) {
        log.info("actualizar afiliado");
        validarAfiliado(afiliado);
        Afiliado afiliadoBd = afiliadoRepository.findById(id).orElseThrow();


        afiliadoBd.setPrimerNombre(afiliado.getPrimerNombre());
        afiliadoBd.setSegundoNombre(afiliado.getSegundoNombre());
        afiliadoBd.setTipoDocumento(afiliado.getTipoDocumento());
        afiliadoBd.setNumeroIdentificacion(afiliado.getNumeroIdentificacion());
        afiliadoBd.setPrimerApeliido(afiliado.getPrimerApeliido());
        afiliadoBd.setSegundoApeliido(afiliado.getSegundoApeliido());
        afiliadoBd.setFechaNacimiento(afiliado.getFechaNacimiento());
        afiliadoBd.setGenero(afiliado.getGenero());
        afiliadoBd.setCodigoMunicipio(afiliado.getCodigoMunicipio());
        afiliadoBd.setIndicador(afiliado.getIndicador());
        afiliadoBd.setTelefono(afiliado.getTelefono());
        afiliadoBd.setDireccion(afiliado.getDireccion());
        afiliadoBd.setEmail(afiliado.getEmail());
        afiliadoBd.setFechaIngreso(afiliado.getFechaIngreso());
        afiliadoBd.setFechaRetiro(afiliado.getFechaRetiro());

        return afiliadoRepository.save(afiliadoBd);
    }

    @Override
    public Afiliado obtenerPorId(Long id) {
        return afiliadoRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Afiliado no encontrado"
                        , HttpStatus.NOT_FOUND));
    }


    @Override
    public List<Afiliado> ObtenerTodos() {
        log.info("consultar todos los afiliados");
        return  afiliadoRepository.findAllByOrderById();
    }
    @Override
    public String eliminar(Long id) {
        Afiliado afiliadoBd = afiliadoRepository.findById(id).orElseThrow();

        afiliadoRepository.delete(afiliadoBd);

        return "Afiliado eliminado";
    }

    private void validarAfiliado(Afiliado afiliado) {
        if (afiliado.getTipoDocumento() == null || afiliado.getTipoDocumento().isEmpty()) {
            throw new GlobalExcepcion("El tipo de documento no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getNumeroIdentificacion() == null) {
            throw new GlobalExcepcion("El número de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getPrimerApeliido() == null || afiliado.getPrimerApeliido().isEmpty()) {
            throw new GlobalExcepcion("El primer apellido no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        // 'Segundo apellido' puede estar vacío, no se valida.

        if (afiliado.getPrimerNombre() == null || afiliado.getPrimerNombre().isEmpty()) {
            throw new GlobalExcepcion("El primer nombre no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        // 'Segundo nombre' puede estar vacío, no se valida.

        if (afiliado.getFechaNacimiento() == null) {
            throw new GlobalExcepcion("La fecha de nacimiento no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getGenero() == null || afiliado.getGenero().isEmpty()) {
            throw new GlobalExcepcion("El género no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getCodigoMunicipio() == null || afiliado.getCodigoMunicipio().isEmpty()) {
            throw new GlobalExcepcion("El código del municipio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getIndicador() == null || afiliado.getIndicador().isEmpty()) {
            throw new GlobalExcepcion("El indicador no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getTelefono() == null || afiliado.getTelefono().isEmpty()) {
            throw new GlobalExcepcion("El teléfono no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getDireccion() == null || afiliado.getDireccion().isEmpty()) {
            throw new GlobalExcepcion("La dirección no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getEmail() == null || afiliado.getEmail().isEmpty()) {
            throw new GlobalExcepcion("El email no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getFechaIngreso() == null) {
            throw new GlobalExcepcion("La fecha de ingreso no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getFechaRetiro() == null) {
            throw new GlobalExcepcion("La fecha de retiro no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
   }
   /*private void validarAfiliado(Afiliado afiliado) {
       List<String> errores = new ArrayList<>();

       if (afiliado.getTipoDocumento() == null || afiliado.getTipoDocumento().isEmpty()) {
           errores.add("El tipo de documento no puede estar vacío.");
       }
       if (afiliado.getNumeroIdentificacion() == null) {
           errores.add("El número de identificación no puede estar vacío.");
       }
       if (afiliado.getPrimerApeliido() == null || afiliado.getPrimerApeliido().isEmpty()) {
           errores.add("El primer apellido no puede estar vacío.");
       }
       if (afiliado.getPrimerNombre() == null || afiliado.getPrimerNombre().isEmpty()) {
           errores.add("El primer nombre no puede estar vacío.");
       }
       if (afiliado.getFechaNacimiento() == null) {
           errores.add("La fecha de nacimiento no puede estar vacía.");
       }
       if (afiliado.getGenero() == null || afiliado.getGenero().isEmpty()) {
           errores.add("El género no puede estar vacío.");
       }
       if (afiliado.getCodigoMunicipio() == null || afiliado.getCodigoMunicipio().isEmpty()) {
           errores.add("El código del municipio no puede estar vacío.");
       }
       if (afiliado.getIndicador() == null || afiliado.getIndicador().isEmpty()) {
           errores.add("El indicador no puede estar vacío.");
       }
       if (afiliado.getTelefono() == null || afiliado.getTelefono().isEmpty()) {
           errores.add("El teléfono no puede estar vacío.");
       }
       if (afiliado.getDireccion() == null || afiliado.getDireccion().isEmpty()) {
           errores.add("La dirección no puede estar vacía.");
       }
       if (afiliado.getFechaIngreso() == null) {
           errores.add("La fecha de ingreso no puede estar vacía.");
       }

       // Verificar si hay errores acumulados y lanzar excepción
       if (!errores.isEmpty()) {
           throw new GlobalExcepcion(String.join(" ", errores), HttpStatus.BAD_REQUEST);
       }
   }*/


}
