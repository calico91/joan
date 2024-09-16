package com.sigap.SIGAP.empresa.service;

import com.sigap.SIGAP.empresa.entity.Empresa;

import java.util.List;

public interface EmpresaService {
    Empresa registrar(Empresa empresa);

    Empresa actualizar(long id, Empresa empresa);

    Empresa obtenerPorId(Long id);

    List<Empresa> ObtenerTodos();
}
