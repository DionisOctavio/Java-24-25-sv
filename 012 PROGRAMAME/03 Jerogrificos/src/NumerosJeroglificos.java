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
            if (numero > 100000 || numero < 0) {
                System.out.println("El numero es Invalido");
                break;
            }

            StringBuilder resultado = new StringBuilder();

            // Descomponer el número en cada potencia de 10
            for (int i = 0; i < valores.length; i++) {
                int cantidad = numero / valores[i]; // Cuántas veces cabe esta potencia en el número
                numero %= valores[i];               // Reducir el número al resto

                // Agregar el símbolo correspondiente la cantidad de veces necesaria
                for (int j = 0; j < cantidad; j++) {
                    resultado.append(simbolos[i]);
                }
            }

            // Imprimir el resultado para este número
            System.out.println(resultado.toString());
        }

        scanner.close();
    }
}
