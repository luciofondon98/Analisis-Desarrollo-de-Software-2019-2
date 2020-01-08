package com.example.demo.Entidades;

//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.OneToOne;


import org.hibernate.annotations.GenericGenerator;

@Table(name="Consulta")
@Entity
public class Consulta {
    @Id
    @GenericGenerator(name="incrementconsulta", strategy="increment")
    @GeneratedValue(generator="incrementconsulta")


    @Column(name="id_consulta")
    long id;

    @Column(name="id_tecnico")
    long tecnico;

    @Column(name="id_cliente")
    long cliente;

    @Column(name="titulo")
    String titulo;

    @Column(name="descripcion")
    String descripcion;

    @Column(name="categoria")
    String categoria;

    @Column(name="estado")
    String estado;

    @OneToOne(mappedBy= "consulta" ,cascade = CascadeType.ALL)
    private Mensajeria mensajeria;


    
    public Consulta(){

    }

    public Consulta(long id, long tecnico, long cliente, String titulo, String descripcion, String categoria ,Mensajeria mensajeria, String estado) {
        this.id = id;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.mensajeria = mensajeria;
        this.estado = estado;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTecnico(){
        return this.tecnico;
    }

    public void setTecnico(long tecnico) {
        this.tecnico = tecnico;
    }

    public long getCliente(){
        return this.cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setEstado(String estado){
        this.estado=estado;
    }
}