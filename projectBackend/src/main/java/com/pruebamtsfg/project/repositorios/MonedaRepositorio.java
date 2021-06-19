package com.pruebamtsfg.project.repositorios;

import com.pruebamtsfg.project.entidades.Moneda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MonedaRepositorio extends JpaRepository<Moneda, Long>,JpaSpecificationExecutor<Moneda>{
    
}
