package com.sigap.SIGAP.reserva_especial.controller;


import com.sigap.SIGAP.reserva_especial.entity.ReservaEspecial;
import com.sigap.SIGAP.reserva_especial.service.ReservaEspecialServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor

@RequestMapping("/reserva-especial")
public class ReservaEspecialController {

    private final ReservaEspecialServiceImpl reservaEspecialService;


    @PostMapping("/registrar")
    public ResponseEntity<ReservaEspecial> registrar(
            @RequestBody ReservaEspecial reservaEspecial) {

        return new ResponseEntity<>(reservaEspecialService.registrar(reservaEspecial), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaEspecial> actualizar(@PathVariable Long id, @RequestBody ReservaEspecial reservaEspecial) {
        return new ResponseEntity<>(reservaEspecialService.actualizar(id,reservaEspecial), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<ReservaEspecial> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(reservaEspecialService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<ReservaEspecial>> consultarTodos() {

        return new ResponseEntity<>(reservaEspecialService.ObtenerTodos(), HttpStatus.OK);
    }

}


