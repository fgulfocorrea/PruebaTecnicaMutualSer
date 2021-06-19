package com.pruebamtsfg.project.controlador;

import java.util.HashMap;
import java.util.Map;

import com.pruebamtsfg.project.repositorios.AlcanciaRepositorio;
import com.pruebamtsfg.project.servicioImplement.AlcanciaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AlcanciaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class AlcanciaControlador {
    
    public static final String SERVICE_URI = "/api/alcancia";
    private StringBuilder mensaje;

    @Autowired
    AlcanciaServicio alcanciaServicio;

    @GetMapping(value = "/{nombre}")
    public Map<String,Object> alcanciaPorNombre(@PathVariable String nombre){
        Map<String, Object> datos = new HashMap<>();
        datos.put("alcancia", alcanciaServicio.obtenerPorNombre(nombre));
        return datos;
    }
}
