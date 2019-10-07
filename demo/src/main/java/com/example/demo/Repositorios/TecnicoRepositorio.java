package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Tecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriotecnico")
public interface TecnicoRepositorio extends JpaRepository<Tecnico, Serializable> {

    public abstract Tecnico findById(long id);

    public abstract List<Tecnico> findAll();

}