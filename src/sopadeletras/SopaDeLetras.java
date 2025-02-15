/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import java.util.Arrays;
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
    public static String[] usuarios = new String[0];
    public static int[] puntuaciones = new int[0];
    public static int puntosIniciales = 25;
    public static int[] fallos = new int[0];
    public static int[] noPalabrasEncontradas = new int[0];

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

            while (!sc.hasNextInt()) {
                System.out.println("Porfavor ingresa un dijito");
                sc.nextLine();
            }

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    nuevaPartida();
                    break;
                case 2:
                    historialPartidas();
                    break;
                case 3:
                    puntuacionAlta();
                    break;
                case 4:
                    System.out.println("Selvin Raúl Chuquiej Andrade - 202405516 -IPC1D");
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

        palabras = new String[0];
        cantidadPalabras = 0;

        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();
        palabras = Arrays.copyOf(palabras, palabras.length);

        //Crea una copia del arreglo pero con un tamaño incrementado en 1
        usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
        //Asigna el nombre del nuevo usuario a la ultima posicion
        usuarios[usuarios.length - 1] = nombre;

        //Crea una copia del arreglo pero con un tamaño incrementado en 1
        puntuaciones = Arrays.copyOf(puntuaciones, puntuaciones.length + 1);
        //Asigna los puntos iniciales en la ultima posicion
        puntuaciones[puntuaciones.length - 1] = puntosIniciales;

        //Crea una copia del arreglo pero con un tamaño incrementado en 1
        fallos = Arrays.copyOf(fallos, fallos.length + 1);
        //Asigna los fallos iniciales en la ultima posicion
        fallos[fallos.length - 1] = 0;

        //Crea una copia del arreglo pero con un tamaño incrementado en 1
        noPalabrasEncontradas = Arrays.copyOf(noPalabrasEncontradas, noPalabrasEncontradas.length + 1);
        //Asigna el numero de palabras encontradas iniciales en la ultima posicion
        noPalabrasEncontradas[noPalabrasEncontradas.length - 1] = 0;

        while (!salir) {
            System.out.println("----------------------");
            System.out.println("1. Menu palabras");
            System.out.println("2. Jugar");
            System.out.println("3. Terminar Partida");
            System.out.println("----------------------");

            while (!sc.hasNextInt()) {
                System.out.println("Porfavor ingresa un dijito");
                sc.nextLine();
            }

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
            System.out.println("4. Mostrar palabras");
            System.out.println("5. Regresar");
            System.out.println("----------------------");

            while (!sc.hasNextInt()) {
                System.out.println("Porfavor ingresa un dijito");
                sc.nextLine();
            }

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
                    mostrarPalabras();
                    break;
                case 5:
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

            int indicePalabra = buscarPalabra(palabraIngresada);
            if (indicePalabra != -1) {
                System.out.println("Esa palabra ya la has ingresado");
                i--;
            } //Validacion para comprobar la longitud de la palabra
            else if (palabraIngresada.length() >= 6 && palabraIngresada.length() <= 15) {
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

        if (cantidadPalabras == 0) {
            System.out.println("Aun no se han agregado palabras");
        } else {
            System.out.print("Ingresa la palabra a editar: ");
            String palabraEditar = sc.nextLine().toUpperCase();
            //Busca el indice de la palabra a editar
            int indicePalabra = buscarPalabra(palabraEditar);
            //Valida si la palabra fue encontrada en el arreglo
            if (indicePalabra != -1) {
                System.out.println("Ingrese la nueva palabra de 6 a 15 letras: ");
                String palabraNueva = sc.nextLine().toUpperCase();

                if (buscarPalabra(palabraNueva) != -1) {
                    System.out.println("Palabra ya existe ingresa nuevamente");
                    //Validacion para comprobar la longitud de la palabra
                } else if (palabraNueva.length() >= 6 && palabraNueva.length() <= 15) {
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
    }

    //Metodo para eliminar palabra dentro del arreglo palabras
    public static void eliminarPalabra() {

        Scanner sc = new Scanner(System.in);

        if (cantidadPalabras == 0) {
            System.out.println("Aun no se han agregado palabras");
        } else {
            System.out.print("Ingresa la palabra a eliminar: ");
            String palabraEliminar = sc.nextLine().toUpperCase();
            //Busca el indice de la palabra a eliminar
            int indicePalabra = buscarPalabra(palabraEliminar);
            //Valida si la palabra fue encontrada en el arreglo
            if (indicePalabra != -1) {
                //Recorre la lista deasde la posicion de la palabra a eliminar hasta el final del arreglo
                for (int i = indicePalabra; i < palabras.length - 1; i++) {
                    //Despalza los elementos hacia la izquierda y sobreescribe la palabra 
                    //con la siguiente elemento
                    palabras[i] = palabras[i + 1];
                }
                //Se coloca null en la ultima posicion 
                palabras[palabras.length - 1] = null;
                System.out.println("Palabra eliminada correctamente");
            } else {
                System.out.println("Esa palabra no existe");
            }
        }
    }

    //Metodo para mostrar las palabras que se van guardando
    public static void mostrarPalabras() {

        System.out.println("Palabras guardadas: ");
        for (int i = 0; i < cantidadPalabras; i++) {
            if (palabras[i] != null) {
                System.out.println((i + 1) + ") " + palabras[i]);
            }
        }
    }

    public static void jugar() {

        Scanner sc = new Scanner(System.in);

        int palabrasEncontradas = 0;
        int intentos = 4;
        int partidaActual = puntuaciones.length - 1;

        if (cantidadPalabras == 0) {
            System.out.println("Aun no se han agregado palabras");
        } else {
            iniciarTablero();
            colocarPalabras();
            mostrarTablero();
        }

        //Mientra intentos no sea 0 y las palabras encontradas no sea igual a 
        //la cantidad de palabras no se terminara el juego
        while (intentos != 0 && palabrasEncontradas < cantidadPalabras) {
            System.out.print("Palabra: ");
            String palabraUsuario = sc.nextLine().toUpperCase();
            int indicePalabra = buscarPalabra(palabraUsuario);

            if (indicePalabra != -1) {
                String palabra = palabras[indicePalabra];
                int tamañoPalabra = palabra.length();

                puntuaciones[partidaActual] += tamañoPalabra;
                noPalabrasEncontradas[partidaActual]++;

                marcarPalabra(palabraUsuario);
                palabrasEncontradas++;

                System.out.println("Palabras identificadas: " + palabrasEncontradas);
                System.out.println("Palabras pendientes: " + (cantidadPalabras - palabrasEncontradas));
                System.out.println("Puntos: " + puntuaciones[partidaActual]);
            } else {
                puntuaciones[partidaActual] -= 5;
                fallos[partidaActual]++;
                intentos--;
                System.out.println("Fallos: " + fallos[partidaActual]);
                System.out.println("Puntos: " + puntuaciones[partidaActual]);
            }
            mostrarTablero();
        }

        if (intentos == 0) {
            System.out.println("Que lo siento has perdido");
        }
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

    //Metodo para remplazar las palabras encontradas con #
    public static void marcarPalabra(String palabra) {
        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                //Verifica si la primera letra de la palabra esta en alguna posicion "i" o "j"
                if (tablero[i][j] == palabra.charAt(0)) {
                    boolean encontrada = true;
                    //Recorre la palabra empezando de la segunda letra
                    for (int k = 1; k < palabra.length(); k++) {
                        //Verifica si la letra no coincide o sale de los limites del tablero
                        if (j + k >= tamañoTablero || tablero[i][j + k] != palabra.charAt(k)) {
                            encontrada = false;
                            break;
                        }
                    }
                    //Si la palabra se encuentra completa en la fila
                    if (encontrada) {
                        //Remplaza la palabra por #
                        for (int k = 0; k < palabra.length(); k++) {
                            tablero[i][j + k] = '#';
                        }
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                //Verifica si la primera letra de la palabra esta en alguna posicion "i" o "j"
                if (tablero[i][j] == palabra.charAt(0)) {
                    boolean encontrada = true;
                    //Recorre la palabra empezando de la segunda letra
                    for (int k = 1; k < palabra.length(); k++) {
                        //Verifica si la letra no coincide o sale de los limites del tablero
                        if (i + k >= tamañoTablero || tablero[i + k][j] != palabra.charAt(k)) {
                            encontrada = false;
                            break;
                        }
                    }
                    //Si la palabra se encuentra completa en la columna
                    if (encontrada) {
                        //Remplaza la palabra por #
                        for (int k = 0; k < palabra.length(); k++) {
                            tablero[i + k][j] = '#';
                        }
                        return;
                    }
                }
            }
        }
    }

    //Metodo para buscar palabras dentro del arreglo palabras
    public static int buscarPalabra(String palabra) {
        for (int i = 0; i < cantidadPalabras; i++) {
            //Valida si la palabra existe dentro del arreglo palabras
            if (palabras[i] != null && palabras[i].equalsIgnoreCase(palabra)) {
                //Retorna el indice de la palabra encontrada
                return i;
            }
        }
        //Retorna falso si la palabra no se encuentra
        return -1;
    }

    public static void historialPartidas() {
        //Valida si se ha empezado una nueva partida
        if (usuarios.length == 0) {
            System.out.println("Aun no se han registrado partidas.");
        } else {
            System.out.println("| Usuarios | Puntuaciones | Fallos | Palabras Encontradas |");
            for (int i = 0; i < usuarios.length; i++) {
                System.out.println("| " + usuarios[i] + " | " + puntuaciones[i] + " | " + fallos[i] + " | " + noPalabrasEncontradas[i] + " |");
            }
        }
    }

    public static void puntuacionAlta() {
        //Areglos nuevo para almacenar los usuarios y los puntos ya ordenandos
        String[] usuariosOrdenados = Arrays.copyOf(usuarios, usuarios.length);
        int[] puntuacionesOrdenadas = Arrays.copyOf(puntuaciones, puntuaciones.length);

        //Valida para ver si aun no se han jugado nuevas partidas
        if (usuariosOrdenados.length == 0 && puntuacionesOrdenadas.length == 0) {
            System.out.println("Aun no se han registrado partidas.");
        } else {
            // Ciclo para recorrer hasta el penultimo elemento
            for (int i = 0; i < puntuacionesOrdenadas.length - 1; i++) {
                int indiceMaximo = i;
                //Ciclo que recorre en una posicion incial + 1
                for (int j = i + 1; j < puntuacionesOrdenadas.length; j++) {
                    //Valida si la posición j es mayor que el valor máximo actual
                    if (puntuacionesOrdenadas[j] > puntuacionesOrdenadas[indiceMaximo]) {
                        //Actualiza el indiceMaximo con el índice j.
                        indiceMaximo = j;
                    }
                }
                //Guarda el valor maximo
                int tempPuntuacion = puntuacionesOrdenadas[i];
                //Asigna el valor maximo encontrado a la posicion actual
                puntuacionesOrdenadas[i] = puntuacionesOrdenadas[indiceMaximo];
                //Asigna en la posicion actual el maximo
                puntuacionesOrdenadas[indiceMaximo] = tempPuntuacion;

                //Guarda el usuario con valor maximo
                String tempUsuario = usuariosOrdenados[i];
                //Asigna el usuario con valor maximo encontrado a la posicion actual
                usuariosOrdenados[i] = usuariosOrdenados[indiceMaximo];
                //Asigna el usuario en la posicion actual el maximo
                usuariosOrdenados[indiceMaximo] = tempUsuario;
            }

            System.out.println("| Posicion | Usuario | Puntuacion |");
            //Permite solo mostrar maximo 3 jugadores
            int limite = Math.min(3, usuariosOrdenados.length);
            for (int i = 0; i < limite; i++) {
                System.out.println((i + 1) + ") " + usuariosOrdenados[i] + " " + puntuacionesOrdenadas[i]);
            }
        }
    }
}
