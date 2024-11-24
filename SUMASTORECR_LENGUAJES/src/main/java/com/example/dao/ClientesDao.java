/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesDao extends JpaRepository<Clientes, Long> {
}
