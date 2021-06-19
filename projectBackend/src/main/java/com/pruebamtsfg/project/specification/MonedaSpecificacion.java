package com.pruebamtsfg.project.specification;

import com.pruebamtsfg.project.entidades.Moneda;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MonedaSpecificacion {
    
    public Specification<Moneda> conPais(String pais){
        return (root, query, cb)-> pais == null ? null : cb.equal(root.get("pais"), pais);
    }
}
