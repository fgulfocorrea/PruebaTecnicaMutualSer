package com.pruebamtsfg.project.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pruebamtsfg.project.entidades.Alcancia;
import com.pruebamtsfg.project.repositorios.AlcanciaRepositorio;
import com.pruebamtsfg.project.servicioImplement.AlcanciaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PrincipalControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class PrincipalControlador {
    
    public static final String SERVICE_URI = "/api";
    private StringBuilder mensaje;

    @Autowired
    AlcanciaServicio alcanciaServicio;

    @GetMapping(value = "/principal")
    public Map<String,Object> iniciar(){
        Map<String, Object> datos = new HashMap<>();

        List<Alcancia> listAlcancias = alcanciaServicio.obtenerTodo();
        
        if(!listAlcancias.isEmpty()){
            datos.put("listaAlcancia", listAlcancias);
        }else{
            datos.put("msg", mensaje);
        }

        return datos;
    }
}
