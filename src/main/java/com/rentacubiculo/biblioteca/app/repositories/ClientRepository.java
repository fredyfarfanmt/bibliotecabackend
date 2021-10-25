/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Client;
import com.rentacubiculo.biblioteca.app.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fmfarfan
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository repository;
    
    /**
     * Consultar
     */
    public List<Client> getAll(){
        return (List<Client>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Client> getClient(int id){
        return repository.findById(id);
        
    }
    /**
     * Registrar
     */
    
    public Client save(Client client){
        return repository.save(client);
    }   

    /**
     * Borrar
     */
    
    public void delete(Client client){
        repository.delete(client);
    }
}
