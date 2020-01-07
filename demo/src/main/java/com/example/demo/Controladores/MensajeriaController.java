package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Mensajeria;
import com.example.demo.Servicios.MensajeriaServicio;

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
@RequestMapping("/v1/mensajeria")
public class MensajeriaController{
    @Autowired
    @Qualifier("serviciomensajeria")
    MensajeriaServicio servicio;

    @GetMapping("/mensajeria")
    public Mensajeria obtenerMensajeria(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/mensajeria")
    public boolean agregarMensajeria(@RequestBody @Valid Mensajeria mensajeria){
        return servicio.crear(mensajeria);
    }

    @PutMapping("/mensajeria")
    public boolean actualizarMensajeria(@RequestBody @Valid Mensajeria mensajeria){
        return servicio.actualizar(mensajeria);
    }

    @DeleteMapping("/mensajeria/{id}")
    public boolean borrarMensajeria(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Mensajeria> getAllMensajeria(){
        return servicio.obtenerAll();
    }


    /*@GetMapping("/getPais")
    public List<Torneo> getporPais(@RequestParam(name="pais", required = true) String pais){
        return servicio.obtenerporPais(pais);
    }*/

}