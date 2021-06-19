package com.pruebamtsfg.project.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name = "movimientos_alcancias")
public class MovimientoAlcancia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idAlcancia;

    @Column(nullable = false)
    private Long idMoneda;

    @Column(nullable = false)
    private Integer cantidad;

    // @ManyToMany
    // @JoinTable(
    // name = "alcancias_movimientos_movimientos_alcancias", 
    // joinColumns = @JoinColumn(name = "alcancias_id"), 
    // inverseJoinColumns = @JoinColumn(name = "monedas_id"))
    // Set<MovimientosAlcancias> movimientos;

    public MovimientoAlcancia() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdAlcancia() {
        return this.idAlcancia;
    }

    public void setIdAlcancia(Long idAlcancia) {
        this.idAlcancia = idAlcancia;
    }

    public Long getIdMoneda() {
        return this.idMoneda;
    }

    public void setIdMoneda(Long idMoneda) {
        this.idMoneda = idMoneda;
    }

    // public Set<MovimientosAlcancias> getMovimientos() {
    //     return this.movimientos;
    // }

    // public void setMovimientos(Set<MovimientosAlcancias> movimientos) {
    //     this.movimientos = movimientos;
    // }

}
