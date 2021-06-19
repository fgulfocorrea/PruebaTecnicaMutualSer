package com.pruebamtsfg.project.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pruebamtsfg.project.entidades.Moneda;
import com.pruebamtsfg.project.servicioImplement.MonedaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MonedaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class MonedaControlador {
    
    public static final String SERVICE_URI = "/api/moneda";
    private StringBuilder mensaje;

    @Autowired
    MonedaServicio monedaServicio;

    @GetMapping(value = "/listar/{pais}")
    public Map<String,Object> listar(@PathVariable String pais){
        Map<String, Object> datos = new HashMap<>();

        List<Moneda> listMonedas = monedaServicio.obtenerTodoPorPais(pais);
        
        if(!listMonedas.isEmpty()){
            datos.put("listaMonedas", listMonedas);
        }else{
            datos.put("msg", mensaje);
        }

        return datos;
    }
}
