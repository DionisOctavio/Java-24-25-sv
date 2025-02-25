import pojo.FactorySuperHero;
import pojo.SuperHero;

public class Main {
    public static void main(String[] args) {

        SuperHero ironman = FactorySuperHero.getSuperHero(FactorySuperHero.IRONMAN, "pepe");
        ironman.attack();
        ironman.defend();
        ironman.superAttack();

    }
}