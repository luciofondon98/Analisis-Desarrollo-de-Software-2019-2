package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Tecnico;
import com.example.demo.Repositorios.TecnicoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciotecnico")
public class TecnicoServicio{

    @Autowired
    @Qualifier("repositoriotecnico")
    private TecnicoRepositorio repositorio;
    
    public boolean crear(Tecnico tecnico){
        try{
            repositorio.save(tecnico);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Tecnico tecnico){
        try{
            repositorio.save(tecnico);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Tecnico tecnico = repositorio.findById(id);
            repositorio.delete(tecnico);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Tecnico obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Tecnico> obtenerAll(){
        return repositorio.findAll();
    }

}