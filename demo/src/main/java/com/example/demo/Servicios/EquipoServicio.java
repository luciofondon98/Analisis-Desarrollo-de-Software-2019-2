package com.ayudantia.demo.Servicios;

import java.util.List;

import com.ayudantia.demo.Entidades.Equipo;
import com.ayudantia.demo.Repositorios.EquipoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioequipo")
public class EquipoServicio{
    @Autowired
    @Qualifier("repositorioequipo")
    private EquipoRepositorio repositorio;

    public boolean crear(Equipo equipo){
        try{
            repositorio.save(equipo);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Equipo equipo){
        try{
            repositorio.save(equipo);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Equipo equipo = repositorio.findById(id);
            repositorio.delete(equipo);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Equipo obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Equipo> obtenerAll(){
        return repositorio.findAll();
    }

}