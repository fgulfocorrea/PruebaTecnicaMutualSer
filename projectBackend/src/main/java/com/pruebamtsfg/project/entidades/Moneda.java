package com.pruebamtsfg.project.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "monedas")
public class Moneda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 2)
    private String pais;

    // @ManyToMany
    // Set<Alcancias> alcancias;

    public Moneda() {
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

    // public Set<Alcancias> getAlcancias() {
    //     return this.alcancias;
    // }

    // public void setAlcancias(Set<Alcancias> alcancias) {
    //     this.alcancias = alcancias;
    // }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", pais='" + getPais() + "'" +
            "}";
    }


}
