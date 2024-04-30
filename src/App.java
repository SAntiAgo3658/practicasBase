public class App {
    public static void main(String[] args) {
        SuperHero danielHero = new SuperHero();
        danielHero.setNombre("Daniel");
        SuperVillain putin = new SuperVillain();
        putin.setNombre("Putin");

        System.out.println(danielHero.toString());
        System.out.println(putin.toString());

        danielHero.combate(putin);
    }
}
