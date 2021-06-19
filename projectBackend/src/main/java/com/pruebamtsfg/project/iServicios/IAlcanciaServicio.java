package com.pruebamtsfg.project.iServicios;

import java.util.List;

import com.pruebamtsfg.project.entidades.Alcancia;
import com.pruebamtsfg.project.entidades.Moneda;

public interface IAlcanciaServicio {
    
    public Alcancia crear(Alcancia alcancia);
	public void eliminar(Long id);
	public Alcancia actualizar(Alcancia alcancia);
	public Alcancia obtenerPorId(Long id);
	public List<Alcancia> obtenerTodo();
	public Alcancia obtenerPorNombre(String nombre);
    public Integer obtenerCantidadMonedas();
    public Integer obtenerCantidadMonedas(Moneda moneda);
}
