/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .filter(p->((InPatient)p).isIsCritical()).count();
       if(criticalPatients > 30) {
           System.out.println("WARNING: HIGH number of critical patients in ward");
       }

        if(this.patients.size() >= this.maxCapacity) {
           throw new WardAtCapacityException(maxCapacity);
        }
        patients.add(patient);
    }
    
    public void dischargeRecovered() {
        Iterator<T> it = patients.iterator();
        
        while(it.hasNext()) {
            if(it.next().getSeverityLevel() == 0) {
               
                it.remove();
            }
        }
          
    }
    public void printStatistics() {
        double averageAge = patients.stream().mapToInt(p->p.getAge()).average().orElse(0.0);
        System.out.println("Average Age is: "+averageAge);
        
        long maxAge = patients.stream().mapToInt(p->p.getAge()).max().orElse(0);
        System.out.println("Max age is : "+maxAge);
        
    
    }
    public void printAll() {
        this.patients.stream()
                .map(p ->p.toString()).forEach(System.out::println);
    }
    public void printReportSevAbove8 () {
        this.patients.stream()
                .filter(p -> p.getSeverityLevel() > 8)
                .map(p -> "URGENT: " + p.getName() + " | " + 
                (p instanceof InPatient ? "Room: " + ((InPatient)p).getRoomNumber() : "Outpatient"))
                .forEach(System.out::println);
   
    }
    
    public void printEmergencySummary() {
        
         this.patients.stream()
                    .filter(p->p.getSeverityLevel() > 8)
                    .map(p->p.getName()).collect(Collectors.toList()).forEach(System.out::println);
    
           
          
    }
    
    public void findTopPriorityPatient() {
        this.patients.stream()
                .max(Comparator.comparingInt(p->p.getSeverityLevel())).ifPresent(p-> System.out.println(p.getName()));
    }
    public Map<String, List<T>> getAgeGroupReport (){
        
        
        Map<String, List<T>> tmp =this.patients.stream()
            .collect(Collectors.groupingBy((T p) -> {
                if(p.getAge() < 18) return "Minor";
                if(p.getAge() <65) return "Adult";
                return "Senior";
            }));
        
        return tmp;
    }
    
    public Map<String, List<T>> getHighRiskSubGroup() {
        return this.patients.stream()
                .filter( p -> p.getSeverityLevel() > 7)
                .collect(Collectors.groupingBy( (T p) -> p.getClass().getSimpleName()));
    }
    
    public Map<String, Long> countPatients() {
        return this.patients.stream()
                   .collect(Collectors.groupingBy((T p) -> p.getClass().getSimpleName(),Collectors.counting()));
                   
    }
    
    public List<String> getSeniorEmergencyNames() {
        
    return    this.patients.stream()
                .filter(p -> p.getAge() > 65 && p.getSeverityLevel() > 8)
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }
    public List<String> criticalInPatients() {
        
    return      this.patients.stream()
               .filter(p -> p instanceof InPatient)
               .filter(p -> ((InPatient) p).isIsCritical())
               .map(p -> p.getName())
               .collect(Collectors.toList());
                
    }
    
    public Map<String, Double> averageAgeSeverinity() {
        
       return     this.patients.stream()
                    .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName(), 
                            Collectors.averagingInt((T p) -> p.getSeverityLevel())));
                    
    }
    
    public List<Integer> stableSeniors() {
        
      return      this.patients.stream()
                    .filter(p -> p.getAge() > 70 && p.getSeverityLevel() < 3)
                    .map(p -> Integer.parseInt(p.getId()))
                    .collect(Collectors.toList());
                    
                   
    }
    public void inPatientCriticalState() {
        
            this.patients.stream()
                    .filter(p -> p instanceof InPatient)
                    .filter((InPatient ip) -> ip.isIsCritical());
                    
}