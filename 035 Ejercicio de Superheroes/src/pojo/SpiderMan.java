package pojo;

public class SpiderMan extends SuperHero{

    public SpiderMan(String name) {
        super(name);
    }

    @Override
    public void attack(){
        System.out.println( "TELAARAÑA EPICA" );
    }
    @Override
    public void defend(){
        System.out.println("ESCUDO DE SEDA");
    }

    @Override
    public void superAttack(){
        System.out.println("EJERCITO DE ARAÑAS");
    }
}
