package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.model.Empleado;
import com.empresa.service.EmpleadoService;

@RestController 
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        try {
            Empleado newEmpleado = empleadoService.createEmpleado(empleado);
            return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

