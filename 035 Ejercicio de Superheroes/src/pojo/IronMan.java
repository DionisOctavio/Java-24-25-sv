package pojo;

public class IronMan extends SuperHero {

    public IronMan(String name) {
        super(name);

    }
    @Override
    public void attack(){
        System.out.println( "TURBO CAÑON" );
    }
    @Override
    public void defend(){
        System.out.println("NO SE DEFIENDE");
    }

    @Override
    public void superAttack(){
        System.out.println("PECHO LASER");
    }

}
