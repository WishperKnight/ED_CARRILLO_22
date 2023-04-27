package ejercicio11;

public class Contacto {

	// Atributos de la clase
	
	private String nombre;
	private int telefono;

	/**
	 * Constructor con parámetros
	 * 
	 * @param nombre
	 * @param telefono
	 */

	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	// Métodos GET y SET
	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
	}

}
