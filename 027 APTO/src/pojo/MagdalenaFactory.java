package pojo;

public class MagdalenaFactory {

    int contador = 0;

    private Magdalena[] factory = new Magdalena[4];

    public void addMagdalena(Magdalena magdalena) {
        factory[contador] = magdalena;
        contador++;
    }

    public void printMagdalenas() {
        for (int i = 0; i < factory.length; i++) {
            System.out.println(factory[i].getId() + ": Sabor: " + factory[i].getSabor() + ", Tamaño:  " + factory[i].getTamaño() + ", Decoracion:  " + factory[i].getDecorada());
        }
    }
}
