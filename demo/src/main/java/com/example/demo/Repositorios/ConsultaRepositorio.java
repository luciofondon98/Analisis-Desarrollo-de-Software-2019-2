package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Consulta;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioconsulta")
public interface ConsultaRepositorio extends JpaRepository<Consulta, Serializable>, PagingAndSortingRepository<Consulta, Serializable>{

    public abstract Consulta findById(long id);

    public abstract List<Consulta> findAll();

}