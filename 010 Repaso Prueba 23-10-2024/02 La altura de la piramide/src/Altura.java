import java.util.Scanner;

public class Altura {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        // genero un bucle que hasta que no sea 0 no se va a romper
        while(true){
            System.out.println("Ingrese el num de bloques: ");
            int numBloques = teclado.nextInt(); // el usuario añade el numero de bloques a calcular
            int aux = numBloques;

            if (numBloques == 0) break; // si es cero fin del bucle

            int pisos = 0; // Aqui guardaremos los pisos que se han echo con el numero de bloques dados
            int lado = 1; // tamaño del lado inicial

            while (numBloques > 0) { // mientras sea mayor a 0 seguimos haciendo el calculo
                int bloquesUsados = lado*lado; // a bloqueas usados le damos el valor del numero de bloques. EJ: 5*5=25

                if (numBloques > bloquesUsados) { // si los bloques son mayores al numero de bloques que se han usado hasta ahora seguimos
                    numBloques -= bloquesUsados;
                }else { // si los bloques son menores a los bloques usados nos se puede seguir construyendo y fin del bucle
                    numBloques = 0;
                }

                pisos++; // sumamos 1 al piso
                lado += 2; // le sumamos 2 a lado para el siguiente piso
            }
            System.out.println(pisos + " Pisos se han completado con " + aux + " bloques");
        }

    }
}