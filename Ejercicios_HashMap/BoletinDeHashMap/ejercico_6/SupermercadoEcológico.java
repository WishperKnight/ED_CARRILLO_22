package ejercico_6;

import java.util.*;

public class SupermercadoEcológico {
    public static void main(String[] args) {
        // Diccionario con los productos y sus precios
        Map<String, Double> productos = new HashMap<>();
        productos.put("leche de almendra", 1.50);
        productos.put("yogur de soja", 2.20);
        productos.put("tofu", 1.80);
        productos.put("garbanzos cocidos", 1.10);
        productos.put("quinoa", 3.50);
        
        // Lista para almacenar la compra
        List<String> compra = new ArrayList<>();
        
        // Pedir al usuario la compra
        Scanner scanner = new Scanner(System.in);
        String producto = "";
        int cantidad = 0;
        do {
            System.out.print("Introduzca el producto y la cantidad (o fin para terminar la compra): ");
            String entrada = scanner.nextLine();
            if (entrada.equals("fin")) {
                break;
            }
            String[] partes = entrada.split(" ");
            producto = partes[0];
            cantidad = Integer.parseInt(partes[1]);
            compra.add(producto + " " + cantidad);
        } while (true);
        
        // Calcular el precio total de la compra
        double precioTotal = 0.0;
        for (String item : compra) {
            String[] partes = item.split(" ");
            producto = partes[0];
            cantidad = Integer.parseInt(partes[1]);
            double precioUnitario = productos.get(producto);
            precioTotal += precioUnitario * cantidad;
        }
        
        // Mostrar el precio total de la compra
        System.out.println("El precio total de la compra es " + precioTotal + " euros.");
    }
}
