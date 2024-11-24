/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.domain.Clientes;
import com.example.service.ClientesService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/listado")
    public String listarClientes(Model model) {
        var clientes = clientesService.getClientes(false);
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "clientes/listado"; // Ajusta según tu vista
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Clientes cliente) {
        return "clientes/modifica"; // Ajusta según tu vista
    }

    @PostMapping("/guardar")
    public String guardarCliente(Clientes cliente) {
        clientesService.insertarCliente(cliente.getNombre(), cliente.getCorreo(), cliente.getContrasena(), cliente.getTelefono());
        return "redirect:/clientes/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") String id) {
        clientesService.delete(id);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificarCliente(@PathVariable("id") String id, Model model) {
        var cliente = clientesService.findById(id);
        if (cliente == null) {
            return "redirect:/error";
        }
        model.addAttribute("cliente", cliente);
        return "clientes/modificar"; // Ajusta según tu vista
    }

    @PostMapping("/update")
    public String actualizarCliente(@ModelAttribute Clientes cliente) {
        clientesService.update(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getCorreo(),
                cliente.getContrasena(),
                cliente.getTelefono());
        return "redirect:/clientes/listado";
    }

    @GetMapping("/filtrarPorNombre")
    public String filtrarPorNombre(@RequestParam("nombre") String nombre, Model model) {
        var clientesFiltrados = clientesService.filtrarPorNombre(nombre);
        model.addAttribute("clientes", clientesFiltrados);
        return "clientes/listado"; // Ajusta según tu vista
    }
}

