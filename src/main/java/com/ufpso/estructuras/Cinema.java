package com.ufpso.estructuras;

import java.util.ArrayList;

public class Cinema {

    String movieName;
    boolean isAdultMovie;
    int tickets;

    public Cinema(String movieName, boolean isAdultMovie, int tickets) {
        this.movieName = movieName;
        this.isAdultMovie = isAdultMovie;
        this.tickets = tickets;
        this.clients = new ArrayList<>();
    }

    ArrayList<Client> clients;

    public String getStats() {
        int majors = 0;
        int minors = 0;
        for (Client client : this.clients) {
            if (client.tickets == 0) {
                continue;
            }

            if (client.getAge() >= 18) {
                majors++;
            } else {
                minors++;
            }
        }

        return String.format("""
            Hay %d boletas disponibles.
                           
            Compras hechas por personas:
               Mayores de edad: %d
               Menores de edad: %d
            """, this.tickets, majors, minors);
    }

    public String getClientInfo(String identification) {
        Client client = null;
        for (Client c : this.clients) {
            if (c.identification.equals(identification)) {
                client = c;
                break;
            }
        }

        if (client == null) {
            return String.format("La persona con documento %s no ha comprado boletas.", identification);
        }

        return String.format("La persona con documento %s compró %d boletas.", client.identification, client.tickets);
    }
}
