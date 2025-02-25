package pojo;

public class Hulk extends SuperHero {

    public Hulk(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("SUPERFUERZA");
    }

    @Override
    public void defend() {
        System.out.println("SUPER PECHO");
    }

    @Override
    public void superAttack() {
        System.out.println("ULTRA SUPER PUÑO MAX 2 DE GUERRA");
    }

}
