
public class FinalAbsStatInt {

   public static void main(String[] args) {
      Hijo miHijo = new Hijo();
      miHijo.imprime();
      System.out.println(miHijo.suma());
   } // fin main

} // fin clase

abstract class Padre {
   protected void imprime() {
      System.out.println("*");
      
   }
}

interface Madre {
   int contadorMadre = 0;
   default int suma(){
      return 1;
   }
}

class Hijo extends Padre implements Madre {
   String nombre = "Cesur";
   static int contador = 0;

   public int suma(){
      return 2;
   }
   public void imprime() {
      super.imprime();
      System.out.println("#");
   }

   protected void saluda() {
      System.out.println("Hola");
   };

   public static int getNombre() {
      
      return contador+ contadorMadre;
   }

   public int getcontMadre(){
      return contadorMadre;
   }

}
