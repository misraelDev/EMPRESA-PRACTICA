package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.model.Departamento;
import com.empresa.service.DepartamentoService;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService departamentoService;
    
    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
        try {
            Departamento newDepartamento = departamentoService.createDepartamento(departamento);
            return new ResponseEntity<>(newDepartamento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
