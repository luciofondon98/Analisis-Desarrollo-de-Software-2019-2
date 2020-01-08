package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Calificacion;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriocalificacion")
public interface CalificacionRepositorio extends JpaRepository<Calificacion, Serializable>, PagingAndSortingRepository<Calificacion, Serializable>{

    public abstract Calificacion findById(long id);

    public abstract List<Calificacion> findAll();

}