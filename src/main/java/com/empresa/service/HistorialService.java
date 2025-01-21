package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.interfaces.HistorialInterface;
import com.empresa.model.EmpleadoBackup;

@Service
public class HistorialService {
 
    @Autowired 
    private HistorialInterface historialInterface;
    
    public List<EmpleadoBackup> getAllHistorial() {
        return historialInterface.findAll();
    }
}
