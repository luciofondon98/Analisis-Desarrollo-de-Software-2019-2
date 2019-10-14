package com.example.demo.Controladores;

import javax.validation.Valid;
import java.util.List;


import com.example.demo.Entidades.Pago;
import com.example.demo.Servicios.PagoServicio;

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
@RequestMapping("/v1/pago")
public class PagoController{
    @Autowired
    @Qualifier("serviciopago")
    PagoServicio servicio;

    @GetMapping("/pago")
    public Pago obtenerPago(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/pago")
    public boolean agregarPago(@RequestBody @Valid Pago pago){
        return servicio.crear(pago);
    }

    @PutMapping("/pago")
    public boolean actualizarPago(@RequestBody @Valid Pago pago){
        return servicio.actualizar(pago);
    }

    @DeleteMapping("/pago/{id}")
    public boolean borrarPago(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Pago> getAllPago(){
        return servicio.obtenerAll();
    }

}