import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] simbolos = {'T', 'G', 'C', 'F', 'D', 'R', 'H'};
        int[] potencias = {1, 10, 100, 1000, 10000, 100000, 1000000};
        while (true) {
            int numero = sc.nextInt();
            if (numero == 0) break;
            String resultado = "";
            int tamanyo = String.valueOf(numero).length(); // LONGITUD
            for (int i = (tamanyo-1); i >= 0; i--) {
                int digito = numero / potencias[i];
                numero %= potencias[i];
                for (int j = 0; j < digito; j++) {
                    resultado = resultado + simbolos[i];
                }
            }
            System.out.println(resultado);
        }
        sc.close();
    }
}