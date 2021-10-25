/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Category;
import com.rentacubiculo.biblioteca.app.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fmfarfan
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    
        public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Category> getCategory(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Category save(Category category){
        return repository.save(category);
    }
    
    /**
     * Eliminar
     */
    public void delete(Category category){
        repository.delete(category);
    }
    

}