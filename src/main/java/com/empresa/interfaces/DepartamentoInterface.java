package com.empresa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.empresa.model.Departamento;

@Repository
public interface DepartamentoInterface extends JpaRepository<Departamento, Long> {
}