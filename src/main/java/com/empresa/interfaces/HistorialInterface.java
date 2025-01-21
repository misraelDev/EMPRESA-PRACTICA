package com.empresa.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.model.EmpleadoBackup;


@Repository
public interface HistorialInterface extends JpaRepository <EmpleadoBackup, Long>  {
    
}
