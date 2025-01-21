package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.model.Departamento;
import com.empresa.service.DepartamentoService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/total")
    public long getTotalDepartamentos() {
        return departamentoService.countDepartamentos();
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        try {
            List<Departamento> departamentos = departamentoService.getAllDepartamentos();

            if (departamentos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(departamentos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
