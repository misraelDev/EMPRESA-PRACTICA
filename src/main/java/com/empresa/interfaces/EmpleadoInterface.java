package com.empresa.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.empresa.model.Empleado;

@Repository
public interface EmpleadoInterface extends JpaRepository<Empleado, Long> {

}
