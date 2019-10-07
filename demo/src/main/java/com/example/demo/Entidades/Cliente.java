package com.example.demo.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Cliente")
@Entity
public class Cliente{
    @Id
    @GenericGenerator(name="incrementcliente", strategy="increment")
    @GeneratedValue(generator="incrementcliente")
    @Column(name="id_cliente")
    long id_cliente;

    @Column(name="nombre_cliente")
    String nombre;

    @Column(name="correo_cliente")
    String correo;

    @Column(name="contrasena_cliente")
    String contrasena;

    public Cliente(){

    }

    public Cliente(long id_cliente, String nombre, String correo, String contrasena) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public long getId() {
        return this.id_cliente;
    }

    public void setId(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}