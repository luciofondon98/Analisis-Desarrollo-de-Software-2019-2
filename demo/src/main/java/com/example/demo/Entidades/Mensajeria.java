package com.example.demo.Entidades;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.print.DocFlavor.STRING;

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
    long idTecnico;

    @Column(name="id_cliente")
    long idCliente;

    @Column(name="mensaje")
    String mensaje;
    
    Mensajeria(){

    }

    public Mensajeria(long id, long idTecnico, long idCliente, String mensaje){
        this.id = id;
        this.idTecnico = idTecnico;
        this.idCliente = idCliente;
        this.mensaje = mensaje;
    }

    public long getId_Mensajeria() {
        return this.id;
    }

    public void setId_Mensajeria(long id) {
        this.id = id;
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

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}