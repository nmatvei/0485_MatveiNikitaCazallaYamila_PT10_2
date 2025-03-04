/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

/**
 *  Subclasse Rentadora
 * @author Nikita i Yamila
 */
public class Rentadora extends Electrodomestic{
    /*Declaració de variables i atributs*/
    private int carrega;
    private final int CARREGA_DEFECTE = 5;

    /**
     * Constructor per defecte
     */
    public Rentadora() throws Exception{
        super();
        this.carrega = CARREGA_DEFECTE;
    }
    /**
     * Constructor que rep els paràmetres de preu i pes. Els altres atributs són
     * predeterminats
     * @param preu
     * @param pes 
     */
    public Rentadora(int preu, int pes) throws Exception{
        super(preu, pes);
        this.carrega = CARREGA_DEFECTE;
    }
    
    /**
     * Constructor que rep tots el parametres pels atributs
     * @param carrega
     * @param preu
     * @param pes
     * @param color
     * @param energia
     * @throws Exception 
     */
    public Rentadora(int carrega, int preu, int pes, String color, char energia) throws Exception {
        super(preu, pes, color, energia);
        this.carrega = carrega;
    }
    
    /**
     * Mètode GET per conseguir la càrrega de la rentadora
     * @return 
     */
    public int getCarrega() {
        return carrega;
    }
    
    /**
     * Mètode preuFinal sobrescrit per calcular el preu en base a la càrrega de
     * la rentadora
     * @return 
     */
    @Override
    public int preuFinal() {
        int preuF = super.preuFinal();
        
        /*Comprovem que la càrrga sigui major a 30 per afegir 50 al preu*/
        if (this.carrega > 30) {
            preuF += 50;
        }
        
        return preuF;
    }
}