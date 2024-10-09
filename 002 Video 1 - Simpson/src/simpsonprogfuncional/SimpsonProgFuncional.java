   package simpsonprogfuncional;

   import java.util.Random;

   public class SimpsonProgFuncional {

        private static final int MAX_FILA_TABLERO = 10;
        private static final int MAX_COLUMNA_TABLERO = 10;
        private static char [][] tablero;

        public static void main(String[] args) {
            //1º inicio matriz tablero
            tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

            //2º rellenar tablero
            for (int i = 0; i <MAX_FILA_TABLERO; i++) {
                for (int j = 0; j <MAX_COLUMNA_TABLERO; j++) {
                    tablero[i][j] = 'L';
                }
            }
            //3º imprimir tablero
            for (int i = 0; i <MAX_FILA_TABLERO; i++) {
                for (int j = 0; j <MAX_COLUMNA_TABLERO; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println(" ");
            }

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

            //4º asignar bart
            Random aleatorio = new Random();
            int filaleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
            int columnaaleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);

            tablero[filaleatorio][columnaaleatorio] = 'B';

            //5º imprimir tablero
            for (int i = 0; i <MAX_FILA_TABLERO; i++) {
                for (int j = 0; j <MAX_COLUMNA_TABLERO; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println(" ");
            }


            //6º repartir 10 homers dentro del tablero

        }
    }