package com.pruebamtsfg.project.iServicios;

import java.util.List;

import com.pruebamtsfg.project.entidades.Usuario;

public interface IUsuarioServicio {
    
    public Usuario crear(Usuario usuario);
	public void eliminar(Long id);
	public Usuario actualizar(Usuario usuario);
	public Usuario obtenerPorId(Long id);
	public List<Usuario> obtenerTodo();
	public Usuario obtenerPorNombre(String nombre);
}
