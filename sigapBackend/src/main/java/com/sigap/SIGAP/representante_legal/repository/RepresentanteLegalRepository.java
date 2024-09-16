package com.sigap.SIGAP.representante_legal.repository;


import com.sigap.SIGAP.representante_legal.entity.RepresentanteLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RepresentanteLegalRepository extends JpaRepository<RepresentanteLegal,Long> {
    Optional<RepresentanteLegal> findByNumeroIdentificacion(Integer nidentificacion);
}

