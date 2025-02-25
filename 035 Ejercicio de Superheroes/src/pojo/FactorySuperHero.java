package pojo;

public class FactorySuperHero {

    public static final String IRONMAN = "ironman";
    public static final String SPIDERMAN = "spiderman";
    public static final String HULK = "hulk";

    public static SuperHero getSuperHero(String tipoSuperHero, String nombreSuperHero ) {

        switch (tipoSuperHero){
            case IRONMAN:
                return new IronMan(nombreSuperHero);
            case SPIDERMAN:
                return new SpiderMan(nombreSuperHero);
            case HULK:
                return new Hulk(nombreSuperHero);
        }
        return null;
    }
}
