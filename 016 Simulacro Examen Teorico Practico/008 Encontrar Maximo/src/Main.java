public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 2, 8, 7, 10, 6};

        int maximo = numeros[0];

        // Bucle optimizado: Encuentra y muestra el máximo en una sola pasada
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }

        System.out.println("El número máximo en el array es: " + maximo);
    }
}

