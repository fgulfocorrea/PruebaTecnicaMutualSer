package com.pruebamtsfg.project.repositorios;

import com.pruebamtsfg.project.entidades.Alcancia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlcanciaRepositorio extends JpaRepository<Alcancia, Long>,JpaSpecificationExecutor<Alcancia>{
    
}
