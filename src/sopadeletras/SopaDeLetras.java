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
    public static int cantidadPalabras = 0;
    public static String[] palabras;

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
                    ingresarPalabras();
                    break;
                case 2:
                    modificarPalabras();
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

    //Metodo para ingresar palabras
    public static void ingresarPalabras() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero de palabras a ingresar: ");
        //Verifica que el dato que ingreso el usuario sea un numero
        while (!sc.hasNextInt()) {
            System.out.println("Porfavor ingresa un dijito");
            sc.nextLine();
        }

        cantidadPalabras = sc.nextInt();
        //Segun el dato ingresado sera el tamaño del arreglo
        palabras = new String[cantidadPalabras];
        sc.nextLine();
        //Ciclo para ingresar palabras segun el dato ingresado
        System.out.print("Ingrese palabras de 6 a 15 letras: ");
        for (int i = 0; i < cantidadPalabras; i++) {
            System.out.print((i + 1) + ") ");
            String palabraIngresada = sc.nextLine().toUpperCase();
            //Validacion para comprobar la longitud de la palabra
            if (palabraIngresada.length() >= 6 && palabraIngresada.length() <= 15) {
                palabras[i] = palabraIngresada;
            } else {
                System.out.println("La palabra ingresa no cumple con la longitud");
                i--;
            }
        }
    }

    public static void modificarPalabras() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la palabra a editar: ");
        String palabraEditar = sc.nextLine().toUpperCase();
        //Busca el indice de la palabra a editar
        int indicePalabra = buscarPalabra(palabraEditar);
        //Valida si la palabra fue encontrada en el arreglo
        if (indicePalabra != -1) {
            System.out.println("Ingrese la nueva palabra de 6 a 15 letras: ");
            String palabraNueva = sc.nextLine().toUpperCase();
            //Validacion para comprobar la longitud de la palabra
            if (palabraNueva.length() >= 6 && palabraNueva.length() <= 15) {
                //Busca la palabra vieja y la remplaza por la nueva 
                palabras[indicePalabra] = palabraNueva;
                System.out.println("Palabra modificada correctamente");
            } else {
                System.out.println("La palabra ingresa no cumple con la longitud");
            }
        } else {
            System.out.println("Palabra no encontrada");
        }
    }

    public static int buscarPalabra(String palabra) {
        for (int i = 0; i < cantidadPalabras; i++) {
            //Valida si la palabra existe dentro del arreglo palabras
            if (palabras[i].equals(palabra)) {
                //Retorna el indice de la palabra encontrada
                return i;
            }
        }
        //Retorna falso si la palabra no se encuentra
        return -1;
    }
}
