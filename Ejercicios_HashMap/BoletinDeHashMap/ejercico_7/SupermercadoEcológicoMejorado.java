package ejercico_7;

import java.util.*;

public class SupermercadoEcológicoMejorado {
    public static void main(String[] args) {
        // Diccionario con los productos y sus precios
        Map<String, Double> productos = new HashMap<>();
        productos.put("leche de almendra", 1.50);
        productos.put("yogur de soja", 2.20);
        productos.put("tofu", 1.80);
        productos.put("garbanzos cocidos", 1.10);
        productos.put("quinoa", 3.50);
        
        // Mapa para almacenar la compra (producto -> cantidad)
        Map<String, Integer> compra = new HashMap<>();
        
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
            if (compra.containsKey(producto)) {
                cantidad += compra.get(producto);
            }
            compra.put(producto, cantidad);
        } while (true);
        
        // Pedir al usuario el código de descuento
        System.out.print("Introduzca el código de descuento (o dejar en blanco si no tiene): ");
        String codigoDescuento = scanner.nextLine();
        
        // Calcular el precio total de la compra
        double precioTotal = 0.0;
        for (Map.Entry<String, Integer> entry : compra.entrySet()) {
            producto = entry.getKey();
            cantidad = entry.getValue();
            double precioUnitario = productos.get(producto);
            precioTotal += precioUnitario * cantidad;
        }
        
        // Aplicar el descuento si corresponde
        if (codigoDescuento.equals("ECODTO")) {
            precioTotal *= 0.9; // 10% de descuento
        }
        
        // Mostrar el precio total de la compra
        System.out.println("El precio total de la compra es " + precioTotal + " euros.");
    }
}

