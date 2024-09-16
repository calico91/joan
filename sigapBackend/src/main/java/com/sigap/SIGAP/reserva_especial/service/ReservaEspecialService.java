package com.sigap.SIGAP.reserva_especial.service;


import com.sigap.SIGAP.reserva_especial.entity.ReservaEspecial;

import java.util.List;

public interface ReservaEspecialService {
    ReservaEspecial registrar(ReservaEspecial  reservaEspecial);
    ReservaEspecial  actualizar(long id,ReservaEspecial  reservaEspecial);
    ReservaEspecial  obtenerPorId(Long id);
    List<ReservaEspecial > ObtenerTodos();

}
