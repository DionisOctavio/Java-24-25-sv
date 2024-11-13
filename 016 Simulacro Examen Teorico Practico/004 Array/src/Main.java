import java.util.Arrays;

public class Main {
    public static int[] array = new int[10];
    public static void RellenarAscendente(){
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println("Array en orden ascendente: " + Arrays.toString(array));
    }
    public static void RellenarInverso(){
        System.out.print("Array en orden inverso: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
    public static void RellenarPares(){
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
        System.out.println("Array con números pares: " + Arrays.toString(array));

    }
    public static void Mostrar2en2(){
        System.out.print("Elementos de dos en dos: ");
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + ", " + (i + 1 < array.length ? array[i + 1] : " ") + "] ");
        }
        System.out.println();
    }
    public static void RellenarImpares(){
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }
        System.out.println("Array con números impares: " + Arrays.toString(array));

    }
    public static void Duplicar(){
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        System.out.println("Array con cada elemento duplicado: " + Arrays.toString(array));

    }
    public static void SumaElementos(){
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        System.out.println("Suma de todos los elementos: " + suma);

    }
    public static void MaximoMinimo(){
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }
    public static void main(String[] args) {
        RellenarAscendente();
        RellenarInverso();
        RellenarPares();
        Mostrar2en2();
        RellenarImpares();
        Duplicar();
        SumaElementos();
        MaximoMinimo();
    }
}