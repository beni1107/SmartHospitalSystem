/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.beni.smarthospitalsystem;

import java.util.Random;

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
                    md.admitPatient(new InPatient(Beni.randomID(), Beni.randomName(), r.nextInt(65), r.nextInt(11),
                            r.nextInt(7), r.nextBoolean()));
                }else {
                    md.admitPatient(new OutPatient(Beni.randomID(),Beni.randomName(),r.nextInt(65),r.nextInt(11)));
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
        
    }
   
}
