package ejercico_8;

import java.util.*;

public class CapitalDePaises {
    public static void main(String[] args) {
        // Diccionario de capitales conocidas
        Map<String, String> capitales = new HashMap<>();
        capitales.put("España", "Madrid");
        capitales.put("Portugal", "Lisboa");
        capitales.put("Francia", "París");

        // Pedir al usuario el nombre del país
        Scanner scanner = new Scanner(System.in);
        String pais = "";
        while (!pais.equals("salir")) {
            System.out.print("Introduzca el nombre del país (o salir para terminar): ");
            pais = scanner.nextLine();
            if (pais.equals("salir")) {
                break;
            }
            // Buscar la capital en el diccionario
            String capital = capitales.get(pais);
            if (capital != null) {
                System.out.println("La capital de " + pais + " es " + capital + ".");
            } else {
                // Pedir al usuario la capital y almacenarla en el diccionario
                System.out.print("No conozco la capital de " + pais + ". Por favor, introduzca la capital: ");
                capital = scanner.nextLine();
                capitales.put(pais, capital);
                System.out.println("Gracias por enseñarme la capital de " + pais + ".");
            }
        }
        System.out.println("Adiós!");
    }
}

