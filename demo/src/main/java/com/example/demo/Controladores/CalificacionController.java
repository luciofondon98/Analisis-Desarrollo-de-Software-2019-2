package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Calificacion;
import com.example.demo.Servicios.CalificacionServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Pageable;
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
@RequestMapping("/v1/calificacion")
public class CalificacionController{
    @Autowired
    @Qualifier("serviciocalificacion")
    CalificacionServicio servicio;

    @GetMapping("/calificacion")
    public Calificacion obtenerMensajeria(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/calificacion")
    public boolean agregarCalificacion(@RequestBody @Valid Calificacion calificacion){
        return servicio.crear(calificacion);
    }

    @PutMapping("/calificacion")
    public boolean actualizarCalificacion(@RequestBody @Valid Calificacion calificacion){
        return servicio.actualizar(calificacion);
    }

    @DeleteMapping("/calificacion/{id}")
    public boolean borrarCalificacion(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Calificacion> getAllCalificacion(){
        return servicio.obtenerAll();
    }


    /*@GetMapping("/getPais")
    public List<Torneo> getporPais(@RequestParam(name="pais", required = true) String pais){
        return servicio.obtenerporPais(pais);
    }*/

}