package com.pruebamtsfg.project.repositorios;

import com.pruebamtsfg.project.entidades.MovimientoAlcancia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface MovimientoAlcanciaRepositorio extends JpaRepository<MovimientoAlcancia,Long>,JpaSpecificationExecutor<MovimientoAlcancia>{
    
    @Query(value = "select sum(a.cantidad) cant from movimientos_alcancias a join alcancias b on a.id_alcancia = b.id where b.id= ?1", nativeQuery = true)
    Long countMonedas(Long idAlcancia);

    @Query(value = "select sum(a.cantidad)cantidad from movimientos_alcancias a join alcancias b on a.id_alcancia = b.id join monedas c on a.id_moneda = c.id where b.id= ?1 and c.id= ?2 group by c.nombre;", nativeQuery = true)
    Long countMonedaPorDenominacion(Long idAlcancia,Long idMoneda);
}
