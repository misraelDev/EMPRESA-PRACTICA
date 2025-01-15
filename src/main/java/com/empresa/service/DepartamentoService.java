package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.interfaces.DepartamentoInterface;
import com.empresa.model.Departamento;

@Service
public class DepartamentoService {
    
    @Autowired
    private DepartamentoInterface departamentoInterface;
    
    public Departamento createDepartamento(Departamento departamento) {
        return departamentoInterface.save(departamento);
    }

    public List<Departamento> getAllDepartamentos() {
        return departamentoInterface.findAll();
    }
}