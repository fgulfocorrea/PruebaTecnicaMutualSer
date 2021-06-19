package com.pruebamtsfg.project.specification;

import com.pruebamtsfg.project.entidades.MovimientoAlcancia;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MovimientoAlcanciaSpecificacion {
    
    public Specification<MovimientoAlcancia> conIdAlcancia(Long idAlcancia){
        return (root, query, cb)-> idAlcancia == null ? null : cb.equal(root.get("idAlcancia"), idAlcancia);
    }
}
