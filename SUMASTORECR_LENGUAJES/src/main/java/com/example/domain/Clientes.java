/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author XSF
 */
@Data
@Entity
@Table(name = "FIDE_CLIENTES_TB")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FIDE_CLIENTES_TB_ID_CLIENTE_PK", nullable = false)
    private String idCliente;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private String nombre;

    @Column(name = "CORREO", nullable = false, length = 255)
    private String correo;

    @Column(name = "CONTRASENA", nullable = false, length = 50)
    private String contrasena;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @Column(name = "DIRECCION", length = 255)
    private String direccion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION", nullable = false, updatable = false)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_MODIFICACION")
    private Date fechaModificacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaModificacion = new Date();
    }

    public Clientes() {
        this.fechaCreacion = new Date();
    }
}
