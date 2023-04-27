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

			// Se Muestra el men�
			System.out.println("1. A�adir Contacto");
			System.out.println("2. Listar Contactos");
			System.out.println("3. Eliminar Contacto");
			System.out.println("0. Salir");

			try {
				System.out.println("Escribe una de las opciones");
				opcion = sc.nextInt();

				switch (opcion) {
				
				// C�digo para llamar a la funci�n de agregar contacto
				case 1:
					auxiliar = sc.nextLine();
					
					System.out.println("Introduzca el nombre del contacto:");
					nombre = sc.nextLine();
					System.out.println("Introduzca el n�mero del contacto(Sin prefijo tel�fonio): ");
					numero = sc.nextInt();
					
					ag.agregarContacto(nombre, numero);
					
					break;
					
				// C�digo para llamar a la funci�n de listar contactos
				case 2:
					auxiliar = sc.nextLine();
					
					ag.listarContactos();
					
					break;
				
				// C�digo para llamar a la funci�n de eliminar contacto
				case 3:
					auxiliar = sc.nextLine();
					System.out.println("Los contactos actuales son: ");
					ag.listarContactos();
					
					System.out.println("\nIntroduzca los datos del contacto a eliminar");
					
					System.out.println("Introduzca el nombre del contacto:");
					nombre = sc.nextLine();
					System.out.println("Introduzca el n�mero del contacto(Sin prefijo tel�fonio): ");
					numero = sc.nextInt();
					
					ag.eliminarContacto(nombre, numero);
					
					break;
					
				// Salir del men�
				case 0:
					salir = true;
					break;
				default:
					System.out.println("Solo se admite n�meros entre 1 y 3");
				}

			} catch (InputMismatchException error) {
				System.out.println("Debes insertar un n�mero");
				sc.next();
			}
		}
		sc.close();
	}
}
