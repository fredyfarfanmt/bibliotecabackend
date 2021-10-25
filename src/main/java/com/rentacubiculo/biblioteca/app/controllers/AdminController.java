/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.controllers;

import com.rentacubiculo.biblioteca.app.entities.Admin;
import com.rentacubiculo.biblioteca.app.services.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fmfarfan
 */
@RestController
@RequestMapping("Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    
               @Autowired
    private AdminService service;
    
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return service.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Admin save (@RequestBody Admin admin)
    {
        return service.save(admin);
    }
    
    
    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Admin update (@RequestBody Admin admin)
    {
        return service.update(admin);
    }
     @DeleteMapping("/{id}")
     //@ResponseStatus (HttpStatus.CREATED)
       @ResponseStatus(HttpStatus.NO_CONTENT)


    public boolean delete(@PathVariable("id") int adminId)
    {
        return service.delete(adminId);
    }
}
