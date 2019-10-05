package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Cliente;
import com.example.demo.Servicios.ClienteServicio;

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
@RequestMapping("/v1/jugador")
public class JugadorController{
    @Autowired
    @Qualifier("serviciojugador")
    JugadorServicio servicio;

    @GetMapping("/jugador")
    public Jugador obtenerJugador(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/jugador")
    public boolean agregarJugador(@RequestBody @Valid Jugador jugador){
        return servicio.crear(jugador);
    }

    @PutMapping("/jugador")
    public boolean actualizarJugador(@RequestBody @Valid Jugador jugador){
        return servicio.actualizar(jugador);
    }

    @DeleteMapping("/jugador/{id}")
    public boolean borrarJugador(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/equipo")
    public List<Jugador> obtenerPorEquipo(@RequestParam(name="equipo", required = true) long equipo){
        return servicio.obtenerByEquipo(equipo);
    }

}
