package PruebaDavid.David;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import PruebaDavid.David.empleado.Empleado;

public class TestEmpleado {

	    private static Object MENOR;
		private static Object MAYOR;
		private static Object IGUAL;

		@ParameterizedTest(name = "{index} => El nombre del empleado es {0}")
	    @MethodSource("getNombres")
	    public void testGetNombre(String nombre, Empleado empleado) {
	        assertThat(empleado.getNombre(), equals(nombre));
	    }

	    private static Collection<Object[]> getNombres() {
	        return Arrays.asList(new Object[][]{
	            {"Juan", new Empleado("Juan", "Perez", 30, 1000)},
	            {"Maria", new Empleado("Maria", "Lopez", 25, 800)}
	        });
	    }

	    @ParameterizedTest(name = "{index} => El apellido del empleado es {0}")
	    @MethodSource("getApellidos")
	    public void testGetApellido(String apellido, Empleado empleado) {
	        assertThat(empleado.getApellido(), equals(apellido));
	    }

	    private static Collection<Object[]> getApellidos() {
	        return Arrays.asList(new Object[][]{
	            {"Perez", new Empleado("Juan", "Perez", 30, 1000)},
	            {"Lopez", new Empleado("Maria", "Lopez", 25, 800)}
	        });
	    }

	    @ParameterizedTest(name = "{index} => La edad del empleado es {0}")
	    @MethodSource("getEdades")
	    public void testGetEdad(int edad, Empleado empleado) {
	        assertThat(empleado.getEdad(), equals(edad));
	    }

	    private static Collection<Object[]> getEdades() {
	        return Arrays.asList(new Object[][]{
	            {30, new Empleado("Juan", "Perez", 30, 1000)},
	            {25, new Empleado("Maria", "Lopez", 25, 800)}
	        });
	    }

	    @ParameterizedTest(name = "{index} => El salario del empleado es {0}")
	    @MethodSource("getSalarios")
	    public void testGetSalario(double salario, Empleado empleado) {
	        assertThat(empleado.getSalario(), equals(salario));
	    }

	    private static Collection<Object[]> getSalarios() {
	        return Arrays.asList(new Object[][]{
	            {1000.0, new Empleado("Juan", "Perez", 30, 1000)},
	            {800.0, new Empleado("Maria", "Lopez", 25, 800)}
	        });
	    }

	    
	    

	        private static final Empleado EMPLEADO1 = new Empleado("Juan", "Pérez", 25, 1000);
	        private static final Empleado EMPLEADO2 = new Empleado("Pedro", "González", 40, 1500);
	        private static final Empleado EMPLEADO3 = new Empleado("Ana", "Martínez", 60, 2000);

	        // Test parametrizado para el método plus
	        @ParameterizedTest
	        @MethodSource("empleadoProvider")
	        public void testPlus(Empleado empleado, double sueldoPlus, boolean expected) {
	            boolean actual = empleado.plus(sueldoPlus);
	            assertEquals(expected, actual);
	        }

	        private static List<Object[]> empleadoProvider() {
	            return Arrays.asList(
	                    new Object[]{EMPLEADO1, 100, false},
	                    new Object[]{EMPLEADO2, 200, true},
	                    new Object[]{EMPLEADO3, 300, true}
	            );
	        }

	        // Test parametrizado para el método equals
	        @ParameterizedTest
	        @MethodSource("empleadoProvider2")
	        public void testEquals(Empleado empleado1, Empleado empleado2, boolean expected) {
	            boolean actual = empleado1.equals(empleado2);
	            assertEquals(expected, actual);
	        }

	        private static List<Object[]> empleadoProvider2() {
	            return Arrays.asList(
	                    new Object[]{EMPLEADO1, EMPLEADO1, true},
	                    new Object[]{EMPLEADO2, EMPLEADO2, true},
	                    new Object[]{EMPLEADO1, EMPLEADO2, false}
	            );
	        }

	        // Test parametrizado para el método compareTo
	        @ParameterizedTest
	        @MethodSource("empleadoProvider3")
	        public void testCompareTo(Empleado empleado1, Empleado empleado2, int expected) {
	            int actual = empleado1.compareTo(empleado2);
	            assertThat(actual, equals(expected));
	        }

	        private static List<Object[]> empleadoProvider3() {
	            return Arrays.asList(
	                    new Object[]{EMPLEADO1, EMPLEADO2, MENOR},
	                    new Object[]{EMPLEADO2, EMPLEADO1, MAYOR},
	                    new Object[]{EMPLEADO2, EMPLEADO3, MENOR},
	                    new Object[]{EMPLEADO3, EMPLEADO2, MAYOR},
	                    new Object[]{EMPLEADO1, EMPLEADO3, MENOR},
	                    new Object[]{EMPLEADO3, EMPLEADO1, MAYOR},
	                    new Object[]{EMPLEADO1, EMPLEADO1, IGUAL},
	                    new Object[]{EMPLEADO2, EMPLEADO2, IGUAL},
	                    new Object[]{EMPLEADO3, EMPLEADO3, IGUAL}
	            );
	        }
	    }



