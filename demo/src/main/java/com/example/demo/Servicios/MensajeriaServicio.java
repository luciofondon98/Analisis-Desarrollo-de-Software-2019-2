package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Mensajeria;
import com.example.demo.Repositorios.MensajeriaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("serviciomensajeria")
public class MensajeriaServicio{
    @Autowired
    @Qualifier("repositoriomensajeria")
    private MensajeriaRepositorio repositorio;

    public boolean crear(Mensajeria mensajeria){
        try{
            repositorio.save(mensajeria);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Mensajeria mensajeria){
        try{
            repositorio.save(mensajeria);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Mensajeria mensajeria = repositorio.findById(id);
            repositorio.delete(mensajeria);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Mensajeria obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Mensajeria> obtenerAll(){
        return repositorio.findAll();
    }

    /*public List<Torneo> obtenerporPais(String pais){
        return repositorio.findByPais(pais);
    }*/
}