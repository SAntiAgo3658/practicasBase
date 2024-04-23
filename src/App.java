public class App {
    public static void main(String[] args) throws Exception {
        // SuperHero bueno = new SuperHero("el bueno", 5, 5, 5, 5);
        // SuperHero malo = new SuperHero("el malo", 5, 5, 5, 5);
        
        // System.out.println("Gana el bueno?: "+ bueno.combate(malo));
        // System.out.println("Gana el malo?: "+malo.combate(bueno));

        SuperHuman human1 = new SuperHuman();
        SuperHuman human2 = new SuperHuman("inteligencia");
        SuperHero superHero = new SuperHero();
        SuperVillain superVillain = new SuperVillain();

        System.out.println(superHero instanceof SuperHero);
        System.out.println(superHero instanceof SuperHuman);
        System.out.println(superHero.getClass().equals(superVillain.getClass()));
        System.out.println(superHero.getClass().equals(human1.getClass()));
        System.out.println(superHero.getClass().equals(SuperHuman.class));
    }
}
