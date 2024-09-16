package com.sigap.SIGAP.empresa.service;

import com.sigap.SIGAP.empresa.entity.Empresa;
import com.sigap.SIGAP.empresa.repository.EmpresaRepository;
import com.sigap.SIGAP.excepciones.GlobalExcepcion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//anotaciones
@Service
@RequiredArgsConstructor
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {
    //inyeccion de dependencia
    //variable final e suna constante tiene que estar creadas
    private final EmpresaRepository empresaRepository;

    @Override
    public Empresa registrar(Empresa empresa) {

        empresaRepository.findByNumeroNit(empresa.getNumeroNit()).ifPresent(existeNumeroNit -> {
            throw new GlobalExcepcion("La empresa con NIT " + existeNumeroNit.getNumeroNit() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return empresaRepository.save(empresa);

    }

    @Override
    public Empresa actualizar(long id,Empresa empresa) {
        validarEmpresa(empresa);
        log.info("actualizar empresa");
        Empresa empresaBd = empresaRepository.findById(empresa.getId()).orElseThrow();


        // Asignación de valores de 'empresa' a 'empresaBd'
        empresaBd.setTipoIdentificacion(empresa.getTipoIdentificacion());
        empresaBd.setRazonSocial(empresa.getRazonSocial());
        empresaBd.setNumeroNit(empresa.getNumeroNit());
        empresaBd.setDigitoVerificacion(empresa.getDigitoVerificacion());
        empresaBd.setTipoEntidad(empresa.getTipoEntidad());
        empresaBd.setCodigoMunicipio(empresa.getCodigoMunicipio());
        empresaBd.setActividadEconomica(empresa.getActividadEconomica());
        empresaBd.setTelefono(empresa.getTelefono());
        empresaBd.setDireccion(empresa.getDireccion());
        empresaBd.setEmail(empresa.getEmail());
        empresaBd.setValorActivo(empresa.getValorActivo());
        empresaBd.setValorPasivo(empresa.getValorPasivo());
        empresaBd.setValorPatrimonio(empresa.getValorPatrimonio());
        empresaBd.setValorPatrimonioSin(empresa.getValorPatrimonioSin());
        empresaBd.setValorReservaE(empresa.getValorReservaE());
        empresaBd.setValorContable(empresa.getValorContable());



        return empresaRepository.save(empresaBd);


    }




    @Override
    public Empresa obtenerPorId(Long id) {
        return empresaRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Empresa no encontrada"
                        , HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Empresa> ObtenerTodos() {
        return empresaRepository.findAll();
    }


    private void validarEmpresa(Empresa empresa) {
        //List<String> errores = new ArrayList<>();

        if (empresa.getTipoIdentificacion() == null || empresa.getTipoIdentificacion().isEmpty()) {
            throw new GlobalExcepcion("El tipo de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getRazonSocial() == null || empresa.getRazonSocial().isEmpty()) {
            throw new GlobalExcepcion("La razón social no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getNumeroNit() == null) {
            throw new GlobalExcepcion("El número NIT no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getDigitoVerificacion() < 0 || empresa.getDigitoVerificacion() > 9) {
            throw new GlobalExcepcion("El dígito de verificación debe ser un número entre 0 y 9.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getTipoEntidad() < 0) {
            throw new GlobalExcepcion("El tipo de entidad no puede ser negativo.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getCodigoMunicipio() == null || empresa.getCodigoMunicipio().isEmpty()) {
            throw new GlobalExcepcion("El código del municipio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getActividadEconomica() < 0) {
            throw new GlobalExcepcion("La actividad económica no puede ser negativa.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getTelefono() == null || empresa.getTelefono().isEmpty()) {
            throw new GlobalExcepcion("El teléfono no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getDireccion() == null || empresa.getDireccion().isEmpty()) {
            throw new GlobalExcepcion("La dirección no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getEmail() == null || empresa.getEmail().isEmpty()) {
            throw new GlobalExcepcion("El email no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getValorActivo() == null) {
            throw new GlobalExcepcion("El valor del activo no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getValorPasivo() == null) {
            throw new GlobalExcepcion("El valor del pasivo no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getValorPatrimonio() == null) {
            throw new GlobalExcepcion("El valor del patrimonio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getValorPatrimonioSin() == null) {
            throw new GlobalExcepcion("El valor del patrimonio sin reservas no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getValorReservaE() == null) {
            throw new GlobalExcepcion("El valor de la reserva especial no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getValorContable() == null) {
            throw new GlobalExcepcion("El valor contable no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
    }


}
