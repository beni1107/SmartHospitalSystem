/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

import java.time.LocalDate;

/**
 *
 * @author beni
 */
public class OutPatient extends Patient{
    protected LocalDate appointmentTime;
    
    public OutPatient(String id, String name,int age, int severenityLevel) {
        super(id,name,age,severenityLevel);
        this.appointmentTime = LocalDate.now().plusDays(14 + (int)(Math.random()*30));
    }

    public LocalDate getAppointmentTime() {
        return appointmentTime;
    }
    @Override
    public String toString() {
        return super.toString()+""
                + "datum za pregled: "+this.appointmentTime;
    }
}
