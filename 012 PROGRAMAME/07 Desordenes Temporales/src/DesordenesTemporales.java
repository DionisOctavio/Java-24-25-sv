import java.util.Scanner;

public class DesordenesTemporales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            int[] edadesReales = new int[n];
            for (int i = 0; i < n; i++) {
                edadesReales[i] = scanner.nextInt();
            }

            long desordenTotal = contarInversiones(edadesReales);
            System.out.println(desordenTotal);
        }
    }

    private static long contarInversiones(int[] arr) {
        if (arr.length < 2) return 0;
        return mergeSortYCuenta(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static long mergeSortYCuenta(int[] arr, int[] temp, int izquierda, int derecha) {
        if (izquierda >= derecha) return 0;

        int medio = (izquierda + derecha) / 2;
        long inversiones = 0;

        inversiones += mergeSortYCuenta(arr, temp, izquierda, medio);
        inversiones += mergeSortYCuenta(arr, temp, medio + 1, derecha);
        inversiones += mergeYCuenta(arr, temp, izquierda, medio, derecha);

        return inversiones;
    }

    private static long mergeYCuenta(int[] arr, int[] temp, int izquierda, int medio, int derecha) {
        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;
        long inversiones = 0;

        while (i <= medio && j <= derecha) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversiones += (medio + 1 - i);
            }
        }

        while (i <= medio) {
            temp[k++] = arr[i++];
        }

        while (j <= derecha) {
            temp[k++] = arr[j++];
        }

        for (i = izquierda; i <= derecha; i++) {
            arr[i] = temp[i];
        }

        return inversiones;
    }
}
