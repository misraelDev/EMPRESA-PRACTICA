package com.empresa.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepto;

    private String nombre;
    
    public Long getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Long idDepto) {
        this.idDepto = idDepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Constructor
    public Departamento() {
    }

    //Constructor
    public Departamento(Long idDepto, String nombre) {
        this.idDepto = idDepto;
        this.nombre = nombre;
    }
}
