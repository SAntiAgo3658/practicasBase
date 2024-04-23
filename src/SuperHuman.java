import java.util.Random;

public class SuperHuman {
   // los atributos numéricos siempre van a estar entre [0..100]
   // atributos:
   // nombre como string
   // caracteristicas (de tipo numérico):
   // inteligencia, agilidad, fuerza, resistencia.
   private String nombre;
   private int inteligencia;
   private int agilidad;
   private int fuerza;
   private int resistencia;

   // constructorES !!
   // con todos los parámetros.
   public SuperHuman(String nombre, int inteligencia, int agilidad, int fuerza, int resistencia) {
      this.nombre = nombre;
      // controlar que los parámetros sean válidos [0..10]
      // el q no lo sea se pone a 0

      if (inteligencia < 10 && inteligencia > 0) {
         this.inteligencia = inteligencia;
      } else {
         this.inteligencia = 0;
      }

      if (agilidad < 10 && agilidad > 0) {
         this.agilidad = agilidad;
      } else {
         this.agilidad = 0;
      }
      if (resistencia < 10 && resistencia > 0) {
         this.resistencia = resistencia;
      } else {
         this.resistencia = 0;
      }
      if (fuerza < 10 && fuerza > 0) {
         this.fuerza = fuerza;
      } else {
         this.fuerza = 0;
      }

   }

   // sin parámetros
   public SuperHuman() {
      Random aleatorio = new Random();
      this.nombre = "Unknown";
      this.inteligencia = aleatorio.nextInt(10);
      this.agilidad = aleatorio.nextInt(10);
      this.fuerza = aleatorio.nextInt(10);
      this.resistencia = aleatorio.nextInt(10);
   }

   // con un parametro q indica q parámetro va a a ser predominante.
   public SuperHuman(String caracteristica) {
      Random aleatorio = new Random();
      this.nombre = "Unknown";
      switch (caracteristica) {
         case "inteligencia":
            this.inteligencia = aleatorio.nextInt(5, 10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(10);
            this.resistencia = aleatorio.nextInt(10);
            break;
         case "agilidad":
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(5, 10);
            this.fuerza = aleatorio.nextInt(10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case "fuerza":
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(5, 10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case "resistencia":
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(5, 10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         default:
            break;
      }
   }

   // getters y setters
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getInteligencia() {
      return inteligencia;
   }

   public int getAgilidad() {
      return agilidad;
   }

   public int getFuerza() {
      return fuerza;
   }

   public int getResistencia() {
      return resistencia;
   }

   // toString (de VSC)
   @Override
   public String toString() {
      return "SuperHero [nombre=" + nombre + ", inteligencia=" + inteligencia + ", agilidad=" + agilidad + ", fuerza="
            + fuerza + ", resistencia=" + resistencia + "]";
   }

   // métodos:
   // public void entrenamiento(int dias,String caracteristica)
   // lo q hace es la caracteristica la incrementa en funcion del número de días
   // introducido pero que genere un valor aleatorio entre 0 y esos días y ese
   // valor
   // se le suma a la característica.
   // ejemplo: entrenamiento(5,"agilidad");
   // me incrementa agilidad en un valor=[0..5](aleatorio)
   public void entrenamiento(int dias, String caracteristica) {
      Random aleatorio = new Random();

      switch (caracteristica) {
         case "inteligencia":
            this.inteligencia = this.inteligencia + aleatorio.nextInt(dias);
            break;
         case "agilidad":
            this.agilidad = this.agilidad + aleatorio.nextInt(dias);
            break;
         case "fuerza":
            this.fuerza = this.fuerza + aleatorio.nextInt(dias);
            break;
         case "resistencia":
            this.resistencia = this.resistencia + aleatorio.nextInt(dias);
            break;
         default:
            break;
      }
   }

   // otro método:
   // public boolean combate(SuperHero enemy){}
   // devuelve true si gana mi superheroe y false si gana enemy.
   // cada héroe genera un valor de combate de la siguiente manera:
   // valorCombate =
   // por cada unidad de las caracteristicas: (agilidad, fuerza, resistencia) se
   // genera un valor aleatorio entre [0..10] y se suma a valorCombate.
   // gana el que tenga el valor más alto.
   public boolean combate(SuperHuman enemy) {
      Random aleatorio = new Random();

      // enemigo
      int combateEnemy = 0;
      // agilidad
      for (int i = 0; i < enemy.getAgilidad(); i++) {
         combateEnemy = combateEnemy + aleatorio.nextInt(10);
      }
      // fuerza
      for (int i = 0; i < enemy.getFuerza(); i++) {
         combateEnemy = combateEnemy + aleatorio.nextInt(10);
      }
      // resistencia
      for (int i = 0; i < enemy.getResistencia(); i++) {
         combateEnemy = combateEnemy + aleatorio.nextInt(10);
      }

      // yo
      int combateYo = 0;
      // agilidad
      for (int i = 0; i < this.getAgilidad(); i++) {
         combateYo = combateYo + aleatorio.nextInt(10);
      }
      // fuerza
      for (int i = 0; i < this.getFuerza(); i++) {
         combateYo = combateYo + aleatorio.nextInt(10);
      }
      // resistencia
      for (int i = 0; i < this.getResistencia(); i++) {
         combateYo = combateYo + aleatorio.nextInt(10);
      }

      return (combateYo >= combateEnemy);
   }

}
