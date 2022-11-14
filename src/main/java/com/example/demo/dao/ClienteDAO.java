package com.example.demo.dao;

import com.example.demo.models.Cliente;
import java.util.List;

public interface ClienteDAO {
    List<Cliente> getClientes();
    //List<Cliente> getClientesQuery();
    void deleteClientes(Long id);
}
