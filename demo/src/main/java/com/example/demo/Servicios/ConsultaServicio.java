package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Consulta;
import com.example.demo.Repositorios.ConsultaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("servicioconsulta")
public class ConsultaServicio{
    @Autowired
    @Qualifier("repositorioconsulta")
    private ConsultaRepositorio repositorio;

    public boolean crear(Consulta consulta){
        try{
            repositorio.save(consulta);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Consulta consulta){
        try{
            repositorio.save(consulta);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Consulta consulta = repositorio.findById(id);
            repositorio.delete(consulta);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Consulta obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Consulta> obtenerAll(){
        return repositorio.findAll();
    }

    /*public List<Torneo> obtenerporPais(String pais){
        return repositorio.findByPais(pais);
    }*/
}