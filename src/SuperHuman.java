import java.util.Random;

import skills.CombatSkills;
import skills.Skill;

public abstract class  SuperHuman implements CombatSkills {
   // los atributos numéricos siempre van a estar entre [0..100]
   // atributos:
   // nombre como string
   // caracteristicas (de tipo numérico):
   // inteligencia, agilidad, fuerza, resistencia.
   // atributo de clase con el id actual para q cada superHuman tenga uno y sea
   // consecutivo.
   private String nombre;
   private int inteligencia;
   private int agilidad;
   private int fuerza;
   private int resistencia;
   private static int id_actual=0;
   private int id;

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
      this.id = id_actual;
      id_actual++;

   }

   // sin parámetros
   public SuperHuman() {
      Random aleatorio = new Random();
      this.nombre = "Unknown";
      this.inteligencia = aleatorio.nextInt(10);
      this.agilidad = aleatorio.nextInt(10);
      this.fuerza = aleatorio.nextInt(10);
      this.resistencia = aleatorio.nextInt(10);
      this.id = id_actual;
      id_actual++;
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
      this.id = id_actual;
      id_actual++;
   }

   public SuperHuman(String nombre){
      this();
      this.setNombre(nombre);
   }

   // getters y setters

   public int getId(){
      return this.id;
   }

   public static int getIdActual(){
      return id_actual;
   }
   
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getInteligencia() {
      return inteligencia;
   }

   private void setInteligencia(int valor) {
      this.inteligencia = this.inteligencia + valor;
      if (this.inteligencia > 100) {
         this.inteligencia = 100;
      }
   }

   public int getAgilidad() {
      return agilidad;
   }

   private void setAgilidad(int valor) {
      this.agilidad = this.agilidad + valor;
      if (this.agilidad > 100) {
         this.agilidad = 100;
      }
   }

   public int getFuerza() {
      return fuerza;
   }

   private void setFuerza(int valor) {
      this.fuerza = this.fuerza + valor;
      if (this.fuerza > 100) {
         this.fuerza = 100;
      }
   }

   public int getResistencia() {
      return resistencia;
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

   public boolean combate(SuperHuman enemy) {
      // acaba cuando resistencia de algún luchador sea 0;
      int miResistencia = this.resistencia;
      int enemyResistencia = enemy.resistencia;
      while ((miResistencia > 0) && (enemyResistencia > 0)) {
         if (this.tiradaDados(Skill.inteligencia) > enemy.tiradaDados(Skill.inteligencia)) {
            // ataco yo
            enemyResistencia = this.ataque(enemy, enemyResistencia);
         } else {
            // atacas tu
            miResistencia = enemy.ataque(this, miResistencia);
         }
         System.out.println("[Mi resistencia: " + miResistencia +
               "] [Enemy resistencia: " + enemyResistencia + "]");

      }
      return (miResistencia > 0);
   }

   @Override
   public int kick() { // se basa en fuerza
      return tiradaDados(Skill.fuerza);
   }

   @Override
   public int punch() { // se basa en fuerza
      return tiradaDados(Skill.fuerza);
   }

   @Override
   public int shieldUp() { // se basa en agilidad
      return tiradaDados(Skill.agilidad);
   }

   @Override
   public int shieldDown() { // se basa en agilidad
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

   // devolver la resistencia resultante en el defensor
   private int ataque(SuperHuman defensor, int defensorResistencia) {

      Random aleatorio = new Random();
      boolean tipoAtaque = aleatorio.nextBoolean();
      int golpe = 0;

      System.out.print("Atacante: " + this.nombre + " [");
      if (tipoAtaque == true) {
         System.out.print("Patada ");
      } else {
         System.out.print("Puñetazo ");
      }

      if (aleatorio.nextInt(100) >= (100 - defensor.inteligencia)) {
         // exito en parar
         System.out.print("golpe parado ");
         if (tipoAtaque == true) {
            golpe = defensor.shieldDown() - this.kick();
         } else {
            golpe = defensor.shieldUp() - this.punch();
         }
      } else {
         // fallo en parar
         System.out.print("golpe NO parado ");
         // defiendo con la mitad.
         if (tipoAtaque == true) {
            golpe = (defensor.shieldDown() / 2) - this.kick();
         } else {
            golpe = (defensor.shieldUp() / 2) - this.punch();
         }

      }
      if (golpe < 0) {
         // he parado pero me ha hecho daño.
         defensorResistencia = defensorResistencia + golpe;
      } // si he parado pero no me ha hecho daño, no hago nada.

      System.out.println("]");

      return defensorResistencia;
   }


}
