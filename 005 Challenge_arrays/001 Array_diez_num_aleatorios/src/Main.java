import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arrayNumAleatorio = new int[10]; //Declaro el Array
        Random aleatorio = new Random();    //Declaro aleatorio

        //for para rellenar las 10 posiciones de aleatorios y de 0 a 9
        for (int i = 0; i < arrayNumAleatorio.length; i++) {
            arrayNumAleatorio[i] = aleatorio.nextInt(10);
            System.out.print(arrayNumAleatorio[i] + " ");
            System.out.println();
        }
    }
}