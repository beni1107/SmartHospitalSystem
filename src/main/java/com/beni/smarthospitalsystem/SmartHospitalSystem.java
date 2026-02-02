/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.beni.smarthospitalsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author beni
 */
public class SmartHospitalSystem {

    public static void main(String[] args) {
        Random r = new Random();
        MedicalWard<Patient> md = new MedicalWard<>(50,"TESTNI ODDELEK");
        
        for(int i= 0; i<52;i++) {
            try {
                if (r.nextInt(2) == 0 ) {
                    md.admitPatient(new InPatient(Beni.randomID(), Beni.randomName(), r.nextInt(90), r.nextInt(11),
                            r.nextInt(7), r.nextBoolean()));
                }else {
                    md.admitPatient(new OutPatient(Beni.randomID(),Beni.randomName(),r.nextInt(90),r.nextInt(11)));
                }
            }catch (WardAtCapacityException e) {
                System.err.println(e.getCurrentPatientCount());
            }
        }
        md.printStatistics();
        System.out.println("-- REPORT CRITICAL --");
        System.out.println("");
        md.printReportSevAbove8();
        System.out.println("");
        System.out.println("-- END OF CRITICAL REPORT  --");
        System.out.println("");
        System.out.println("-- PRINT ALL --");
        System.out.println("");
        md.printAll();
        System.out.println("");
        System.out.println("-- END OF PRINT ALL --");
        System.out.println("");
        System.out.println("-- EMERGENCY PATIENTS --");
        System.out.println("");
        md.printEmergencySummary();
        System.out.println("");
        System.out.println("-- END EMERGENCY PATIENTS --");
        System.out.println("-- TOP PRIORITY PERSON --");
        md.findTopPriorityPatient();
     
        System.out.println("");
        System.out.println("");
        
        md.getAgeGroupReport().forEach((group, list) -> {
            System.out.println("Category: "+group+" Size: "+list.size());
            list.forEach(p -> System.out.println(p.getName()));
            System.out.println();
        });
        
        System.out.println("");
        System.out.println("");
        
        md.getHighRiskSubGroup().forEach((patient, list) -> {
            System.out.println("PATIENT: "+patient+" Število :"+
                    list.size());
            list.forEach(p -> System.out.println(p.getId()+"  "+p.getName()));
        });
        
        System.out.println("");
        System.out.println("");
        md.countPatients().forEach((patient, number) -> {
            System.out.println("PATIENT TYPE : "+patient+" STEVILO PACIENTOV: "+number);
        });
    
        System.out.println("");
        System.out.println("");
        md.criticalInPatients().forEach(System.out::println);
        System.out.println("");
        System.out.println("");
        md.averageAgeSeverinity().forEach((patient, age)->{
            System.out.println("PATIENT TYPE: "+patient+" SEVERINITY AVERAGE: "+age);
        });
    }
   
}
