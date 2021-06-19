package com.pruebamtsfg.project.iServicios;

import java.util.List;

import com.pruebamtsfg.project.entidades.Moneda;

public interface IMonedaServicio {
    
    public Moneda crear(Moneda moneda);
	public void eliminar(Long id);
	public Moneda actualizar(Moneda moneda);
	public Moneda obtenerPorId(Long id);
	public List<Moneda> obtenerTodo();
	public Moneda obtenerPorNombre(String nombre);
	public List<Moneda> obtenerTodoPorPais(String pais);
}
