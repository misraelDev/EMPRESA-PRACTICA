package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.empresa.model.Departamento;
import com.empresa.model.Empleado;
import com.empresa.service.DepartamentoService;
import com.empresa.service.EmpleadoService;

@Controller
public class WebController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({ "/", "/empleados" })
    public String empleados(Model model) {
        return "index";
    }

    @GetMapping("/departamentos")
    public String departamentos(Model model) {
        return "index";
    }

    
    @GetMapping("/historial")
    public String mostrarHistorial(Model model) {
        return "index";
    }
    // Rutas para Departamentos
    @GetMapping("/departamento/nuevo")
    public String mostrarFormularioDepartamento(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "nuevo-departamento";
    }

    @PostMapping("/departamento/guardar")
    public String guardarDepartamento(@ModelAttribute Departamento departamento) {
        departamentoService.createDepartamento(departamento);
        return "redirect:/departamentos";
    }

    // Rutas para Empleados
    @GetMapping("/empleado/nuevo")
    public String mostrarFormularioEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
        return "nuevo-empleado";
    }

    @PostMapping("/empleado/guardar")
    @ResponseBody
    public String guardarEmpleado(@RequestBody Empleado empleado) {
        empleadoService.createEmpleado(empleado);
        return "redirect:/empleados";
    }

    // Rutas para edición de Empleados
    @GetMapping("/empleado/editar/{id}")
    public String mostrarFormularioEditarEmpleado(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
        return "editar-empleado";
    }

    @PutMapping("/api/v1/empleados/{id}")
    @ResponseBody
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        try {
            Empleado empleadoActualizado = empleadoService.updateEmpleado(id, empleado);
            return ResponseEntity.ok().body(empleadoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error al actualizar el empleado\"}");
        }
    }

    // Rutas para edición de Departamentos
    @GetMapping("/departamento/editar/{id}")
    public String mostrarFormularioEditarDepartamento(@PathVariable Long id, Model model) {
        Departamento departamento = departamentoService.getDepartamentoById(id);
        model.addAttribute("departamento", departamento);
        return "editar-departamento";
    }

    @PutMapping("/api/v1/departamentos/{id}")
    @ResponseBody
    public ResponseEntity<?> actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        try {
            Departamento departamentoActualizado = departamentoService.updateDepartamento(id, departamento);
            return ResponseEntity.ok().body(departamentoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error al actualizar el departamento\"}");
        }
    }

    // Endpoints de eliminación existentes
    @DeleteMapping("/api/v1/empleados/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id) {
        try {
            empleadoService.deleteEmpleado(id);
            return ResponseEntity.ok().body("{\"message\":\"Empleado eliminado con éxito\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error al eliminar el empleado\"}");
        }
    }

    @DeleteMapping("/api/v1/departamentos/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarDepartamento(@PathVariable Long id) {
        try {
            departamentoService.deleteDepartamento(id);
            return ResponseEntity.ok().body("{\"message\":\"Departamento eliminado con éxito\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error al eliminar el departamento\"}");
        }
    }
}