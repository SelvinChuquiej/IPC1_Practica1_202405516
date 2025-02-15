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
    public static int tamañoTablero = 25;
    public static char[][] tablero = new char[tamañoTablero][tamañoTablero];

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
                    jugar();
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
                    eliminarPalabra();
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
        System.out.println("Ingrese palabras de 6 a 15 letras: ");
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

    //Metodo para modificar palabra dentro del arreglo palabras
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

    //Metodo para eliminar palabra dentro del arreglo palabras
    public static void eliminarPalabra() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la palabra a eliminar: ");
        String palabraEliminar = sc.nextLine().toUpperCase();
        //Busca el indice de la palabra a eliminar
        int indicePalabra = buscarPalabra(palabraEliminar);
        ////Valida si la palabra fue encontrada en el arreglo
        if (indicePalabra != -1) {
            //Recorre la lista deasde la posicion de la palabra a eliminar hasta el final del arreglo
            for (int i = indicePalabra; i < palabras.length - 1; i++) {
                //Despalza los elementos hacia la izquierda y sobreescribe la palabra 
                //con la siguiente elemento
                palabras[i] = palabras[i + 1];
            }
            //Se coloca null en la ultima posicion 
            palabras[palabras.length - 1] = null;
        }
    }

    public static void jugar() {

        Scanner sc = new Scanner(System.in);

        iniciarTablero();
        colocarPalabras();
        mostrarTablero();

    }

    //Metodo para incializar el tablero con espacios vacios
    public static void iniciarTablero() {
        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    //Metodo para colocar palabras en el tablero inicalizado
    public static void colocarPalabras() {
        //Recorre la cantidad de palabras
        for (int i = 0; i < cantidadPalabras; i++) {
            String palabra = palabras[i];

            //Valida si existe un null dentro del array lo ignora y continua
            if (palabra == null) {
                continue;
            }
            
            boolean colocada = false;
            while (!colocada) {

                //Genera una fila aleatorias segun el tamaño del tablero
                int fila = (int) (Math.random() * tamañoTablero);
                //Genera una columna aleatoria segun el tamaño del tablero
                int columna = (int) (Math.random() * tamañoTablero);
                //Variable con 50% horizontalmente true 
                boolean horizontal = Math.random() < 0.5;

                //Condicion para verificar que la palabra va horizontal 
                if (horizontal && columna + palabra.length() <= tamañoTablero) {
                    boolean puedeColocar = true;

                    //Ciclo para recorrer la palabra
                    for (int j = 0; j < palabra.length(); j++) {
                        //Validacion para ver si las posiciones que se usaran van a ser vacias
                        if (tablero[fila][columna + j] != ' ') {
                            puedeColocar = false;
                        }
                    }
                    if (puedeColocar) {
                        for (int j = 0; j < palabra.length(); j++) {
                            //Separa el string en char y lo coloca en el tablero
                            tablero[fila][columna + j] = palabra.charAt(j);
                        }
                        colocada = true;
                    }
                    colocada = true;

                    //Condicion para verificar que la palabra va vertical
                } else if (!horizontal && fila + palabra.length() <= tamañoTablero) {
                    boolean puedeColocar = true;

                    //Ciclo para recorrer la palabra
                    for (int j = 0; j < palabra.length(); j++) {
                        //Validacion para ver si las posiciones que se usaran van a ser vacias
                        if (tablero[fila + j][columna] != ' ') {
                            puedeColocar = false;
                        }
                    }
                    if (puedeColocar) {
                        for (int j = 0; j < palabra.length(); j++) {
                            //Separa el string en char y lo coloca en el tablero
                            tablero[fila + j][columna] = palabra.charAt(j);
                        }
                        colocada = true;
                    }
                }
            }
        }

        //Ciclo para recorrer todo el tablero filas y columnas
        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                //Condicion para buscar los espacios vacios
                if (tablero[i][j] == ' ') {
                    //Rellena los esapcion con letras aleatorias
                    tablero[i][j] = (char) ('a' + (int) (Math.random() * 26));
                }
            }
        }
    }

    //Metodo para imprimir el tablero 25x25
    public static void mostrarTablero() {
        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Metodo para buscar palabras dentro del arreglo palabras
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
