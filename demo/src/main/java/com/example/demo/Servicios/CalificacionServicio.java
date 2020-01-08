package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Calificacion;
import com.example.demo.Repositorios.CalificacionRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("serviciocalificacion")
public class CalificacionServicio{
    @Autowired
    @Qualifier("repositoriocalificacion")
    private CalificacionRepositorio repositorio;

    public boolean crear(Calificacion calificacion){
        try{
            repositorio.save(calificacion);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Calificacion calificacion){
        try{
            repositorio.save(calificacion);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Calificacion calificacion = repositorio.findById(id);
            repositorio.delete(calificacion);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Calificacion obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Calificacion> obtenerAll(){
        return repositorio.findAll();
    }

    /*public List<Torneo> obtenerporPais(String pais){
        return repositorio.findByPais(pais);
    }*/
}