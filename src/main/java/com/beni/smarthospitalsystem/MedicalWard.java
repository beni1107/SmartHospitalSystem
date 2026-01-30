/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author beni
 * @param <T>
 */
public class MedicalWard<T extends Patient & Identifiable> {
    
    private List<T> patients;
    private int maxCapacity;
    private String wardName;
    
    public MedicalWard(int maxCapacity, String wardName) {
        Objects.requireNonNull(wardName, "Ime oddelka ne more biti null");
        this.maxCapacity=maxCapacity;
        this.wardName = wardName;
        this.patients=new ArrayList<>();
    }
    
    public void admitPatient(T patient) throws WardAtCapacityException{
       long criticalPatients = patients.stream()
                .filter(p->p instanceof InPatient)
                .filter(p->((InPatient)p).isCritical).count();
       if(criticalPatients > 3) {
           System.out.println("WARNING: HIGH number of critical patients in ward");
       }
        
        
        if(this.maxCapacity >= this.patients.size()) {
           throw new WardAtCapacityException(maxCapacity);
        }
        patients.add(patient);
    }
}
