package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Mensajeria;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriomensajeria")
public interface MensajeriaRepositorio extends JpaRepository<Mensajeria, Serializable>, PagingAndSortingRepository<Mensajeria, Serializable>{

    public abstract Mensajeria findById(long id);

    public abstract List<Mensajeria> findAll();

}