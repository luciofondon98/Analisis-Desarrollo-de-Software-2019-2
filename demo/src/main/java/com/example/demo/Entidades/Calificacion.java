package com.example.demo.Entidades;

//import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Calificacion")
@Entity
public class Calificacion{
    @Id
    @GenericGenerator(name="incrementcalificacion", strategy="increment")
    @GeneratedValue(generator="incrementcalificacion")
    @Column(name="id_calificacion")
    long id;

    @Column(name="id_tecnico")
    long tecnico;

    @Column(name="id_cliente")
    long cliente;

    @Column(name="nota")
    int nota;


    Calificacion(){

    }

    public Calificacion(long id, long tecnico,long cliente,int nota) {
        this.id = id;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.nota = nota;
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

    public int getNota(){
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}