package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Cliente;
import com.example.demo.Repositorios.ClienteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciocliente")
public class ClienteServicio{
    @Autowired
    @Qualifier("repositoriocliente")
    private ClienteRepositorio repositorio;

    public boolean crear(Cliente cliente){
        try{
            repositorio.save(cliente);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Cliente cliente){
        try{
            repositorio.save(cliente);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Cliente cliente = repositorio.findById(id);
            repositorio.delete(cliente);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Cliente obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Cliente> obtenerAll(){
        return repositorio.findAll();
    }

}