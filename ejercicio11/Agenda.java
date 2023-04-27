package ejercicio11;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Agenda {

	// Atributos de la clase
	public static String ruta = "relacion1_Ficheros/ejercicio11/contactos.dat";
	private ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();

	/**
	 * Constructor de la Clase
	 */

	public Agenda() {

		// Se comprueba si la agenda está vacía
		if (!agendaVacia()) {

			try (DataInputStream br = new DataInputStream(new FileInputStream(ruta));){
				

				while (true) {
					String nombre = br.readUTF();
					int numero = br.readInt();

					listaContactos.add(new Contacto(nombre, numero));
				}
			} catch (EOFException e) {
				System.out.println("Final del archivo");
			} 
			catch (FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero");
			} catch (IOException ioe) {
				System.out.println("No se ha podido leer el fichero");
			}
		}

	}

	// Métodos GET

	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}

	/**
	 * Método para comprobar si la agenda está vacía Si no existe el fichero
	 * contactos.txt lo crea para evitar errores
	 * 
	 * return devuelve un boolean con un true si está vacía y un false si no
	 */
	private boolean agendaVacia() {

		boolean estaVacia = false;

		FileReader lectura;
		try {

			File fichero = new File(ruta);
			try {

				// Se comprueba si el fichero existe en la ruta sino existe lo crea
				if (fichero.createNewFile()) {
					System.out.println("El fichero para almacenar contactos no existía.");
					System.out.println("Se ha creado el fichero en la ruta " + ruta + " correctamente \n");

				}
			} catch (IOException e) {
				System.out.println("Entrada incorrecta");
			}

			// Se procede a leer el fichero para comprobar si está vacío o no
			lectura = new FileReader(ruta);

			int esNulo = lectura.read();

			if (esNulo == -1) {
				estaVacia = true;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException ioe) {
			System.out.println("No se ha podido leer el fichero");
		}

		return estaVacia;
	}

	/**
	 * Método para listar los contactos de la agenda
	 */
	public void listarContactos() {
		if (agendaVacia()) {
			System.out.println("La agenda está vacía");
		} else {

			for (Contacto c : listaContactos) {
				System.out.println(c);
			}
		}
	}

	/**
	 * Método para agregar contacto a la agenda
	 * 
	 * @param nombre, nombre a introducir en la agenda
	 * @param numero, teléfono a introducir en la agenda
	 */
	public void agregarContacto(String nombre, int numero) {
		Contacto contactoAuxiliar = new Contacto(nombre, numero);

		// Se agrega primero al ArrayList
		
		listaContactos.add(contactoAuxiliar);

		// Se crea un buffer de escritura para rellenar el fichero con el nombre y
		// teléfono pasados por parámetro
		
		try {
			//FileOutputStream flujoSalida = new FileOutputStream(ruta);
			DataOutputStream bw = new DataOutputStream(new FileOutputStream(ruta));
            bw.writeUTF(nombre);
            bw.writeInt(numero);
            
            bw.close();
			System.out.println("Contacto añadido correctamente.");
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException ioe) {
			System.out.println("No se ha podido leer el fichero");
		}

	}

	/**
	 * Método para realizar la búsqueda de un contacto por el nombre
	 * 
	 * @param nombre, nombre a buscar en la agenda
	 * @return devuelve 1 si ha encontrado el contacto y -1 si no se ha encontrado
	 */
	private int buscarContacto(String nombre) {
		Contacto contactoAuxiliar = new Contacto("", 0);
		int encontrado = -1;
		for (Contacto c : listaContactos) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {

				contactoAuxiliar.setNombre(nombre);
				contactoAuxiliar.setTelefono(c.getTelefono());
				encontrado = 1;
			}
		}
		return encontrado;

	}

	/**
	 * Método para eliminar contactos pasando nombre y teléfono
	 * 
	 * @param nombre,   nombre del contacto a terminar
	 * @param telefono, teléfono del contacto a eliminar
	 */
	public void eliminarContacto(String nombre, int telefono) {

		// Se llama a buscar contacto para verificar si existe
		int encontrado = buscarContacto(nombre);
		String nombreAuxiliar = "";
		int numero = 0;

		int posicion = 0;

		// Se comprueba si se ha encontrado o no el contacto
		if (encontrado == -1) {
			System.out.println("Contacto no encontrado");
		} else {

			// Se recorre el array para buscar la posición del contacto que buscamos
			for (int i = 0; i < listaContactos.size(); i++) {
				if (listaContactos.get(i).getNombre().equalsIgnoreCase(nombre)
						&& listaContactos.get(i).getTelefono() == telefono) {
					posicion = i;
				}
			}
			// Se elimina el elemento en la posición anteriomente buscada
			listaContactos.remove(posicion);

			try {

				// Se elimina el fichero pasandole la ruta y mediante el BufferedWriter lo
				// creamos de nuevo
				File fichero = new File(ruta);
				fichero.delete();

				FileOutputStream flujoSalida = new FileOutputStream(ruta);

				DataOutputStream bw = new DataOutputStream(flujoSalida);

				// Se recorre el array y se va escribiendo en el fichero para así tenerlo
				// actualizado
				for (Contacto contacto : listaContactos) {

					bw.writeUTF(contacto.getNombre());
					bw.writeInt(contacto.getTelefono());

				}
				bw.close();
			} catch (FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero");
			} catch (IOException ioe) {
				System.out.println("No se ha podido leer el fichero");
			}
			System.out.println("Contacto Eliminado correctamente");
		}
	}

}
