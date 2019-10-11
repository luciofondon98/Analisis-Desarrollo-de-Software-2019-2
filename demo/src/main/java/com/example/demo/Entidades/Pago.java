package com.example.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Pago")
@Entity
public class Pago{
    @Id
    @GenericGenerator(name="incrementpago", strategy="increment")
    @GeneratedValue(generator="incrementpago")
    @Column(name="id_pago")
    long id_pago;

    @Column(name="id_tecnico")
    long idTecnico;

    @Column(name="id_cliente")
    long idCliente;

    @Column(name="id_consulta")
    long idConsulta;

    @Column(name="monto")
    int monto;

    @OneToMany(mapped = "pago")
    private Set<Tecnico> tecnico;

    @OneToMany(mapped = "pago")
    private Set<Cliente> cliente;

    @OneToMany(mapped = "pago")
    private Set<Consulta> consulta;

    Pago(){

    }

    public Pago(long id_pago,long id_tecnico,long id_cliente,long id_consulta,int monto,Set<Tecnico> tecnico,Set<Cliente> cliente,Set<Consulta> consulta) {
        this.id_pago = id_pago;
        this.idTecnico = id_tecnico;
        this.idCliente= id_cliente;
        this.idConsulta = id_consulta;
        this.monto = monto;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.consulta = consulta;
    }

    public long getId_Pago() {
        return this.id_pago;
    }

    public void setId_Pago(long id_pago) {
        this.id_pago = id_pago;
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

    public long getId_Consulta(){
        return this.idConsulta;
    }

    public void setId_Consulta(long idConsulta) {
        this.idConsulta = idConsulta;
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

    public Set<Consulta> getConsulta() {
        return this.consulta;
    }

    public void setConsulta(Set<Consulta> consulta) {
        this.consulta = consulta;
    }
    
}