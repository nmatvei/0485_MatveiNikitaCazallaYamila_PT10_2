/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

/**
 *
 * @author Nikita i Yamila
 */
public class Televisio extends Electrodomestic{
    
    private int mida;
    private boolean resolucio4K;
    private final int MIDA_DEFECTE = 20;
    private final boolean RESOLUCIO_DEFECTE = false;

    /**
     *
     */
    public Televisio() throws Exception {
        this.mida = MIDA_DEFECTE;
        this.resolucio4K = RESOLUCIO_DEFECTE;
    }

    public Televisio(int preu, int pes) throws Exception {
        super(preu, pes);
        this.mida = MIDA_DEFECTE;
        this.resolucio4K = RESOLUCIO_DEFECTE;
    }

    public Televisio(int mida, boolean resolucio4K, int preu, int pes, String color, char energia) throws Exception {
        super(preu, pes, color, energia);
        this.mida = mida;
        this.resolucio4K = resolucio4K;
    }

    public int getMida() {
        return mida;
    }

    public boolean isResolucio4K() {
        return resolucio4K;
    }

    @Override
    public int preuFinal() {
        
        if (mida > 40) {
            super.preuBase *= 0.30;
        }
        
        if (resolucio4K) {
            super.preuBase += 50;
        }
        
        return super.preuFinal(); 
    }

    
}
