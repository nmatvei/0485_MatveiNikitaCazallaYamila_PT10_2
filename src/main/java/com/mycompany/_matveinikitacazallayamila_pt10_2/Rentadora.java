/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

/**
 *
 * @author Nikita i Yamila
 */
public class Rentadora extends Electrodomestic {
    
    private int carrega;
    private final int CARREGA_DEFECTE = 5;

    /**
     * Constructor per defecte
     */
    public Rentadora(){
        super();
        this.carrega = CARREGA_DEFECTE;
    }

    public Rentadora(int preu, int pes) throws Exception {
        super(preu, pes);
        this.carrega = CARREGA_DEFECTE;
    }

    public Rentadora(int carrega, int preu, int pes, String color, char energia) throws Exception {
        super(preu, pes, color, energia);
        this.carrega = carrega;
    }

    public int getCarrega() {
        return carrega;
    }

    @Override
    public int preuFinal() {
        //Preguntar si tiene además de los 50 se le incrementa el precio de entre 20kg y 50kg
        int preuF = super.preuFinal();
        
        if (pes > 30) {
            preuF += 50;
        }
        return preuF;
    }
    
    
    
}
