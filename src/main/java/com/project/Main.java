package com.project;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import java.util.Collection;


public class Main {

   public static void main(String[] args) {
      
      String basePath = System.getProperty("user.dir") + "/data/";

      // Crear la carpeta 'data' si no existeix
      File dir = new File(basePath);
      if (!dir.exists()){
         if(!dir.mkdirs()) {
               System.out.println("Error en la creació de la carpeta 'data'");
         }
      }

      Manager.createSessionFactory();

      Ciutat ciutat1 = Manager.addCiutat("Barcelona", "Spain", 18001);
      Ciutat ciutat2 = Manager.addCiutat("Paris", "France", 75001);
      Ciutat ciutat3 = Manager.addCiutat("New York", "USA", 10001);

      Ciutada ciutada1 = Manager.addCiutada(ciutat1.getCiutatId(), "John", "Doe", 30);
      Ciutada ciutada2 = Manager.addCiutada(ciutat1.getCiutatId(), "Alice", "Smith", 25);

      Ciutada ciutada3 = Manager.addCiutada(ciutat2.getCiutatId(), "Bob", "Johnson", 40);
      Ciutada ciutada4 = Manager.addCiutada(ciutat2.getCiutatId(), "Eva", "Brown", 35);

      Ciutada ciutada5 = Manager.addCiutada(ciutat3.getCiutatId(), "Michael", "Miller", 28);
      Ciutada ciutada6 = Manager.addCiutada(ciutat3.getCiutatId(), "Sophie", "Davis", 22);

      System.out.println("Ciutats i Ciutadans inicials:");
      printCiutatsAndCiutadans();

      // Esborra el segon ciutadà de cada ciutat
      Manager.delete(Ciutada.class, ciutada2.getId());
      Manager.delete(Ciutada.class, ciutada4.getId());
      Manager.delete(Ciutada.class, ciutada6.getId());

      // Esborra la segona ciutat
      Manager.delete(Ciutat.class, ciutat2.getCiutatId());

      System.out.println("\nCiutats i Ciutadans després d'esborrar:");
      printCiutatsAndCiutadans();

      Manager.close();
   }

   private static void printCiutatsAndCiutadans() {
      Collection<?> ciutats = Manager.listCollection(Ciutat.class);
      for (Object obj : ciutats) {
         Ciutat cObj = (Ciutat) obj;
         System.out.println("Ciutadans de " + cObj.getNom() + ":");
         Collection<?> ciutadans = Manager.listCollection(Ciutada.class, "ciutatId=" + cObj.getCiutatId());
         for (Object obj2 : ciutadans) {
               Ciutada cObj2 = (Ciutada) obj2;
               System.out.println("    " + cObj2.toString());
         }
      }
   }
}