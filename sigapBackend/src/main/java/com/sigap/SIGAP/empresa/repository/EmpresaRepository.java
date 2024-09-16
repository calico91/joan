package com.sigap.SIGAP.empresa.repository;

import com.sigap.SIGAP.empresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByNumeroNit(Integer nit);
}
