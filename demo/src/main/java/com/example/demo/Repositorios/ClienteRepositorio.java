package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriocliente")
public interface ClienteRepositorio extends JpaRepository<Cliente, Serializable>{
    
    public abstract Cliente findById(long id);

    public abstract List<Cliente> findAll();

}