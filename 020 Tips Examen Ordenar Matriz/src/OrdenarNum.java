import java.util.Random;

public class OrdenarNum {

    public static void main(String args[]){
        Random ale = new Random();
        int matriz[][] = new int[3][10];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ale.nextInt(90) + 10;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3 ; j++) {
                int candidato = matriz[j][i];
                for (int k = j; k < 3 ; k++) {
                    if(candidato>matriz[k][i]){
                        matriz[j][i] = matriz[k][i];
                        matriz[k][i] = candidato;
                    }
                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }


}
