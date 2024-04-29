import java.util.Random;

import skills.CombatSkills;
import skills.Skill;

public class SuperHuman implements CombatSkills {

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
      this.inteligencia = aleatorio.nextInt(100);
      this.agilidad = aleatorio.nextInt(100);
      this.fuerza = aleatorio.nextInt(100);
      this.resistencia = aleatorio.nextInt(100);

   }

   // con un parametro q indica q parámetro va a a ser predominante.

   public SuperHuman(Skill habilidad) {
      Random aleatorio = new Random();
      this.nombre = "Unknown";

      switch (habilidad) {

         case inteligencia:
            this.inteligencia = aleatorio.nextInt(5, 10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case agilidad:
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(5, 10);
            this.fuerza = aleatorio.nextInt(10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case fuerza:
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(5, 10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case resistencia:
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

   private void setInteligencia(int valor) {
      this.inteligencia = this.inteligencia + valor;

      if (this.inteligencia > 100) {
         this.inteligencia = 100;

      }

   }

   private void setAgilidad(int valor) {
      this.agilidad = this.agilidad + valor;
      if (this.agilidad > 100) {
         this.agilidad = 100;

      }
   }

   private void setFuerza(int valor) {
      this.fuerza = this.fuerza + valor;
      if (this.fuerza > 100) {
         this.fuerza = 100;

      }
   }

   private void setResistencia(int valor) {
      this.resistencia = this.resistencia + valor;
      if (this.resistencia > 100) {
         this.resistencia = 100;

      }
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

   public void entrenamiento(int dias, Skill caracteristica) {
      Random aleatorio = new Random();

      switch (caracteristica) {

         case inteligencia:
            this.setInteligencia(aleatorio.nextInt(dias));
            break;

         case agilidad:
            this.setAgilidad(aleatorio.nextInt(dias));
            break;

         case fuerza:
            this.setFuerza(aleatorio.nextInt(dias));
            break;

         case resistencia:
            this.setResistencia(aleatorio.nextInt(dias));
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

      // Acaba cuando resistencia de algún luchador sea 0

      int miResistencia = this.resistencia;
      int enemyResistencia = enemy.resistencia;
      Random aleatorio = new Random();
      int golpe = 0;

      while ((miResistencia > 0) && (enemyResistencia > 0)) {

         if (this.tiradaDados(Skill.inteligencia) > enemy.tiradaDados(Skill.inteligencia)) {
            // Ataco yo
            System.out.print("Atacante: YO [");

            if (aleatorio.nextBoolean()) {
               // Patada
               System.out.print("Patada ");

               if ((100 - enemy.inteligencia) <= (aleatorio.nextInt(100))) {
                  // Éxito en parar
                  System.out.print("parada ");

                  golpe = enemy.shielDown() - this.kick();

               } else {
                  // Fallo en parar, defiendo con la mitad
                  System.out.print("no parada ");
                  golpe = (enemy.shielDown() / 2) - this.kick();

               }

               if (golpe < 0) {

                  enemyResistencia = enemyResistencia + golpe;

               }

            } else {
               // Puñetazo
               System.out.print("Puñetazo ");

               if ((100 - enemy.inteligencia) <= (aleatorio.nextInt(100))) {
                  // Éxito en parar
                  System.out.print("parado ");
                  golpe = enemy.shieldUp() - this.punch();

               } else {
                  // Fallo en parar, defiendo con la mitad
                  System.out.print("no parado ");
                  golpe = (enemy.shieldUp() / 2) - this.punch();

               }

               if (golpe < 0) {

                  enemyResistencia = enemyResistencia + golpe;

               }

            }

            System.out.println("]");

         } else {
            // Atacas tú
            System.out.print("Atacante: ÉL [");

            if (aleatorio.nextBoolean()) {
               // Patada
               System.out.print("Patada ");

               if ((100 - this.inteligencia) <= (aleatorio.nextInt(100))) {
                  // Éxito en parar
                  System.out.print("parada ");
                  golpe = this.shielDown() - enemy.kick();

               } else {
                  // Fallo en parar, defiendo con la mitad
                  System.out.print("no parada ");
                  golpe = (this.shielDown() / 2) - enemy.kick();

               }

               if (golpe < 0) {
                  miResistencia = miResistencia + golpe;

               }

            } else {
               // Puñetazo
               System.out.print("Puñetazo ");

               if ((100 - this.inteligencia) <= (aleatorio.nextInt(100))) {
                  // Éxito en parar
                  System.out.print("parado ");
                  golpe = this.shieldUp() - enemy.punch();

               } else {
                  // Fallo en parar, defiendo con la mitad
                  System.out.print("no parado ");
                  golpe = (this.shieldUp() / 2) - enemy.punch();

               }

               if (golpe < 0) {
                  miResistencia = miResistencia + golpe;

               }

            }

            System.out.println("]");

         }

         System.out.println("[Mi resistencia: " + miResistencia + "]  [Enmy resistencia: " + enemyResistencia + "]");
         System.out.println();

      }

      return (miResistencia > 0);

   }

   @Override
   public int kick() { // Se basa en fuerza

      return tiradaDados(Skill.fuerza);

   }

   @Override
   public int punch() { // Se basa en fuerza

      return tiradaDados(Skill.fuerza);

   }

   @Override
   public int shieldUp() { // Se basa en agilidad

      return tiradaDados(Skill.agilidad);

   }

   @Override
   public int shielDown() { // Se basa en agilidad

      return tiradaDados(Skill.agilidad);

   }

   private int tiradaDados(Skill atributo) {

      Random aleatorio = new Random();
      int resultado = 0;

      switch (atributo) {
         case inteligencia:
            for (int i = 0; i < this.getInteligencia(); i++) {
               resultado = resultado + aleatorio.nextInt(10);

            }

            break;

         case agilidad:
            for (int i = 0; i < this.getAgilidad(); i++) {
               resultado = resultado + aleatorio.nextInt(10);

            }

            break;

         case fuerza:
            for (int i = 0; i < this.getFuerza(); i++) {
               resultado = resultado + aleatorio.nextInt(10);

            }

            break;

         case resistencia:
            for (int i = 0; i < this.getResistencia(); i++) {
               resultado = resultado + aleatorio.nextInt(10);

            }

            break;

         default:
            break;

      }

      return resultado;

   }

}