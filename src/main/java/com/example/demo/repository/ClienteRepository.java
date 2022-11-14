package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    public abstract ArrayList<Cliente> findByEstado(boolean estado);

    //
    @Query(value = "SELECT cliente FROM Cliente WHERE cliente.nombre LIKE %:nombre%", nativeQuery = true)
    List<Cliente> findByNombre(@Param("nombre") String nombre);


}
