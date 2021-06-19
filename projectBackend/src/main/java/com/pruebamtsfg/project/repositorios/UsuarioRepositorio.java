package com.pruebamtsfg.project.repositorios;

import com.pruebamtsfg.project.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>,JpaSpecificationExecutor<Usuario>{
    
}
