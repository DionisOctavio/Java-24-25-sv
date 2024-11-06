import java.util.Scanner;
public class Barras {


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        while(true) {

            String codigoBarras = leer.nextLine();

            if (codigoBarras.equals("0")) break;

            int longitud = codigoBarras.length();

            boolean EAN8 = longitud <= 8;
            boolean EAN13= longitud > 8 && longitud >= 13;

            if (EAN8) {
                while (codigoBarras.length() < 8) {
                    codigoBarras = "0" + codigoBarras;
                }
            } else if (EAN13) {
                while (codigoBarras.length() < 13){
                    codigoBarras = "0" + codigoBarras;
                }
            }

            int sumaPares = 0;
            int sumaImpares = 0;
            int contador = 0;

            for (int i = codigoBarras.length() -2 ; i >= 0; i--) {
                int digito = Integer.parseInt(String.valueOf(codigoBarras.charAt(i)));
                contador++;
                if (contador % 2 == 0) {
                    sumaPares = sumaPares + (digito * 1);
                }else {
                    sumaImpares = sumaImpares + (digito * 3);
                }

            }

            int total = sumaPares+sumaImpares;
            int resto = total % 10;
            int numCalculado = (resto== 0)? 0 :(10 - resto);

            int numReal = Integer.parseInt(String.valueOf(codigoBarras.charAt(codigoBarras.length() - 1)));
            boolean validacion = (numCalculado == numReal);

            if (validacion) {
                System.out.println("SI");
            }else {
                System.out.println("NO");
                continue;
            }

            if (EAN13 && validacion) {
                int[] prefijos = {380, 50, 560, 70, 590, 850, 890};
                String[] paises = {"Bulgaria", "Inglaterra", "Portugal", "Noruega", "Polonia", "Cuba", "India"};

                String pais = "Desconocido";
                int prefijo =  0;

                for (int i = 0; i < paises.length; i++) {
                    prefijo = Integer.parseInt(codigoBarras.substring(0,String.valueOf(prefijos[i]).length()));
                    if (prefijo == prefijos[i]) {
                        pais = paises[i];
                    }
                }

                System.out.println(pais);

            }
            System.out.println();
        }

    }


}
