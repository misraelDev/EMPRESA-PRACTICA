
package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.empresa.model.EmpleadoBackup;
import com.empresa.service.HistorialService;

@RestController
@RequestMapping("/api/v1/historial-empleados")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public ResponseEntity<List<EmpleadoBackup>> getAllHistorial() {
        try {
            List<EmpleadoBackup> historial = historialService.getAllHistorial();
            return ResponseEntity.ok(historial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}