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

<<<<<<< HEAD
=======
    //public abstract Consulta findById_Cliente(long cliente);

>>>>>>> 2359cebc88b39f1c66913c32c0d43295dfb83efa
    public abstract List<Consulta> findAll();

}