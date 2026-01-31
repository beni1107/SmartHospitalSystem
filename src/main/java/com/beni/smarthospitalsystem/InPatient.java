/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

/**
 *
 * @author beni
 */
public class InPatient extends Patient {
    private int roomNumber;
    private boolean isCritical;
    
    public InPatient(String id, String name,int age, int severenityLevel, int room, boolean critical){
    super(id,name,age,severenityLevel);
    this.roomNumber=room;
    this.isCritical=critical;
    }
    
    @Override
    public String toString() {
        return super.toString()+" "+" stevilka sobe: "+this.roomNumber+" kriticno stanje: "+this.isCritical;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isIsCritical() {
        return isCritical;
    }

    public void setIsCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }
    
}
