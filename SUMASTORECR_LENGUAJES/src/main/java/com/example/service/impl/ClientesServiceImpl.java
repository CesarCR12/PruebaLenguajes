/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service.impl;

import com.example.dao.ClientesDao;
import com.example.domain.Clientes;
import com.example.service.ClientesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesDao clientesDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> getClientes(boolean activos) {
        return clientesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes getClientes(Clientes clientes) {
        return clientesDao.findById(clientes.getClienteId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Clientes clientes) {
        clientesDao.save(clientes);
    }

    @Override
    @Transactional
    public void delete(Clientes clientes) {
        jdbcTemplate.update("CALL FIDE_CLIENTES_TB_ELIMINAR_SP(?)", clientes.getClienteId());
    }

    @Override
    @Transactional
    public void insert(int clienteId, String nombre, String correo, String contrasena, String telefono) {
        jdbcTemplate.update("CALL FIDE_CLIENTES_TB_INSERTAR_CLIENTE_SP(?, ?, ?, ?)", nombre, correo, contrasena, telefono);
    }

    @Override
    @Transactional
    public void update(int clienteId, String nombre, String correo, String contrasena, String telefono) {
        jdbcTemplate.update("CALL FIDE_CLIENTES_TB_ACTUALIZAR_CLIENTE_SP(?, ?, ?, ?, ?)", clienteId, nombre, correo, contrasena, telefono);
    }

    @Override
    public String getClientesFiltradosPorNombre(String nombre) {
        String resultado = "";
        try {
            String query = "{ ? = call FIDE_CLIENTES_TB_FILTRAR_CLIENTES_FN(?) }";
            resultado = jdbcTemplate.queryForObject(query, new Object[]{nombre}, String.class);
        } catch (Exception e) {
            resultado = "Error: " + e.getMessage();
        }
        return resultado;
    }

    @Override
    public void insert(String nombre, String correo, String contrasena, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void detel(String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String idCliente, String nombre, String correo, String contrasena, String telefono, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

