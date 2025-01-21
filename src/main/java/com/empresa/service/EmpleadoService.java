package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.interfaces.EmpleadoInterface;
import com.empresa.model.Empleado;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoInterface empleadoInterface;

    public List<Empleado> getAllEmpleados() {
        return empleadoInterface.findAll();
    }

    public Empleado createEmpleado(Empleado empleado) {
        return empleadoInterface.save(empleado);
    }

    public long countEmpleados() {
        return empleadoInterface.count();
    }

    public void deleteEmpleado(Long id) {
        empleadoInterface.deleteById(id);
    }

    public Empleado updateEmpleado(Long id, Empleado empleado) {
        Empleado empleadoExistente = empleadoInterface.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el empleado con id: " + id));

        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setAppMaterno(empleado.getAppPaterno());
        empleadoExistente.setAppMaterno(empleado.getAppMaterno());
        empleadoExistente.setDepartamento(empleado.getDepartamento());
        empleadoExistente.setFechaNacimiento(empleado.getFechaNacimiento());

        return empleadoInterface.save(empleadoExistente);
    }

    public Empleado getEmpleadoById(Long id) {
        return empleadoInterface.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el empleado con id: " + id));
    }
}
