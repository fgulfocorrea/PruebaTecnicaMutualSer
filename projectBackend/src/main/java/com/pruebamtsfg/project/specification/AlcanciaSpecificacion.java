package com.pruebamtsfg.project.specification;

import com.pruebamtsfg.project.entidades.Alcancia;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AlcanciaSpecificacion {
    
    public Specification<Alcancia> conNombre(String nombre){
        return (root, query, cb)-> nombre == null ? null : cb.equal(root.get("nombre"), nombre);
    }
}
