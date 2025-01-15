package com.empresa.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
 
 @GetMapping("/")
 public String index() {
     return "index";
 }
 
 @GetMapping("/departamento/nuevo")
 public String mostrarFormularioDepartamento(Model model) {
     model.addAttribute("departamento", new Departamento());
     return "nuevo-departamento";
 }
 
 @PostMapping("/departamento/guardar")
 public String guardarDepartamento(@ModelAttribute Departamento departamento) {
     departamentoService.createDepartamento(departamento);
     return "redirect:/";
 }
 
 @GetMapping("/empleado/nuevo")
 public String mostrarFormularioEmpleado(Model model) {
     model.addAttribute("empleado", new Empleado());
     model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
     return "nuevo-empleado";
 }
 
 @PostMapping("/empleado/guardar")
 public String guardarEmpleado(@ModelAttribute Empleado empleado) {
     empleadoService.createEmpleado(empleado);
     return "redirect:/";
 }
}