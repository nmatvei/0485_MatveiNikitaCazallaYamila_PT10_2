/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

import Exceptions.colorException;
import Exceptions.consumEnergeticException;

/**
 * Superclasse Electrodomestic
 * @author Nikita i Yamila
 */
public class Electrodomestic {
    /*Declaració d'atributs i variables*/
    protected int preuBase, pes;
    protected String color;
    protected char consumEnergetic;
    protected static final String COLOR_DEFECTE = "Blanc";
    protected static final char CONSUM_ENERG_DEFECTE = 'F';
    protected static final int PREU_BASE_DEFECTE = 100, PES_DEFECTE = 5;
    
    /**
     * Constructor per defecte del objecte Electrodomestic
     */
    public Electrodomestic(){
        this.color = COLOR_DEFECTE;
        this.consumEnergetic = CONSUM_ENERG_DEFECTE;
        this.preuBase = PREU_BASE_DEFECTE;
        this.pes = PES_DEFECTE;
    }
    
    /**
     * Constructor que rep els paràmetres de preu i pes. Els altres atributs són
     * predeterminats
     * @param preu
     * @param pes 
     */
    public Electrodomestic(int preu, int pes){
        this.color = COLOR_DEFECTE;
        this.consumEnergetic = CONSUM_ENERG_DEFECTE;
        this.preuBase = preu;
        this.pes = pes;
    }
    
    /**
     * Constructor que rep tots el parametres pels atributs
     * @param preu
     * @param pes
     * @param color
     * @param energia
     * @throws Exception 
     */
    public Electrodomestic(int preu, int pes, String color, char energia) throws Exception {
        this.color = color;
        this.consumEnergetic = energia;
        this.preuBase = preu;
        this.pes = pes;
        comprovarConsumEnergetic(consumEnergetic);
        comprovarColor(color);
    }
    
    /**
     * Mètode comprovarConsumEnergetic per comprovar que l'etiqueta del consum
     * energètic sigui correcte 
     * @param lletra 
     */
    private void comprovarConsumEnergetic(char lletra){
        
        if (lletra == 'A' || lletra == 'a' ||
            lletra == 'B' || lletra == 'b' ||
            lletra == 'C' || lletra == 'c' ||
            lletra == 'D' || lletra == 'd' ||
            lletra == 'E' || lletra == 'e' ||
            lletra == 'F' || lletra == 'f') {
            this.consumEnergetic = lletra;
        } else {
            System.out.println("S'ha introduït una etiqueta del consum energètic"
                    + " incorrecte, es possarà l'etiqueta per defecte: F");
            this.consumEnergetic = CONSUM_ENERG_DEFECTE;
        }
        
    }
    
    /**
     * Mètode comprovarColor per comprovar si el color introduït en el objecte és
     * correcte
     * @param color 
     */
    private void comprovarColor(String color){
        
        if (color.equalsIgnoreCase("Blanc") ||
            color.equalsIgnoreCase("Negre") ||
            color.equalsIgnoreCase("Vermell") ||
            color.equalsIgnoreCase("Blau") ||
            color.equalsIgnoreCase("Gris")) {
            this.color = color;
        } else {
            System.out.println("S'ha introduït un color invàlid, es possarà el"
                    + "color per defecte: Blanc");
            this.color = COLOR_DEFECTE;
        }
    }
    
    /**
     * Mètode preuFinal per calcular el preu final del electrodomestic segons
     * el seu consume energétics i el seu pes;
     * @return 
     */
    public int preuFinal() {
        
        int preuF = preuBase;
        
        if (consumEnergetic == 'A' || consumEnergetic == 'a') {
            preuF += 100;
        } else if (consumEnergetic == 'B' || consumEnergetic == 'b') {
            preuF += 80;
        } else if (consumEnergetic == 'C' || consumEnergetic == 'c') {
            preuF += 60;
        } else if (consumEnergetic == 'D' || consumEnergetic == 'd') {
            preuF += 50;
        } else if (consumEnergetic == 'E' || consumEnergetic == 'e') {
            preuF += 30;
        } else if (consumEnergetic == 'F' || consumEnergetic == 'f'){
            preuF += 10;
        }
        
        if (pes >= 0 && pes < 20) {
           preuF += 10; 
        } else if (pes >= 20 && pes < 50) {
            preuF += 50;
        } else if (pes >= 50 && pes < 80) {
            preuF += 80;
        } else if (pes > 80) {
            preuF += 100;
        }
        
        return preuF;
    }
    
    /**
     * Mètode GET per conseguir el preu base
     * @return 
     */
    public int getPreuBase() {
        return preuBase;
    }
    
    /**
     * Mètode GET per conseguir el pes
     * @return 
     */
    public int getPes() {
        return pes;
    }
    
    /**
     * Mètode GET per conseguir el color
     * @return 
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Mètode GET per conseguir el consum energétic
     * @return 
     */
    public char getConsumEnergetic() {
        return consumEnergetic;
    }
}