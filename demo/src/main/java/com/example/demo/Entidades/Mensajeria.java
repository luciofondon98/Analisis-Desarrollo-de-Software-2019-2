package com.example.demo.Entidades;

import java.util.Set;

//import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.print.DocFlavor.STRING;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;


import org.hibernate.annotations.GenericGenerator;

@Table(name="Mensajeria")
@Entity
public class Mensajeria{
    @Id
    @GenericGenerator(name="incrementmensajeria", strategy="increment")
    @GeneratedValue(generator="incrementmensajeria")
    @Column(name="id_mensajeria")
    long id;

    @Column(name="id_tecnico")
    long tecnico;

    @Column(name="id_cliente")
    long cliente;

    @Column(name="mensaje")
    String mensaje;

    @Column(name="id_consulta")
    Long consulta;

    @Column(name="destinatario")
    Long destinatario;
    
    
    Mensajeria(){

    }

    public Mensajeria(long id, long tecnico, long cliente, String mensaje, Long consulta, Long destinatario){
        this.id = id;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.mensaje = mensaje;
        this.consulta = consulta;
        this.destinatario = destinatario;
    }

    public long getId() {
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

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getConsulta(){
        return this.consulta;
    }

    public void setConsulta(Long consulta) {
        this.consulta = consulta;
    }

    public Long getDestinatario(){
        return this.destinatario;
    }

    public void setDestinatario(long destinatario) {
        this.destinatario = destinatario;
    }
}