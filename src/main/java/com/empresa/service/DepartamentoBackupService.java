package com.empresa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.interfaces.DepartamentoBackupInterface;
import com.empresa.model.DepartamentoBackup;

@Service
public class DepartamentoBackupService {
    
    @Autowired 
    private DepartamentoBackupInterface departamentoBackupInterface;
    
    public List<DepartamentoBackup> getAllHistorial() {
        return departamentoBackupInterface.findAll();
    }
}
