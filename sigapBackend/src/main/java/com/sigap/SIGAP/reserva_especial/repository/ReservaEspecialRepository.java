package com.sigap.SIGAP.reserva_especial.repository;



import com.sigap.SIGAP.reserva_especial.entity.ReservaEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaEspecialRepository extends JpaRepository<ReservaEspecial,Long> {
    Optional<ReservaEspecial> findByNumeroIdentificacion(Integer nidentificacion);
}

