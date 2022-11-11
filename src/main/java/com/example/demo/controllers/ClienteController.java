package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping()
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return this.clienteService.saveCliente(cliente);
    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> getClienteById(@PathVariable("id") Long id) {
        return this.clienteService.getClienteById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<Cliente> getClientesByEstado(@RequestParam("estado") boolean estado) {
        return this.clienteService.getClienteByEstado(estado);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean result = this.clienteService.deleteById(id);
        if (result) {
            return "Usuario eliminado";
        } else {
            return "No se pudo eliminar";
        }
    }

}
