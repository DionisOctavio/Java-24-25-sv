import java.util.Scanner;

public class Piramides {

    // Declaro el Scanner para poder ingresar datos por teclado
    private static Scanner teclado = new Scanner(System.in);


    public static void main(String[] args) {

        // Defino el mensaje inicial y el numero de Casos de Prueba va a tener el usuario
        System.out.print("Ingrese el numero de intentos que vas a hacer: ");
        int Pruebas = teclado.nextInt();
        System.out.println("Tienes: " + Pruebas + " Intentos");

        // Genero un bucle que recorra y pida A, B y C el numero de veces que el usuario ha declarado en Pruebas
        for (int i = 0; i < Pruebas; i++) {

            // El usuario Ingresa A, B y C
            System.out.print("Ingrese A: ");
            int A = teclado.nextInt();
            System.out.print("Ingrese B: ");
            int B = teclado.nextInt();
            System.out.print("Ingrese C: ");
            int C = teclado.nextInt();

            /* Hago el calculo de la distancia entre A y B como el numero no puede ser negativo
            Lo elevamos al cuadrado por que el cuadrado de un numero no puede dar negativo */
            int distanciaA = (A-B)*(A-B);
            int distanciaC = (B-C)*(B-C);


            if (distanciaA < distanciaC) { // si la distancia de A es mayor a la de C es que A esta mas cerca de C
                System.out.println(A + " esta mas cerca de " + B );
            } else if (distanciaC < distanciaA) { // si la distancia de C es mayor a la de A es que C esta mas cerca de A
                System.out.println(C + " esta mas cerca de " + B );
            }else {
                System.out.println("EMPATE ambos estan a la misma distancia");
            }
        }
    }
}