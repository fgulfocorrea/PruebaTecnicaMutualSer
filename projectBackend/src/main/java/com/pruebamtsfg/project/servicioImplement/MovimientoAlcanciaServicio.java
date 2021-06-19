package com.pruebamtsfg.project.servicioImplement;

import java.util.List;

import com.pruebamtsfg.project.entidades.MovimientoAlcancia;
import com.pruebamtsfg.project.iServicios.IMovimientoAlcanciaServicio;
import com.pruebamtsfg.project.repositorios.MovimientoAlcanciaRepositorio;
import com.pruebamtsfg.project.specification.MovimientoAlcanciaSpecificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MovimientoAlcanciaServicio implements IMovimientoAlcanciaServicio{

    @Autowired
    private MovimientoAlcanciaRepositorio movimientoAlcanciaRepositorio;

    @Autowired
    private MovimientoAlcanciaSpecificacion movimientoAlcanciaSpecificacion;

    @Override
    public MovimientoAlcancia crear(MovimientoAlcancia movimientoAlcancia) {
        // TODO Auto-generated method stub
        return movimientoAlcanciaRepositorio.save(movimientoAlcancia);
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        movimientoAlcanciaRepositorio.deleteById(id);
    }

    @Override
    public MovimientoAlcancia actualizar(MovimientoAlcancia movimientoAlcancia) {
        // TODO Auto-generated method stub
        return movimientoAlcanciaRepositorio.save(movimientoAlcancia);
    }

    @Override
    public MovimientoAlcancia obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        return movimientoAlcanciaRepositorio.getOne(id);
    }

    @Override
    public List<MovimientoAlcancia> obtenerTodo() {
        // TODO Auto-generated method stub
        return movimientoAlcanciaRepositorio.findAll();
    }

    @Override
    public MovimientoAlcancia obtenerPorNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer cantidadMonedasPorAlcancia(Long idAlcancia) {
        
        Long cantidad = movimientoAlcanciaRepositorio.countMonedas(idAlcancia);

        return cantidad == null ? 0 : cantidad.intValue();
    }

    @Override
    public Integer cantidadMonedasPorDenominacion(Long idAlcancia, Long idMoneda) {
        
        Long cantidad = movimientoAlcanciaRepositorio.countMonedaPorDenominacion(idAlcancia, idMoneda);
        
        return cantidad == null ? 0 : cantidad.intValue();
    }
    
}
