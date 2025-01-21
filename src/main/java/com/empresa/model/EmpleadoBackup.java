package com.empresa.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "empleados_backup")
public class EmpleadoBackup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
    private Long id_empleado;
    private String operacion;
    private LocalDateTime fecha_hora;

public Long getId_registro() {
    return id_registro;
}

public void setId_registro(Long id_registro) {
    this.id_registro = id_registro;
}

public Long getId_empleado() {
    return id_empleado;
}

public void setId_empleado(Long id_empleado) {
    this.id_empleado = id_empleado;
}

public String getOperacion() {
    
    return operacion;
}

public void setOperacion(String operacion) {
    this.operacion = operacion;
}

public LocalDateTime getFecha_hora() {
    return fecha_hora;
}

public void setFecha_hora(LocalDateTime fecha_hora) {
    this.fecha_hora = fecha_hora;
}

public EmpleadoBackup() {
}

public EmpleadoBackup(Long id_registro, Long id_empleado, String operacion, LocalDateTime fecha_hora) {
    this.id_registro = id_registro;
    this.id_empleado = id_empleado;
    this.operacion = operacion;
    this.fecha_hora = fecha_hora;
}
}