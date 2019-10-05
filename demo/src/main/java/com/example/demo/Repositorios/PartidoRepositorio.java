package com.ayudantia.demo.Repositorios;

import java.io.Serializable;

import com.ayudantia.demo.Entidades.Partido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriopartido")
public interface PartidoRepositorio extends JpaRepository<Partido, Serializable>{

    public abstract Partido findById(long id);

}