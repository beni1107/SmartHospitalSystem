/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smarthospitalsystem;

import java.util.Random;

/**
 *
 * @author beni
 */
public class Beni {
    private static final Random r = new Random();




//RETURNS RANDOM SURNAME    
    public static String randomSurname() {
        String[] priimki = {
                "Novak", "Horvat", "Kovac", "Zupan", "Kralj",
                "Vidmar", "Golob", "Turk", "Bozic", "Zupancic",
                "Kavcic", "Mlakar", "Knez", "Pirc", "Rozman",
                "Hribar", "Zagar", "Cerar", "Petkovsek", "Kolar",
                "Kramar", "Skof", "Bizjak", "Kastelic", "Erjavec",
                "Peric", "Jankovic", "Breznik", "Kos", "Tomazic",
                "Pavlic", "Vukovic", "Bajt", "Dolenc", "Koncnik",
                "Seljak", "Stare", "Zajc", "Logar", "Lampret",
                "Sajovic", "Pustoslemsek", "Zorman", "Oblak", "Prevc",
                "Rant", "Plazar", "Kranjc", "Setnikar", "Svetic",
                "Ferencak", "Majcen", "Ivancic", "Hocevar", "Sirk",
                "Kobal", "Zorc", "Strah", "Kregar", "Podlesnik",
                "Zadnik", "Medved", "Rotar", "Praprotnik", "Ribic"};
        
        return priimki[r.nextInt(60)];
    }

//RETURNS RANDOM NAME 
    public static String randomName() {
        String[] imena = {
                "Ana", "Marko", "Luka", "Maja", "Miha",
                "Nina", "Jan", "Petra", "Nejc", "Tina",
                "David", "Sara", "Rok", "Katarina", "Jure",
                "Eva", "Alen", "Monika", "Andrej", "Lucija",
                "Matej", "Barbara", "Urban", "Sabina", "Simon",
                "Tadej", "Anja", "Blaž", "Vesna", "Klemen",
                "Patrik", "Tamara", "Igor", "Maša", "Filip",
                "Nika", "Denis", "Tea", "Gregor", "Lea",
                "Sebastian", "Irena", "Kristjan", "Mojca", "Žiga",
                "Erik", "Polona", "Mitja", "Klara", "Aleš"};
                                               
        return imena[r.nextInt(imena.length)];
    }
    
    
 //RETURNS RANDOM ID 
    public static String randomID() {
        return Integer.toString(r.nextInt(1500));
    }
}
