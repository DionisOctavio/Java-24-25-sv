package pojo;

public class MagdalenaFactory {
    private Magdalena[] factory = new Magdalena[4];

    public void addMagdalena(Magdalena magdalena) {
        for (int i = 0; i < factory.length; i++) {
            if (factory[i] == null) {
                factory[i] = magdalena;
                return;
            }
        }
    }

    public void printMagdalenas() {
        for (int i = 0; i < factory.length; i++) {
            if (factory[i] != null) {
                factory[i].printMagdalena();
            }
        }
    }
}
