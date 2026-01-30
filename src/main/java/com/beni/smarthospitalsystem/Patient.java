/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

import java.util.Objects;

/**
 *
 * @author beni
 */
public abstract class Patient implements Identifiable, Comparable<Patient>{
    private String id;
    private String name;
    private int age;
    private int severityLevel;
    
    public Patient(String id, String name, int age, int severivityLevel) {
        Objects.requireNonNull(id, "ID ne more biti null");
        Objects.requireNonNull(name," Ime ne more biti null");
        if (severivityLevel >= 1 && severivityLevel <= 10) {
            this.severityLevel=severivityLevel;
        }
        this.id=id;
        this.name=name;
        this.age=age;
        
    }
    @Override
    public String toString() {
        return "ID: "+this.id+" Ime: "+this.name+" starots: "+this.age+" stopnja nujnosti: "+this.severityLevel;
    }
    @Override
    public int compareTo(Patient other) {
       return Integer.compare(other.getSeverityLevel(), this.severityLevel);
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }
    
}
