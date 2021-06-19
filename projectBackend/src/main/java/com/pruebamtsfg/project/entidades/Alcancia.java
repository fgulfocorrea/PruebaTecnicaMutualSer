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

@Entity(name = "alcancias")
public class Alcancia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false,length = 2)
    private String pais;

    @Column(nullable = false)
    private Double totalDinero;

    // @ManyToMany
    // Set<Monedas> monedas;

    public Alcancia() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getTotalDinero() {
        return this.totalDinero;
    }

    public void setTotalDinero(Double totalDinero) {
        this.totalDinero = totalDinero;
    }

    // public Set<Monedas> getMonedas() {
    //     return this.monedas;
    // }

    // public void setMonedas(Set<Monedas> monedas) {
    //     this.monedas = monedas;
    // }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", pais='" + getPais() + "'" +
            ", totalDinero='" + getTotalDinero() + "'" +
            "}";
    }

}
