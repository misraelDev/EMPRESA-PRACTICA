package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.empresa.model.DepartamentoBackup;
import com.empresa.service.DepartamentoBackupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/historial-departamentos")
public class DepartamentoBackupController {
    
    @Autowired
    DepartamentoBackupService departamentoBackupService;
    
        @GetMapping
    public ResponseEntity<List<DepartamentoBackup>> getAllHistorial() {
        try {
            List<DepartamentoBackup> historial = departamentoBackupService.getAllHistorial();
            return ResponseEntity.ok(historial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
