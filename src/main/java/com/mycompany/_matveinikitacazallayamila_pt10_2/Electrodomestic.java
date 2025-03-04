/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

import Exceptions.colorException;
import Exceptions.consumEnergeticException;
import Exceptions.pesException;
import Exceptions.preuBaseException;

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
    protected static final int MAJ_MIN = 65;
    protected static final int MAJ_MAX = 70;
    protected static final int MIN_MIN = 97;
    protected static final int MIN_MAX = 102;
    protected static final char A_MAJ = 'A';
    protected static final char B_MAJ = 'B';
    protected static final char C_MAJ = 'C';
    protected static final char D_MAJ = 'D';
    protected static final char E_MAJ = 'E';
    protected static final char F_MAJ = 'F';
    protected static final char A_MIN = 'a';
    protected static final char B_MIN = 'b';
    protected static final char C_MIN = 'c';
    protected static final char D_MIN = 'd';
    protected static final char E_MIN = 'e';
    protected static final char F_MIN = 'f';
    
    
    /**
     * Constructor per defecte del objecte Electrodomestic
     */
    public Electrodomestic() throws Exception {
        this(PREU_BASE_DEFECTE, PES_DEFECTE);
    }
    
    /**
     * Constructor que rep els paràmetres de preu i pes. Els altres atributs són
     * predeterminats
     * @param preu
     * @param pes 
     */
    public Electrodomestic(int preu, int pes) throws Exception {
        this(preu, pes, COLOR_DEFECTE, CONSUM_ENERG_DEFECTE);
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
        if (this.preuBase < 0){
            throw new preuBaseException("El preu és negatiu");
        }
        if (this.pes < 0){
            throw new pesException("El pes és negatiu");
        }
    }
    
    /**
     * Mètode comprovarConsumEnergetic per comprovar que l'etiqueta del consum
     * energètic sigui correcte 
     * @param lletra 
     */
    private void comprovarConsumEnergetic(char lletra){
        
        int lletraASCII = (int) lletra;
        
        if ((lletraASCII >= MAJ_MIN && lletraASCII <= MAJ_MAX) || 
                (lletraASCII >= MIN_MIN && lletraASCII <= MIN_MAX)) {
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
        
        if (consumEnergetic == A_MAJ || consumEnergetic == A_MIN) {
            preuF += 100;
        } else if (consumEnergetic == B_MAJ || consumEnergetic == B_MIN) {
            preuF += 80;
        } else if (consumEnergetic == C_MAJ || consumEnergetic == C_MIN) {
            preuF += 60;
        } else if (consumEnergetic == D_MAJ || consumEnergetic == D_MIN) {
            preuF += 50;
        } else if (consumEnergetic == E_MAJ || consumEnergetic == E_MIN) {
            preuF += 30;
        } else if (consumEnergetic == F_MAJ || consumEnergetic == F_MIN){
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