package com.example.demo.Entidades;

//import java.util.Set;

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

    @Column(name="id_tecnico")
    long tecnico;

    @Column(name="id_cliente")
    long cliente;

    @Column(name="monto")
    int monto;

    @Column(name="id_consulta")
    Long consulta;

    Pago(){

    }

    public Pago(long id,long id_tecnico,long id_cliente,int monto, Long consulta) {
        this.id = id;
        this.tecnico = id_tecnico;
        this.cliente= id_cliente;
        this.monto = monto;
        this.consulta = consulta;
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

    public int getMonto() {
        return this.monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Long getConsulta(){
        return this.consulta;
    }

    public void setConsulta(Long consulta) {
        this.consulta = consulta;
    }
}