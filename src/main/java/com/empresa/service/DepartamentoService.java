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

    // Método para contar el total de registros
    public long countDepartamentos() {
        return departamentoInterface.count();
    }

    public void deleteDepartamento(Long id) {
        try {
            departamentoInterface.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException(
                    "No se puede eliminar el departamento porque está siendo referenciado por uno o más registros en la tabla empleados.");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error inesperado al intentar eliminar el departamento. Por favor, inténtelo de nuevo más tarde.");
        }
    }
    
    public Departamento updateDepartamento(Long id, Departamento departamento) {
        Departamento departamentoExistente = departamentoInterface.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el departamento con id: " + id));
        
        departamentoExistente.setNombre(departamento.getNombre());
        
        return departamentoInterface.save(departamentoExistente);
    }

    public Departamento getDepartamentoById(Long id) {
        return departamentoInterface.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el departamento con id: " + id));
    }

}
