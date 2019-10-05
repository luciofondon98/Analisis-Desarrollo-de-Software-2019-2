package com.ayudantia.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="TECNICO")
@Entity
public class Equipo{
    @Id
    @GenericGenerator(name="incrementtecnico", strategy="increment")
    @GeneratedValue(generator="incrementtecnico")
    @Column(name="id_tecnico")
    long id;

    @Column(name="nombre_tecnico")
    String nombre;

    @Column(name="correo_tecnico")
    String correo;

    @Column(name="contrasena_tecnico")
    String contrasena;

    @OneToMany(mappedBy = "tecnico")
    private Set<Pago> pago;

    public Tecnico(){

    }

    public Tecnico(long id, String nombre, String correo, Set<Jugador> jugadores) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.jugadores = jugadores;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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

    public Set<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}
