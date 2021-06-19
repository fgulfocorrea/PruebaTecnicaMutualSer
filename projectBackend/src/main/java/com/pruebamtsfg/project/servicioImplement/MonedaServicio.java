package com.pruebamtsfg.project.servicioImplement;

import java.util.List;
import java.util.Optional;

import com.pruebamtsfg.project.entidades.Moneda;
import com.pruebamtsfg.project.iServicios.IMonedaServicio;
import com.pruebamtsfg.project.repositorios.MonedaRepositorio;
import com.pruebamtsfg.project.specification.MonedaSpecificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MonedaServicio implements IMonedaServicio{

    @Autowired
    private MonedaRepositorio monedaRepositorio;

    @Autowired
    private MonedaSpecificacion monedaSpecificacion;

    @Override
    public Moneda crear(Moneda moneda) {
        // TODO Auto-generated method stub
        return monedaRepositorio.save(moneda);
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        monedaRepositorio.deleteById(id);
    }

    @Override
    public Moneda actualizar(Moneda moneda) {
        // TODO Auto-generated method stub
        return monedaRepositorio.save(moneda);
    }

    @Override
    public Moneda obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        return monedaRepositorio.getOne(id);
    }

    @Override
    public List<Moneda> obtenerTodo() {
        // TODO Auto-generated method stub
        return monedaRepositorio.findAll();
    }

    @Override
    public Moneda obtenerPorNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Moneda> obtenerTodoPorPais(String pais) {
        
        Specification<Moneda> spec = Specification.where(
        monedaSpecificacion.conPais(pais));
        List<Moneda> opt = monedaRepositorio.findAll(spec);
        return opt;
    }
    

}
