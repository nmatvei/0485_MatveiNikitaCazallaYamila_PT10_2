/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany._matveinikitacazallayamila_pt10_2;

// Importació d'excepcions personalitzades
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
 * Classe principal per gestionar els electrodomèstics.
 * @author Nikita i Yamila
 */
public class App {
    
    public static void main(String[] args) throws Exception {

        // Declaració de variables
        boolean resolucio4K, ElectrodomesticCorrecte = false, llistaPlena;
        int preuBase, pes, carrega, polzades, preuFinal = 0;
        int rentadoraP = 0, televisioP = 0;
        char consumEnergetic;
        String color;
        final int LIMIT_LLISTA = 10;

        // Crear una llista d'electrodomestics
        ArrayList<Electrodomestic> electrodomestics = new ArrayList<Electrodomestic>(LIMIT_LLISTA);

        // Demanar els valors de cada variable a l'usuari
        preuBase = demanarPreu();
        pes = demanarPes();
        carrega = demanarCarrega();
        polzades = demanarPolzades();
        consumEnergetic = demanarConsumEnergetic();
        color = demanarColor();
        resolucio4K = demanarResolucio4K();

        // While per afegir electrodomestics a la llista
        while (!ElectrodomesticCorrecte) {
            // try-catch per comprovar que no s'introdueixen valors erronis
            try {
                /**
                 * Es crean les instàncies de la classe Electrodomestic,
                 * Rentadora i Televisió
                 * Després d'haver-les creats s'afegeixen a la taula
                 */
                // Electrodomèstics
                // Instància de constructor genèric
                Electrodomestic elec1 = new Electrodomestic();
                electrodomestics.add(elec1);
                // Instància de constructor assignant-li valor a dos paràmetres
                Electrodomestic elec2 = new Electrodomestic(preuBase, pes);
                electrodomestics.add(elec2);
                // Instància de constructor assignant-li valor a tots els paràmetres
                Electrodomestic elec3 = new Electrodomestic(preuBase, pes, color,
                        consumEnergetic);
                electrodomestics.add(elec3);
                // Rentadores
                Rentadora r1 = new Rentadora();
                electrodomestics.add(r1);
                Rentadora r2 = new Rentadora(preuBase, pes);
                electrodomestics.add(r2);
                Rentadora r3 = new Rentadora(carrega, preuBase, pes, color,
                        consumEnergetic);
                electrodomestics.add(r3);
                // Televisions
                Televisio tv1 = new Televisio();
                electrodomestics.add(tv1);
                Televisio tv2 = new Televisio(preuBase, pes);
                electrodomestics.add(tv2);
                Televisio tv3 = new Televisio(polzades, resolucio4K, preuBase, pes, color,
                        consumEnergetic);
                electrodomestics.add(tv3);
                Televisio tv4 = new Televisio(preuBase, pes);
                electrodomestics.add(tv4);

            } catch (preuBaseException e) {
                //Catch que salta quan és negatiu el preuBase
                System.err.println(e);
                preuBase = demanarPreu();
            } catch (pesException e) {
                //Catch que salta quan és negatiu el pes
                System.err.println(e);
                pes = demanarPes();
            } catch (carregaException e) {
                //Catch que salta quan és negativa la càrrega
                System.err.println(e);
                carrega = demanarCarrega();
            } catch (polzadesException e) {
                //Catch que salta quan són negatives les polzades
                System.err.println(e);
                polzades = demanarPolzades();
            } catch (consumEnergeticException e) {
                //Catch que salta quan és erroni el consum energètic
                System.err.println(e);
                consumEnergetic = demanarConsumEnergetic();
            } catch (colorException e) {
                //Catch que salta quan és erroni el color
                System.err.println(e);
                color = demanarColor();
            } catch (resolucio4KException e) {
                //Catch que salta quan és errònia la resolució
                System.err.println(e);
            } catch (Exception e) {
                //Catch genèric
                System.err.println(e);
            }

            // Per sortir del bucle un cop estan totes de les dades correctament
            ElectrodomesticCorrecte = true;

        }

        //Calcular el preu final
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic elec = electrodomestics.get(i);

            //Fa un preu final apart de les rentadores
            if (elec instanceof Rentadora) {
                rentadoraP += elec.preuFinal();
            }

            //Fa un preu final apart de les televisions
            if (elec instanceof Televisio) {
                televisioP += elec.preuFinal();
            }

            preuFinal += elec.preuFinal();
        }

        // Imprimeix els preus finals de les rentadores, televisions i en general
        System.out.println("El preu final de les rentadores és: " + rentadoraP);
        System.out.println("El preu final de les televisions és: " + televisioP);
        System.out.println("El preu final de tots els electrodomestics és: "
                + preuFinal);

    }
    
    /**
     * Demana el preu base a l'usuari.
     * @return El preu base introduït
     */
    public static int demanarPreu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el preu base de l'electrodomèstic: ");
        int preu = sc.nextInt();
        return preu;
    }

    /**
     * Demana el pes a l'usuari.
     * @return 
     */
    public static int demanarPes() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el pes de l'electrodomèstic: ");
        int pes = sc.nextInt();
        return pes;
    }

    /**
     * Demana la càrrega a l'usuari.
     * @return La càrrega introduïda
     */
    public static int demanarCarrega() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix la càrrega de l'electrodomèstic: ");
        int carrega = sc.nextInt();
        return carrega;
    }

    /**
     * Demana les polzades a l'usuari.
     * @return Les polzades introduïdes
     */
    public static int demanarPolzades() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix les polzades de l'electrodomèstic: ");
        int polzades = sc.nextInt();
        return polzades;
    }

    /**
     * Demana el consum energètic a l'usuari.
     * @return La lletra del consum energètic introduïda
     */
    public static char demanarConsumEnergetic() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introdueix el pes de l'electrodomèstic:"
                + "\n(Consum energètic entre la A-F)"
                + "\nResposta: ");
        char energia = sc.nextLine().charAt(0);
        return energia;
    }

    /**
     * Demana el color de l'electrodomèstic a l'usuari.
     * @return El color introduït
     */
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

    /**
     * Demana si la televisió té resolució 4K.
     * @return true si té 4K, false en cas contrari
     */
    public static boolean demanarResolucio4K() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Les televisions compten amb resolució 4K:"
                + "\n\t- True"
                + "\n\t- False"
                + "\nResposta: ");
        boolean resolucio4k = sc.nextBoolean();
        return resolucio4k;
    }

}
