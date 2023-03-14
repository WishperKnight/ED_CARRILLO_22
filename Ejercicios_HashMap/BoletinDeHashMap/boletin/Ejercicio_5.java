package boletin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class Ejercicio_5 {
	 public static void main(String[] args) {
	        // Se crea un mapa con los valores de las cartas
	        HashMap<String, Integer> valores = new HashMap<>();
	        valores.put("as", 11);
	        valores.put("tres", 10);
	        valores.put("sota", 2);
	        valores.put("caballo", 3);
	        valores.put("rey", 4);
	        
	        // Se crea una baraja de cartas
	        ArrayList<Carta> baraja = new ArrayList<>();
	        baraja.add(new Carta("oros", "as"));
	        baraja.add(new Carta("oros", "tres"));
	        baraja.add(new Carta("oros", "sota"));
	        baraja.add(new Carta("oros", "caballo"));
	        baraja.add(new Carta("oros", "rey"));
	        baraja.add(new Carta("copas", "as"));
	        baraja.add(new Carta("copas", "tres"));
	        baraja.add(new Carta("copas", "sota"));
	        baraja.add(new Carta("copas", "caballo"));
	        baraja.add(new Carta("copas", "rey"));
	        baraja.add(new Carta("espadas", "as"));
	        baraja.add(new Carta("espadas", "tres"));
	        baraja.add(new Carta("espadas", "sota"));
	        baraja.add(new Carta("espadas", "caballo"));
	        baraja.add(new Carta("espadas", "rey"));
	        baraja.add(new Carta("bastos", "as"));
	        baraja.add(new Carta("bastos", "tres"));
	        baraja.add(new Carta("bastos", "sota"));
	        baraja.add(new Carta("bastos", "caballo"));
	        baraja.add(new Carta("bastos", "rey"));
	        
	        // Se seleccionan 5 cartas aleatorias de la baraja
	        Random rand = new Random();
	        ArrayList<Carta> mano = new ArrayList<>();
	        for (int i = 0; i < 5; i++) {
	            int index = rand.nextInt(baraja.size());
	            mano.add(baraja.get(index));
	            baraja.remove(index);
	        }
	        
	        // Se calcula la suma de los valores de las cartas de la mano
	        int suma = 0;
	        for (Carta carta : mano) {
	            suma += valores.get(carta.getFigura());
	        }
	        
	        // Se imprime la mano y la suma de los valores de las cartas
	        System.out.println("Mano: " + mano);
	        System.out.println("Suma: " + suma);
	    }
	}

}
