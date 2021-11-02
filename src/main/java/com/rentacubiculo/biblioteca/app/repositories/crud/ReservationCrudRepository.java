/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.repositories.crud;

import com.rentacubiculo.biblioteca.app.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Fmfarfan
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    //JPQL
   @Query("SELECT count(r.client), r.client as total FROM Reservation AS r GROUP BY r.client ORDER BY count(r.client) DESC")
   
   public List<Object[]> countTotalCostumesByClient();   
    
   public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
   
   public List<Reservation> findAllByStatus(String status);
    
}
