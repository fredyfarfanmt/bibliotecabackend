/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacubiculo.biblioteca.app.entities;

import java.io.Serializable;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Fmfarfan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "countscore")
public class CountScore implements Serializable{
    
    private int completed;
    private int cancelled;
    
}
