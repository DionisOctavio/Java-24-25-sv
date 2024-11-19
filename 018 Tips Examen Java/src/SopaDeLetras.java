import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;

public class SopaDeLetras {
    static String palabras[] ={
            "helada",
            "mesa",
            "patata"
    };
    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static char sopaLetras[][] = new char[10][10];
    static char sopaLetrasCopia[][] = new char[10][10];
    static Random ale = new Random();
    static void rellenarMatriz(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int numAle = ale.nextInt(26);
                sopaLetras[i][j] = letras[numAle];
            }
        }
    }
    static void rellenarMatrizCopia(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sopaLetrasCopia[i][j] = '0';
            }
        }
    }
    public static void imprimirMatriz(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetras[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void imprimirMatrizCopia(){
        // IMPRIMIR MATRIZ COPIA
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetrasCopia[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        rellenarMatriz();
        rellenarMatrizCopia();
        imprimirMatriz();
        System.out.println();
        imprimirMatrizCopia();

        for (int i = 0; i < palabras.length; i++) {
            // ¿CUÁNTAS PALABRAS HAY EN EL ARRAY?
            // 1º) Buscar posición libre
            int filaAl = 0;
            int colAl = 0;
            // 1ª CASILLA INICIAL LIBRE
            do{
                filaAl = ale.nextInt(10);
                colAl = ale.nextInt(10);
            }while(sopaLetrasCopia[filaAl][colAl]!='0');
            //
            // 2ª) No superar límites
            // LÍMITE -> DCHA, columna
            if(colAl + (palabras[i].length()-1) > 10){
                i--;
            }else{
                boolean isLibre = true;
                int max = colAl + (palabras[i].length()-1); // 5 +(6-1) = 10
                for (int z=colAl;z<=max; z++){ //z={5,6,7,8,9,10}
                    if(sopaLetrasCopia[filaAl][z]!='0'){
                        isLibre = false;
                        break;
                    }
                }
                if(isLibre){ // PUEDO EMPEZAR A ESCRIBIR!!!,
                    int contador = 0;
                    for (int z=colAl;z<=max; z++){ //z={5,6,7,8,9,10}
                        sopaLetras[filaAl][z] = palabras[i].charAt(contador) ; //"helada"
                        sopaLetrasCopia[filaAl][z] = palabras[i].charAt(contador);
                        contador++;
                    }
                }
            }
        }
        imprimirMatriz();
        System.out.println();
        imprimirMatrizCopia();
    }
}