
package com.ufpso.estructuras;

public class Cinema {
   String movieName;
   boolean isAdultMovie;
   int tickets;

   Client[] clients;

   public String getStats() {
      int majors = 0;
      int minors = 0;
      for (Client client: this.clients) {
         if (client.getAge() >= 18) {
            majors++;
         } else {
            minors++;
         }
      }
      
      return String.format("""
            Compras hechas por personas:
               Mayores de edad: %d
               Menores de edad: %d
            """, majors, minors);
   }

   public String getClientInfo(String identification) {
      Client client = null; 
      for (Client c: this.clients) {
         if (c.identification == identification) {
            client = c;
            break;
         }
      }
      
      if (client == null) {
         return String.format("La persona con documento %s no ha comprado boletas.", identification);
      }

      return String.format("La persona con documento %s compró %d boletas.", client.identification, client.tickets);
   }

   public void sortClients() {

   }
}
