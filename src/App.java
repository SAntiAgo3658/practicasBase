public class App {
    public static void main(String[] args) {
        System.out.println(SuperHuman.getIdActual());
        SuperHero danielHero = new SuperHero();
        danielHero.setNombre("Daniel");

        SuperHero nuevoHeroe = new SuperHero("Superman");

        SuperVillain putin = new SuperVillain();
        putin.setNombre("Putin");

        System.out.println(danielHero.toString());
        System.out.println(nuevoHeroe);
        System.out.println(putin.toString());

        System.out.println("*********");
        System.out.println();
        System.out.println("Daniel id: "+ danielHero.getId());
        System.out.println("Superman id: "+ nuevoHeroe.getId());
        System.out.println("Putin id: "+ putin.getId());
        System.out.println(putin.getIdActual());

        danielHero.combate(putin);
        
    }
}
