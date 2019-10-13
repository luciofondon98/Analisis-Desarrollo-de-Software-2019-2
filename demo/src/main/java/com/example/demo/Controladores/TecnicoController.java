package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Tecnico;
import com.example.demo.Servicios.TecnicoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tecnico")
public class TecnicoController{
    @Autowired
    @Qualifier("serviciotecnico")
    TecnicoServicio servicio;


    @GetMapping("/tecnico")
    public Tecnico obtenerTecnico(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/tecnico")
    public boolean agregarTecnico(@RequestBody @Valid Tecnico tecnico){
        return servicio.crear(tecnico);
    }

    @PutMapping("/tecnico")
    public boolean actualizarTecnico(@RequestBody @Valid Tecnico tecnico){
        return servicio.actualizar(tecnico);
    }

    @DeleteMapping("/tecnico/{id}")
    public boolean borrarTecnico(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Tecnico> getAllTecnico(){
        return servicio.obtenerAll();
    }

}
