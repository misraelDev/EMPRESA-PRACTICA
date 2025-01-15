package com.empresa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.interfaces.EmpleadoInterface;
import com.empresa.model.Empleado;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoInterface empleadoInterface;
    
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoInterface.save(empleado);
    }
}