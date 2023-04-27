package ejercicio11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaMain {

	public static void main(String[] args) {
		Agenda ag = new Agenda();

		Scanner sc = new Scanner(System.in);
		String auxiliar, nombre;
		int numero;
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario

		while (!salir) {

			// Se Muestra el menú
			System.out.println("1. Añadir Contacto");
			System.out.println("2. Listar Contactos");
			System.out.println("3. Eliminar Contacto");
			System.out.println("0. Salir");

			try {
				System.out.println("Escribe una de las opciones");
				opcion = sc.nextInt();

				switch (opcion) {
				
				// Código para llamar a la función de agregar contacto
				case 1:
					auxiliar = sc.nextLine();
					
					System.out.println("Introduzca el nombre del contacto:");
					nombre = sc.nextLine();
					System.out.println("Introduzca el número del contacto(Sin prefijo teléfonio): ");
					numero = sc.nextInt();
					
					ag.agregarContacto(nombre, numero);
					
					break;
					
				// Código para llamar a la función de listar contactos
				case 2:
					auxiliar = sc.nextLine();
					
					ag.listarContactos();
					
					break;
				
				// Código para llamar a la función de eliminar contacto
				case 3:
					auxiliar = sc.nextLine();
					System.out.println("Los contactos actuales son: ");
					ag.listarContactos();
					
					System.out.println("\nIntroduzca los datos del contacto a eliminar");
					
					System.out.println("Introduzca el nombre del contacto:");
					nombre = sc.nextLine();
					System.out.println("Introduzca el número del contacto(Sin prefijo teléfonio): ");
					numero = sc.nextInt();
					
					ag.eliminarContacto(nombre, numero);
					
					break;
					
				// Salir del menú
				case 0:
					salir = true;
					break;
				default:
					System.out.println("Solo se admite números entre 1 y 3");
				}

			} catch (InputMismatchException error) {
				System.out.println("Debes insertar un número");
				sc.next();
			}
		}
		sc.close();
	}
}
