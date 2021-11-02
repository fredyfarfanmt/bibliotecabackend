/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories;

import com.rentacubiculo.biblioteca.app.entities.Client;
import com.rentacubiculo.biblioteca.app.entities.CountClients;
import com.rentacubiculo.biblioteca.app.entities.Reservation;
import com.rentacubiculo.biblioteca.app.repositories.crud.ReservationCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fmfarfan
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository repository;
    
    /**
     * Consultar
     * @return 
    */
    
        public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<Reservation> getReservation(int id){
        return repository.findById(id);
    }
    
    /**
     * Registrar
     */
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    
    /**
     * Eliminar
     */
    public void delete(Reservation reservation){
        repository.delete(reservation);
    }
    
    public List<Reservation> getLibraryByStatus(String status)
    {
        return repository.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date a, Date b)
    {
        return   repository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
          
        public List<CountClients> getToClientByClient(){
        
        List<CountClients>res = new ArrayList<>(); 
        List<Object[]> report = repository.countTotalCostumesByClient();
        for(int i=0;i<report.size();i++){
            
            
////            Long cli=(Long) report.get(i)[0];
////            Long cantidad=(Long) report.get(i)[1];
////            CountClients cc=new CountClients(cantidad,cli);
////            res.add(cc);
            
            res.add(new CountClients((Long) report.get(i)[0],(Client)report.get(i)[1])); 
        } 
        return res;
    }
}