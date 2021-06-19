package com.pruebamtsfg.project.controlador;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import com.pruebamtsfg.project.entidades.Alcancia;
import com.pruebamtsfg.project.entidades.Moneda;
import com.pruebamtsfg.project.entidades.MovimientoAlcancia;
import com.pruebamtsfg.project.servicioImplement.AlcanciaServicio;
import com.pruebamtsfg.project.servicioImplement.MonedaServicio;
import com.pruebamtsfg.project.servicioImplement.MovimientoAlcanciaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MovimientoAlcanciaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class MovimientoAlcanciaControlador {
    
    public static final String SERVICE_URI = "/api/movimiento";
    private StringBuilder mensaje;

    @Autowired
    private MovimientoAlcanciaServicio movimientoAlcanciaServicio;

    @Autowired
    private AlcanciaServicio alcanciaServicio;

    @Autowired
    private MonedaServicio monedaServicio;

    @PostMapping(value = "/guardar/{idAlcancia}/{idMoneda}/{cantidad}")
    public Map<String,Object> agregar(@PathVariable Integer idAlcancia,@PathVariable Integer idMoneda,@PathVariable Integer cantidad){
        Map<String, Object> datos = new HashMap<>();
        System.out.println("idMoneda:"+idMoneda);
        Alcancia alcancia = alcanciaServicio.obtenerPorId(Long.parseLong(String.valueOf(idAlcancia)));
        Moneda moneda = monedaServicio.obtenerPorId(Long.parseLong(String.valueOf(idMoneda)));
        MovimientoAlcancia movimientoAlcancia = new MovimientoAlcancia();
        movimientoAlcancia.setIdAlcancia(alcancia.getId());
        movimientoAlcancia.setIdMoneda(moneda.getId());
        movimientoAlcancia.setCantidad(cantidad);
        Double total = alcancia.getTotalDinero();
        System.out.println("totalDinero:"+total);
        total+= cantidad.doubleValue() * Double.valueOf(moneda.getNombre());
        System.out.println("total:"+total);
        alcancia.setTotalDinero(total);

        movimientoAlcanciaServicio.crear(movimientoAlcancia);

        alcanciaServicio.actualizar(alcancia);

        datos.put("msg", "Se agregaron Monedas");

        return datos;
    }

    @GetMapping(value = "/cantidadMonedas/{idAlcancia}")
    public Map<String,Object> cantidadMonedas(@PathVariable Integer idAlcancia){

        Map<String, Object> datos = new HashMap<>();

        datos.put("cantidadMonedas", movimientoAlcanciaServicio.cantidadMonedasPorAlcancia(Long.valueOf(String.valueOf(idAlcancia))));

        return datos;
    }

    @GetMapping(value = "/cantidadMonedasPorDenominacion/{idAlcancia}/{idMoneda}")
    public Map<String,Object> cantidadMonedasPorDenominacion(@PathVariable Integer idAlcancia, @PathVariable Integer idMoneda){

        Map<String, Object> datos = new HashMap<>();

        datos.put("cantidadMonedasPorDenominacion", movimientoAlcanciaServicio.cantidadMonedasPorDenominacion(Long.valueOf(String.valueOf(idAlcancia)),Long.valueOf(String.valueOf(idMoneda))));

        return datos;
    }

    @GetMapping(value = "/dineroPorDenominacion/{idAlcancia}/{idMoneda}")
    public Map<String,Object> cantidadDineroPorDenominacion(@PathVariable Integer idAlcancia, @PathVariable Integer idMoneda){

        Map<String, Object> datos = new HashMap<>();

        Moneda moneda = monedaServicio.obtenerPorId(Long.parseLong(String.valueOf(idMoneda)));
        Integer cantidad = movimientoAlcanciaServicio.cantidadMonedasPorDenominacion(Long.valueOf(String.valueOf(idAlcancia)),Long.valueOf(String.valueOf(idMoneda)));
        Integer total = cantidad * Integer.parseInt(moneda.getNombre());
        System.out.println("total:"+total);
        datos.put("cantidadDineroPorDenominacion", total);

        return datos;
    }
}
