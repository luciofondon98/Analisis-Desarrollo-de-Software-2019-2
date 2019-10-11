package com.example.demo.Entidades;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Calificacion")
@Entity
public class Calificacion{
    @Id
    @GenericGenerator(name="incrementcalificacion", strategy="increment")
    @GeneratedValue(generator="incrementcalificacion")
    @Column(name="id_calificacion")
    long id_calificacion;

    @Column(name="id_tecnico")
    long idTecnico;

    @Column(name="id_cliente")
    long idCliente;

    @Column(name="nota")
    int nota;

    @OneToMany(mapped = "Calificacion")
    private Set<Tecnico> tecnico;

    @OneToMany(mapped = "Calificacion")
    private Set<Cliente> cliente;

    Calificacion(){

    }

    public Calificacion(long id_calificacion, long idTecnico,long idCliente,int nota, Set<Tecnico> tecnico, Set<Cliente> cliente) {
        this.id_calificacion = id_calificacion;
        this.idTecnico = idTecnico;
        this.idCliente = idCliente;
        this.nota = nota;
        this.tecnico = tecnico;
        this.cliente = cliente;
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

    public int getNota(){
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
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

}