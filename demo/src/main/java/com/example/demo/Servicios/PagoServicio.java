package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Pago;
import com.example.demo.Repositorios.PagoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciopago")
public class PagoServicio{

    @Autowired
    @Qualifier("repositoriopago")
    private PagoRepositorio repositorio;

    public boolean crear(Pago pago){
        try{
            repositorio.save(pago);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Pago pago){
        try{
            repositorio.save(pago);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Pago pago = repositorio.findById(id);
            repositorio.delete(pago);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Pago obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Pago> obtenerAll(){
        return repositorio.findAll();
    }
}
