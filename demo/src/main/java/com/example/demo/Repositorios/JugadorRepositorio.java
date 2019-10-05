package com.ayudantia.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.ayudantia.demo.Entidades.Jugador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriojugador")
public interface JugadorRepositorio extends JpaRepository<Jugador, Serializable> {

    public abstract Jugador findById(long id);

    public abstract List<Jugador> findByEquipo(long equipo);

}