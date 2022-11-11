package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired //instance
    ClienteRepository clienteRepository;
    
    public ArrayList<Cliente> getClientes(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getClienteById(Long id){
        return clienteRepository.findById(id);
    }

    public ArrayList<Cliente> getClienteByEstado(boolean estado){
        return clienteRepository.findByEstado(estado);
    }

    public boolean deleteById(Long id){
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
