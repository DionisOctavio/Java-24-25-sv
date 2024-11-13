public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 2, 8, 7, 10, 6};

        // Ordenar el array de mayor a menor usando ordenación por selección
        for (int i = 0; i < numeros.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] > numeros[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Intercambiar el elemento actual con el mayor encontrado
            int temp = numeros[i];
            numeros[i] = numeros[maxIndex];
            numeros[maxIndex] = temp;
        }

        // Imprimir el array ordenado
        System.out.print("Array ordenado de mayor a menor: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}

