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

    public long getId_Pago() {
        return this.id;
    }

    public void setId_Pago(long id) {
        this.id = id;
    }

    public long getId_Tecnico(){
        return this.tecnico;
    }

    public void setId_Tecnico(long tecnico) {
        this.tecnico = tecnico;
    }

    public long getId_Cliente(){
        return this.cliente;
    }

    public void setId_Cliente(long cliente) {
        this.cliente = cliente;
    }

    public long getId_Consulta(){
        return this.idConsulta;
    }

    public void setId_Consulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }
}