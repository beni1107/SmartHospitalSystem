/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

/**
 *
 * @author beni
 */
public class WardAtCapacityException extends Exception{
    private int currentPatientCount;
    
    public WardAtCapacityException(int currentPatient) {
        super("Oddelek je poln: "+currentPatient);
        this.currentPatientCount=currentPatient;
        
    }
    public int getCurrentPatientCount(){
        return this.currentPatientCount;
    }
    
}
