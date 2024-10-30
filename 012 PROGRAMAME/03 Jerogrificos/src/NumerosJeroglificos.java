import java.util.Scanner;

public class NumerosJeroglificos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mapear las potencias de 10 con sus símbolos correspondientes
        char[] simbolos = {'H', 'R', 'D', 'F', 'C', 'G', 'T'}; // De 1,000,000 a 1
        int[] valores = {1000000, 100000, 10000, 1000, 100, 10, 1};

        while (true) {
            // Leer el número de entrada
            System.out.print("Dame un numero para convertir a jerogrifico: ");
            int numero = scanner.nextInt();

            // Si el número es 0, terminar el programa
            if (numero == 0) break;
            if (numero > 1000000 || numero < 0) {
                System.out.println("El numero es Invalido");
                break;
            }

            String resultado = "";  // Usamos una cadena en lugar de StringBuilder

            // Descomponer el número en cada potencia de 10 usando switch
            for (int i = 0; i < valores.length; i++) {
                int cantidad = numero / valores[i]; // coge el nnmero que le damos y lo divide en tre el numero que le coresponda del array valores
                numero %= valores[i]; // esto calcula el resto despues de dividirlo en este caso si el numero es 120 y le aplicamos los primeroa 100 el resto seria 20 para la siguiente pasada

                switch (i) {
                    case 0: // 1,000,000
                        for (int j = 0; j < cantidad; j++) resultado += 'H';
                        break;
                    case 1: // 100,000
                        for (int j = 0; j < cantidad; j++) resultado += 'R';
                        break;
                    case 2: // 10,000
                        for (int j = 0; j < cantidad; j++) resultado += 'D';
                        break;
                    case 3: // 1,000
                        for (int j = 0; j < cantidad; j++) resultado += 'F'; //esto asigna las veces que tiene que poner el numero tras la division de arriba
                        break;
                    case 4: // 100
                        for (int j = 0; j < cantidad; j++) resultado += 'C';
                        break;
                    case 5: // 10
                        for (int j = 0; j < cantidad; j++) resultado += 'G';
                        break;
                    case 6: // 1
                        for (int j = 0; j < cantidad; j++) resultado += 'T';
                        break;
                }
            }

            // Imprimir el resultado para este número
            System.out.println(resultado);
        }

        scanner.close();
    }
}
