/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

/**
 *  Subclasse Televisio
 * @author Nikita i Yamila
 */
public class Televisio extends Electrodomestic{
    /*Declaració de atributs i variables*/
    private int mida;
    private boolean resolucio4K;
    private final int MIDA_DEFECTE = 20;
    private final boolean RESOLUCIO_DEFECTE = false;

    /**
     * Constructor per defecte
     */
    public Televisio() throws Exception{
        super();
        this.mida = MIDA_DEFECTE;
        this.resolucio4K = RESOLUCIO_DEFECTE;
    }
    /**
     * Constructor que rep els paràmetres de preu i pes. Els altres atributs són
     * predeterminats
     * @param preu
     * @param pes
     */
    public Televisio(int preu, int pes) throws Exception{
        super(preu, pes);
        this.mida = MIDA_DEFECTE;
        this.resolucio4K = RESOLUCIO_DEFECTE;
    }
    
    /**
     * Constructor que rep tots el parametres pels atributs
     * @param mida
     * @param resolucio4K
     * @param preu
     * @param pes
     * @param color
     * @param energia
     * @throws Exception 
     */
    public Televisio(int mida, boolean resolucio4K, int preu, int pes, String color, char energia) throws Exception {
        super(preu, pes, color, energia);
        this.mida = mida;
        this.resolucio4K = resolucio4K;
    }
    
    /**
     * Mètode GET per saber quina és la mida de la tele (en polzades)
     * @return 
     */
    public int getMida() {
        return mida;
    }
    
    /**
     * Mètode GET per saber si la resolució de la tele és 4K o no
     * @return 
     */
    public boolean getResolucio4K() {
        return resolucio4K;
    }

    /**
     * Mètode preuFinal sobrescrit per calcular el preu en base a la mida i la
     * resolució de la televisió
     * @return 
     */
    @Override
    public int preuFinal() {
        int preuF = super.preuFinal();
        
        /*Pugem el preu si la mida és major a 40 polzades*/
        if (mida > 40) {
            preuF *= 1.30;
        }
        
        /*Pugem el preu si la resolució de la televisió és 4K*/
        if (resolucio4K) {
            preuF += 50;
        }
        
        return super.preuFinal(); 
    }
}