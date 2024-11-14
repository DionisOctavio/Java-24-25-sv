import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelefonoDeMeucci {

    private static final Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().trim();
            if (linea.isEmpty()) continue;

            int combinaciones = contarCombinaciones(linea);
            System.out.println(combinaciones);
        }
    }

    private static int contarCombinaciones(String cadena) {
        if (cadena.isEmpty()) return 1;
        if (memo.containsKey(cadena)) return memo.get(cadena);

        int total = 0;
        for (int i = 1; i <= 4 && i <= cadena.length(); i++) {
            String prefijo = cadena.substring(0, i);
            if (esDigitoValido(prefijo)) {
                total += contarCombinaciones(cadena.substring(i));
            }
        }

        memo.put(cadena, total);
        return total;
    }

    private static boolean esDigitoValido(String s) {
        switch (s) {
            case "X":   // 0
            case "I":   // 1
            case "II":  // 2
            case "III": // 3
            case "IV":  // 4
            case "V":   // 5
            case "VI":  // 6
            case "VII": // 7
            case "VIII":// 8
            case "IX":  // 9
                return true;
            default:
                return false;
        }
    }
}
