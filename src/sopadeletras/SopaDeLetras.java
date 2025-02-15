/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import java.util.Scanner;

/**
 *
 * @author Selvi
 */
public class SopaDeLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        while (!salir) {
            System.out.println("----------------------");
            System.out.println("1. Nueva partida");
            System.out.println("2. Historial de partidas");
            System.out.println("3. Puntuaciones");
            System.out.println("4. Informacion");
            System.out.println("5. Salir");
            System.out.println("----------------------");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    nuevaPartida();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Escoge una opcion correcta del 1 - 5");
            }
        }
    }

    public static void nuevaPartida() {

        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        while (!salir) {
            System.out.println("----------------------");
            System.out.println("1. Menu palabras");
            System.out.println("2. Jugar");
            System.out.println("3. Terminar Partida");
            System.out.println("----------------------");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuPalabras();
                    break;
                case 2:

                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Escoge una opcion correcta del 1 - 3");
            }
        }
    }

    public static void menuPalabras() {

        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        while (!salir) {
            System.out.println("----------------------");
            System.out.println("1. Ingresar palabras");
            System.out.println("2. Modificar palabras");
            System.out.println("3. Eliminar palabras");
            System.out.println("4. Regresar");
            System.out.println("----------------------");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Escoge una opcion correcta del 1 - 4");
            }
        }
    }

}
