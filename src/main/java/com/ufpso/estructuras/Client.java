
package com.ufpso.estructuras;

import java.time.LocalDate;

public class Client {
   LocalDate birthday;
   String identification;
   int tickets;

   public Client(LocalDate birthday, String identification) {
      this.birthday = birthday;
      this.identification = identification;
   }

   public int getAge() {
      return LocalDate.now().getYear() - this.birthday.getYear();
   }
}
