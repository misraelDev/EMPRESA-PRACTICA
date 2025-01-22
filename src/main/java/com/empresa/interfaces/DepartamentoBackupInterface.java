package com.empresa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.model.DepartamentoBackup;

@Repository
public interface DepartamentoBackupInterface extends JpaRepository<DepartamentoBackup, Long> {

}
