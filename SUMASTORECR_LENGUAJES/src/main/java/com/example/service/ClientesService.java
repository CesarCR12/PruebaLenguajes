/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.domain.Clientes;
import java.util.List;

public interface ClientesService {

    public List<Clientes> getClientes(boolean activos);

    public Clientes getClientes(Clientes clientes);

    public void save(Clientes clientes);

    public void delete(Clientes clientes);

    public void insert(String nombre, String correo, String contrasena, String telefono);

    public void detel(String idCliente);

    public void update(String idCliente, String nombre, String correo, String contrasena, String telefono, String direccion);

    public String getClientesFiltradosPorNombre(String nombre);
}

