package com.example.demo.Repositorios;
import java.util.List;
import java.io.Serializable;

import com.example.demo.Entidades.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriopago")
public interface PagoRepositorio extends JpaRepository<Pago, Serializable>{

    public abstract Pago findById(long id);

    public abstract List<Pago> findAll();

}