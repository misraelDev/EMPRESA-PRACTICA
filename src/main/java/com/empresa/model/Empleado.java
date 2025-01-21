package com.empresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotNull
    @Column(length = 25)
    private String nombre;

    @NotNull
    @Column(length = 25)
    private String appPaterno;

    @NotNull
    @Column(length = 25)
    private String appMaterno;

    @NotNull
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "idDepto", nullable = true)
    private Departamento departamento;

    //Constructor
    public Empleado() {
    }

    //Constructor
    public Empleado(Long idCliente, String nombre, String appPaterno, String appMaterno, LocalDate fechaNacimiento, Departamento departamento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppPaterno() {
        return appPaterno;
    }

    public void setAppPaterno(String appPaterno) {
        this.appPaterno = appPaterno;
    }

    public String getAppMaterno() {
        return appMaterno;
    }

    public void setAppMaterno(String appMaterno) {
        this.appMaterno = appMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
public String toString() {
    return "Empleado{" +
            "nombre='" + nombre + '\'' +
            ", appPaterno='" + appPaterno + '\'' +
            ", appMaterno='" + appMaterno + '\'' +
            ", departamento=" + (departamento != null ? departamento.getIdDepto() : "null") +
            ", fechaNacimiento=" + fechaNacimiento +
            '}';
}

}

