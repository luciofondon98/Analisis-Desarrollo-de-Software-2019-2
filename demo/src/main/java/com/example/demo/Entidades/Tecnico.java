package com.example.demo.Entidades;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Tecnico")
@Entity
public class Tecnico{
    @Id
    @GenericGenerator(name="incrementtecnico", strategy="increment")
    @GeneratedValue(generator="incrementtecnico")
    @Column(name="id_tecnico")
    long id;

    @Column(name="nombre_tecnico")
    String nombre;

    @Column(name="correo_tecnico")
    String correo;

    @Column(name="contrasena_tecnico")
    String contrasena;

    @OneToMany(mappedBy="tecnico")
    private Set<Pago> pagos;
    
    @OneToMany(mappedBy="tecnico")
    private Set<Consulta> consultas;
    
    @OneToMany(mappedBy="tecnico")
    private Set<Calificacion> calificaciones;
    
    @OneToMany(mappedBy="tecnico")
    private Set<Mensajeria> mensajerias;
    
    public Tecnico(){

    }

    public Tecnico(long id, String nombre, String correo, String contrasena, Set<Pago> pagos, Set<Consulta> consultas,Set<Mensajeria> mensajerias, Set<Calificacion> calificaciones) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.pagos = pagos;
        this.consultas = consultas;
        this.mensajerias = mensajerias;
        this.calificaciones = calificaciones;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public Set<Pago> getPago() {
        return this.pagos;
    }
    
    public void setPago(Set<Pago> pagos) {
        this.pagos = pagos;
    }
    
    public Set<Consulta> getConsulta() {
        return this.consultas;
    }
    
    public void setConsulta(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    public Set<Mensajeria> getMensajeria() {
        return this.mensajerias;
    }
    
    public void setMensajeria(Set<Mensajeria> mensajerias) {
        this.mensajerias = mensajerias;
    }
    
    public Set<Calificacion> getCalificacion() {
        return this.calificaciones;
    }

    public void setCalificacion(Set<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
