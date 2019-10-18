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
    long idTecnico;

    @Column(name="id_cliente")
    long idCliente;

    @Column(name="nota")
    int nota;


    Calificacion(){

    }

    public Calificacion(long id, long idTecnico,long idCliente,int nota) {
        this.id = id;
        this.idTecnico = idTecnico;
        this.idCliente = idCliente;
        this.nota = nota;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTecnico(){
        return this.idTecnico;
    }

    public void setTecnico(long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public long getCliente(){
        return this.idCliente;
    }

    public void setCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public int getNota(){
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}