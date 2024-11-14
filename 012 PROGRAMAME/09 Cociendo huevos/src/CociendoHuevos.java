import java.util.Scanner;

public class CociendoHuevos {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        while (true) {
            System.out.println("Introduzca Numero de Huevos: ");
            int h = leer.nextInt();
            System.out.println("Introduzca Capacidad de la olla: ");
            int c = leer.nextInt();

            if (h == 0 && c == 0) break;

            int tandas = (h + c - 1) / c; // Cálculo del número de tandas
            int tiempoTotal = tandas * 10; // Tiempo total en minutos

            System.out.println("Tiempo total: " + tiempoTotal);
        }
    }
}
