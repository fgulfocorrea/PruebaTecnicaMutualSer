package com.pruebamtsfg.project.repositorios;

import com.pruebamtsfg.project.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonaRepositorio extends JpaRepository<Persona,Long>,JpaSpecificationExecutor<Persona>{
    
}
