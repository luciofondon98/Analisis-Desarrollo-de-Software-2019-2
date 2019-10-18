package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Consulta;
import com.example.demo.Servicios.ConsultaServicio;

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
@RequestMapping("/v1/consulta")
public class ConsultaController{
    @Autowired
    @Qualifier("servicioconsulta")
    ConsultaServicio servicio;

    @GetMapping("/consulta")
    public Consulta obtenerConsulta(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/consulta")
    public boolean agregarConsulta(@RequestBody @Valid Consulta consulta){
        return servicio.crear(consulta);
    }

    @PutMapping("/consulta")
    public boolean actualizarConsulta(@RequestBody @Valid Consulta consulta){
        return servicio.actualizar(consulta);
    }

    @DeleteMapping("/consulta/{id}")
    public boolean borrarConsulta(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Consulta> getAllConsulta(){
        return servicio.obtenerAll();
    }


    /*@GetMapping("/getPais")
    public List<Torneo> getporPais(@RequestParam(name="pais", required = true) String pais){
        return servicio.obtenerporPais(pais);
    }*/

}