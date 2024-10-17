// Octavio Alvarez

import java.util.Random;
import java.util.Scanner;

public class Simpson {

    private static final int FILA = 10;
    private static final int COLUMNA = 10;
    private static char [][] tablero;
    private static int filaBart;
    private static int columnBart;


    private static void imprimirTablero(){
        for (int i = 0; i < FILA; i++){
            for (int j = 0; j < COLUMNA; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

        private static void asignarLetraACasilla(char letra){
            for (int i = 0; i < FILA; i++){
                for (int j = 0; j < COLUMNA; j++){
                    tablero[i][j] = letra;
                }
            }
        }

        private static void asignarPersonajeACasillaLibre(char personaje, int Num){
            Random aleatorio = new Random();
            int filaaleatorio = 0;
            int columnaleatorio = 0;
            for (int i = 0; i < Num; i++){
                do {
                    filaaleatorio = aleatorio.nextInt(FILA);
                    columnaleatorio = aleatorio.nextInt(COLUMNA);
                } while (tablero[filaaleatorio][columnaleatorio] != 'L');
                tablero[filaaleatorio][columnaleatorio] = personaje;
            }
            if (personaje == 'B'){
                filaBart = filaaleatorio;
                columnBart = columnaleatorio;
            }
        }
    // Octavio Alvarez
    public static void main(String[] args) {

        tablero = new char[COLUMNA][FILA];

        asignarLetraACasilla('L');
        asignarPersonajeACasillaLibre('B', 1);
        asignarPersonajeACasillaLibre('H', 10);
        asignarPersonajeACasillaLibre('M', 10);

        imprimirTablero();

        Scanner tecla = new Scanner(System.in);
        int vida = 3;
            do {

                System.out.print("Usa WASD para menearte por el tablero: ");
                String movimiento = tecla.nextLine();

                switch (movimiento) {
                    case "W":
                        if ((filaBart -1) >=0){
                            filaBart = filaBart -1;
                            switch (tablero[filaBart][columnBart]) {
                                case 'H':
                                    vida = vida -1;
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart +1][columnBart] = 'L';
                                    System.out.println("Has perdido 1 Vida te quedan " + vida + " Vidas");
                                    break;
                                case 'L':
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart +1][columnBart] = 'L';
                                    break;
                                case 'M':
                                    System.out.println("El muro no te deja desplazarte a esta casilla");
                                    filaBart = filaBart +1;
                                    break;
                            }
                        }else {
                            System.out.println("Desplazamiento prohibido. Limite de Tablero");
                        }
                        break;
                    case "A":
                        if ((columnBart -1) >=0){
                            columnBart = columnBart -1;
                            switch (tablero[filaBart][columnBart]) {
                                case 'H':
                                    vida = vida -1;
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart][columnBart +1] = 'L';
                                    System.out.println("Has perdido 1 Vida te quedan " + vida + " Vidas");
                                    break;
                                case 'L':
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart][columnBart +1] = 'L';
                                    break;
                                case 'M':
                                    System.out.println("El muro no te deja desplazarte a esta casilla");
                                    columnBart = columnBart +1;
                                    break;
                            }
                        }else {
                            System.out.println("Desplazamiento prohibido. Limite de Tablero");
                        }
                        break;
                    case "S":
                        if ((filaBart +1) >=0){
                            filaBart = filaBart +1;
                            switch (tablero[filaBart][columnBart]) {
                                case 'H':
                                    vida = vida -1;
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart -1][columnBart] = 'L';
                                    System.out.println("Has perdido 1 Vida te quedan " + vida + " Vidas");
                                    break;
                                case 'L':
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart -1][columnBart] = 'L';
                                    break;
                                case 'M':
                                    System.out.println("El muro no te deja desplazarte a esta casilla");
                                    filaBart = filaBart -1;
                                    break;
                            }
                        }else {
                            System.out.println("Desplazamiento prohibido. Limite de Tablero");
                        }
                        break;
                    case "D":
                        if ((columnBart +1) >=0){
                            columnBart = columnBart +1;
                            switch (tablero[filaBart][columnBart]) {
                                case 'H':
                                    vida = vida -1;
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart][columnBart -1] = 'L';
                                    System.out.println("Has perdido 1 Vida te quedan " + vida + " Vidas");
                                    break;
                                case 'L':
                                    tablero[filaBart][columnBart] = 'B';
                                    tablero[filaBart][columnBart -1] = 'L';
                                    break;
                                case 'M':
                                    System.out.println("El muro no te deja desplazarte a esta casilla");
                                    columnBart = columnBart -1;
                                    break;
                            }
                        }else {
                            System.out.println("Desplazamiento prohibido. Limite de Tablero");
                        }
                        break;
                    default:
                        break;
                }
                imprimirTablero();
            }while (vida > 0);

    }
}
// Finalizado