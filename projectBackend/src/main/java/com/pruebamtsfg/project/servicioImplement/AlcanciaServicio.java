package com.pruebamtsfg.project.servicioImplement;

import java.util.List;
import java.util.Optional;

import com.pruebamtsfg.project.entidades.Alcancia;
import com.pruebamtsfg.project.entidades.Moneda;
import com.pruebamtsfg.project.iServicios.IAlcanciaServicio;
import com.pruebamtsfg.project.repositorios.AlcanciaRepositorio;
import com.pruebamtsfg.project.specification.AlcanciaSpecificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AlcanciaServicio implements IAlcanciaServicio{

    @Autowired
    private AlcanciaRepositorio alcanciaRepositorio;

    @Autowired
    private AlcanciaSpecificacion alcanciaSpecificacion;

    @Override
    public Alcancia crear(Alcancia alcancia) {
        // TODO Auto-generated method stub
        return alcanciaRepositorio.save(alcancia);
    }

    @Override
    public void eliminar(Long id) {
        alcanciaRepositorio.deleteById(id);
        
    }

    @Override
    public Alcancia actualizar(Alcancia alcancia) {
        // TODO Auto-generated method stub
        return alcanciaRepositorio.save(alcancia);
    }

    @Override
    public Alcancia obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        return alcanciaRepositorio.getOne(id);
    }

    @Override
    public List<Alcancia> obtenerTodo() {
        // TODO Auto-generated method stub
        return alcanciaRepositorio.findAll();
    }

    @Override
    public Alcancia obtenerPorNombre(String nombre) {
        Specification<Alcancia> spec = Specification.where(
        alcanciaSpecificacion.conNombre(nombre));
        Optional<Alcancia> opt = alcanciaRepositorio.findOne(spec);
        return opt.isPresent() == true ? opt.get() : null;
    }

    @Override
    public Integer obtenerCantidadMonedas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer obtenerCantidadMonedas(Moneda moneda) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
