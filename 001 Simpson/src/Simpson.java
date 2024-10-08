
public class Simpson {
    // VISIBLE A NIVEL DE LA CLASE SIMPSON
    static char[][] tablero = new char[10][10]; //  (0 a N-1)
    // FIN

    // Software de gestión de venta ONLINE
    public static void rellenarTablero(char pers){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                tablero[i][j] = pers;
            }
        }
    }
    
    public static void imprimirTablero(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                System.out.printf(tablero [i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        System.out.println();

        char personaje = 'H';
        rellenarTablero(personaje);

        imprimirTablero();
                                       
        System.out.println();

        personaje = '#';
        rellenarTablero(personaje);

        imprimirTablero();

    }
}