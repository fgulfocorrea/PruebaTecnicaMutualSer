package com.pruebamtsfg.project.iServicios;

import java.util.List;

import com.pruebamtsfg.project.entidades.Persona;

public interface IPersonaServicio {
    
    public Persona crear(Persona persona);
	public void eliminar(Long id);
	public Persona actualizar(Persona persona);
	public Persona obtenerPorId(Long id);
	public List<Persona> obtenerTodo();
	public Persona obtenerPorNombre(String nombre);
}
