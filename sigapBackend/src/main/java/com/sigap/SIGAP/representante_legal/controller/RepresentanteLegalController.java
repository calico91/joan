package com.sigap.SIGAP.representante_legal.controller;

import com.sigap.SIGAP.representante_legal.entity.RepresentanteLegal;
import com.sigap.SIGAP.representante_legal.service.RepresentanteLegalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

@RequestMapping("/representante-legal")
public class RepresentanteLegalController {

    private final RepresentanteLegalServiceImpl representanteLegalService;


    @PostMapping("/registrar")
    public ResponseEntity<RepresentanteLegal> registrar(
            @RequestBody RepresentanteLegal representanteLegal) {

        return new ResponseEntity<>(representanteLegalService.registrar(representanteLegal), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RepresentanteLegal> actualizar(@PathVariable Long id, @RequestBody RepresentanteLegal representanteLegal) {
        return new ResponseEntity<>(representanteLegalService.actualizar(id,representanteLegal), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<RepresentanteLegal> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(representanteLegalService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<RepresentanteLegal>> consultarTodos() {

        return new ResponseEntity<>(representanteLegalService.ObtenerTodos(), HttpStatus.OK);
    }

}


