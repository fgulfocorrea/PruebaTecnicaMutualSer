package com.pruebamtsfg.project.iServicios;

import java.util.List;

import com.pruebamtsfg.project.entidades.MovimientoAlcancia;

public interface IMovimientoAlcanciaServicio {
    
    public MovimientoAlcancia crear(MovimientoAlcancia movimientoAlcancia);
	public void eliminar(Long id);
	public MovimientoAlcancia actualizar(MovimientoAlcancia movimientoAlcancia);
	public MovimientoAlcancia obtenerPorId(Long id);
	public List<MovimientoAlcancia> obtenerTodo();
	public MovimientoAlcancia obtenerPorNombre(String nombre);
	public Integer cantidadMonedasPorAlcancia(Long idAlcancia);
	public Integer cantidadMonedasPorDenominacion(Long idAlcancia, Long idMoneda);
}
