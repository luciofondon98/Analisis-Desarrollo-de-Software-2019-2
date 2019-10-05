package com.example.demo.Entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Consulta")
@Entity
public class Consulta {
    @Id
    @GenericGenerator(name="incrementconsulta", strategy="increment")
    @GeneratedValue(generator="incrementconsulta")
    @Column(name="id_consulta")
    long id_consulta;

    @Column(name="id_tecnico")
    long idTecnico;

    @Column(name="id_cliente")
    long idCliente;

    @Column(name="titulo")
    String titulo;

    @Column(name="descripcion")
    String descripcion;

    @Column(name="categoria")
    String categoria;

    @OneToMany(mapped = "consulta")
    private Set<Tecnico> tecnico;

    @OneToMany(mapped = "consulta")
    private Set<Cliente> cliente;
    
    public Consulta(){

    }

    public Consulta(long id_consulta, long idTecnico, long idCliente, String titulo, String descripcion, String categoria, Set<Tecnico> tecnico, Set<Cliente> cliente) {
        this.id_consulta = id_consulta;
        this.idTecnico = idTecnico;
        this.idCliente = idCliente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tecnico = tecnico;
        this.cliente = cliente;

    }

    public long getId_Consulta(){
        return this.id_consulta;
    }

    public void setId_Consulta(long id_consulta) {
        this.id_consulta = id_consulta;
    }

    public long getId_Tecnico(){
        return this.idTecnico;
    }

    public void setId_Tecnico(long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public long getId_Cliente(){
        return this.idCliente;
    }

    public void setId_Cliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public String setCategoria(String categoria){
        this.categoria = categoria;
    }

    public Set<Tecnico> getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(Set<Tecnico> tecnico) {
        this.tecnico = tecnico;
    }

    public Set<Cliente> getCliente() {
        return this.cliente;
    }

    public void setCliente(Set<Cliente> cliente) {
        this.cliente = cliente;
    }

}