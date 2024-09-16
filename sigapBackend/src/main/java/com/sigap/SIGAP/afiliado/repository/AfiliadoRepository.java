package com.sigap.SIGAP.afiliado.repository;

import com.sigap.SIGAP.afiliado.entity.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado,Long>{
    Optional<Afiliado> findByNumeroIdentificacion(Integer nidentificacion);

    List<Afiliado> findAllByOrderById();
}