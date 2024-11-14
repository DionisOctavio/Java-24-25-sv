import java.util.Scanner;

public class ConjugadorDeVerbos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pronombres = {"yo", "tú", "él/ella/usted", "nosotros/nosotras", "vosotros/vosotras", "ellos/ellas/ustedes"};

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.endsWith(" T")) break;

            String[] parts = input.split(" ");
            String verbo = parts[0];
            char tiempo = parts[1].charAt(0);
            String terminacion = verbo.substring(verbo.length() - 2);
            String raiz = verbo.substring(0, verbo.length() - 2);

            String[] conjugaciones;

            switch (tiempo) {
                case 'A':
                    conjugaciones = presente(terminacion, raiz);
                    break;
                case 'P':
                    conjugaciones = preteritoPerfectoSimple(terminacion, raiz);
                    break;
                case 'F':
                    conjugaciones = futuro(terminacion, raiz);
                    break;
                default:
                    throw new IllegalArgumentException("Tiempo verbal no válido");
            }

            for (int i = 0; i < pronombres.length; i++) {
                System.out.println(pronombres[i] + " " + conjugaciones[i]);
            }
            System.out.println();
        }
        scanner.close();
    }

    private static String[] presente(String terminacion, String raiz) {
        if (terminacion.equals("ar")) {
            return new String[]{raiz + "o", raiz + "as", raiz + "a", raiz + "amos", raiz + "áis", raiz + "an"};
        } else if (terminacion.equals("er")) {
            return new String[]{raiz + "o", raiz + "es", raiz + "e", raiz + "emos", raiz + "éis", raiz + "en"};
        } else if (terminacion.equals("ir")) {
            return new String[]{raiz + "o", raiz + "es", raiz + "e", raiz + "imos", raiz + "ís", raiz + "en"};
        }
        return new String[0];
    }

    private static String[] preteritoPerfectoSimple(String terminacion, String raiz) {
        if (terminacion.equals("ar")) {
            return new String[]{raiz + "é", raiz + "aste", raiz + "ó", raiz + "amos", raiz + "asteis", raiz + "aron"};
        } else if (terminacion.equals("er") || terminacion.equals("ir")) {
            return new String[]{raiz + "í", raiz + "iste", raiz + "ió", raiz + "imos", raiz + "isteis", raiz + "ieron"};
        }
        return new String[0];
    }

    private static String[] futuro(String terminacion, String raiz) {
        return new String[]{raiz + "é", raiz + "ás", raiz + "á", raiz + "emos", raiz + "éis", raiz + "án"};
    }
}
