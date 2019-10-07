package com.example.demo.Entidades;

/*import java.util.Set;*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="TECNICO")
@Entity
public class Tecnico{
    @Id
    @GenericGenerator(name="incrementtecnico", strategy="increment")
    @GeneratedValue(generator="incrementtecnico")
    @Column(name="id_tecnico")
    long id_tecnico;

    @Column(name="nombre_tecnico")
    String nombre;

    @Column(name="correo_tecnico")
    String correo;

    @Column(name="contrasena_tecnico")
    String contrasena;

    public Tecnico(){

    }

    public Tecnico(long id, String nombre, String correo, String contrasena) {
        this.id_tecnico = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public long getId() {
        return this.id_tecnico;
    }

    public void setId(long id_tecnico) {
        this.id_tecnico = id_tecnico;
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

}
