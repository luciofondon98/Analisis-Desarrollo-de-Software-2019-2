package com.example.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Pago")
@Entity
public class Pago{
    @Id
    @GenericGenerator(name="incrementpago", strategy="increment")
    @GeneratedValue(generator="incrementpago")
    @Column(name="id_pago")
    long id;

    @Column(name="tecnico")
    long tecnico;

    @Column(name="id_cliente")
    long cliente;

    @Column(name="id_consulta")
    long idConsulta;

    @Column(name="monto")
    int monto;

    Pago(){

    }

    public Pago(long id,long id_tecnico,long id_cliente,long id_consulta,int monto) {
        this.id = id;
        this.tecnico = id_tecnico;
        this.cliente= id_cliente;
        this.idConsulta = id_consulta;
        this.monto = monto;
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

    public long getConsulta(){
        return this.idConsulta;
    }

    public void setConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }
}