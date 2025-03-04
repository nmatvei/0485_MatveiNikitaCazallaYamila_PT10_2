/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

import Exceptions.resolucio4KException;
import Exceptions.consumEnergeticException;
import Exceptions.carregaException;
import Exceptions.colorException;
import Exceptions.pesException;
import Exceptions.polzadesException;
import Exceptions.preuBaseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nikita i Yamila
 */
public class App {
    
    public static void main(String[] args) throws Exception {

        boolean resolucio4K, ElectrodomesticCorrecte = false, llistaPlena;
        int preuBase, pes, carrega, polzades, preuFinal = 0;
        int rentadoraP = 0, televisioP = 0;
        char consumEnergetic;
        String color;
        final int LIMIT_LLISTA = 10;

        ArrayList<Electrodomestic> electrodomestics = new ArrayList<Electrodomestic>(LIMIT_LLISTA);
        //Electrodomestic ele[] = new Electrodomestic[10];

        preuBase = demanarPreu();
        pes = demanarPes();
        carrega = demanarCarrega();
        polzades = demanarPolzades();
        consumEnergetic = demanarConsumEnergetic();
        color = demanarColor();
        resolucio4K = demanarResolucio4K();

        while (!ElectrodomesticCorrecte) {

            try {
                
                Electrodomestic elec1 = new Electrodomestic();
                
                if (LlistaP(electrodomestics)) {
                    throw new Exception("ERROR. Llista plena, no es pot afegir més llistes.");
                } else {
                    electrodomestics.add(elec1);
                }
                
                Electrodomestic elec2 = new Electrodomestic(preuBase, pes);
                electrodomestics.add(elec2);
                Electrodomestic elec3 = new Electrodomestic(preuBase, pes, color,
                        consumEnergetic);
                electrodomestics.add(elec3);
                Rentadora r1 = new Rentadora();
                electrodomestics.add(r1);
                Rentadora r2 = new Rentadora();
                electrodomestics.add(r2);
                Rentadora r3 = new Rentadora();
                electrodomestics.add(r3);
                Televisio tv1 = new Televisio();
                electrodomestics.add(tv1);
                Televisio tv2 = new Televisio();
                electrodomestics.add(tv2);
                Televisio tv3 = new Televisio();
                electrodomestics.add(tv3);

            } catch (preuBaseException e) {
                System.err.println(e);
                preuBase = demanarPreu();
            } catch (pesException e) {
                System.err.println(e);
                pes = demanarPes();
            } catch (carregaException e) {
                System.err.println(e);
                carrega = demanarCarrega();
            } catch (polzadesException e) {
                System.err.println(e);
                polzades = demanarPolzades();
            } catch (consumEnergeticException e) {
                System.err.println(e);
                consumEnergetic = demanarConsumEnergetic();
            } catch (colorException e) {
                System.err.println(e);
                color = demanarColor();
            } catch (resolucio4KException e) {
                System.err.println(e);
            } catch (Exception e) {
                System.err.println(e);
            }

            ElectrodomesticCorrecte = true;

        }

        //Se hace instance of de rentadora y tv para sumar sus precios separados
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic elec = electrodomestics.get(i);

            if (elec instanceof Rentadora) {
                rentadoraP += elec.preuFinal();
            }

            if (elec instanceof Televisio) {
                televisioP += elec.preuFinal();
            }

            preuFinal += elec.preuFinal();
        }

        System.out.println("El preu final de les rentadores és: " + rentadoraP);
        System.out.println("El preu final de les televisions és: " + televisioP);
        System.out.println("El preu final de tots els electrodomestics és: "
                + preuFinal);

    }

    public static boolean LlistaP(ArrayList llista) {
        
        final int LIMIT_LLISTA = 10;
        
        if (llista.size() >= LIMIT_LLISTA) {
                return false;
            }
        
        return true;
        
    }
    
    public static int demanarPreu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el preu base de l'electrodomèstic: ");
        int preu = sc.nextInt();
        return preu;
    }

    public static int demanarPes() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el pes de l'electrodomèstic: ");
        int pes = sc.nextInt();
        return pes;
    }

    public static int demanarCarrega() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix la càrrega de l'electrodomèstic: ");
        int carrega = sc.nextInt();
        return carrega;
    }

    public static int demanarPolzades() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix les polzades de l'electrodomèstic: ");
        int polzades = sc.nextInt();
        return polzades;
    }

    public static char demanarConsumEnergetic() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introdueix el pes de l'electrodomèstic:"
                + "\n(Consum energètic entre la A-F)"
                + "\nResposta: ");
        char energia = sc.nextLine().charAt(0);
        return energia;
    }

    public static String demanarColor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el pes de l'electrodomèstic:"
                + "\n\t- Blanc"
                + "\n\t- Negre"
                + "\n\t- Vermell"
                + "\n\t- Blau"
                + "\n\t- Gris"
                + "\nResposta: ");
        String color = sc.nextLine();
        return color;
    }

    public static boolean demanarResolucio4K() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Les televisions compten amb resolució 4K:"
                + "\nEscriu 1 si és cert o 0 si és fals: ");
        boolean resolucio4k = sc.nextBoolean();
        return resolucio4k;
    }

}
