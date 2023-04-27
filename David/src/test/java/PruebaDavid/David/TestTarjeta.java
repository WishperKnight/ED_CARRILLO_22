package PruebaDavid.David;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import PruebaDavid.David.cuentas.Cuenta;
import PruebaDavid.David.cuentas.IngresoNegativoException;
import PruebaDavid.David.cuentas.Movimiento;
import PruebaDavid.David.cuentas.SaldoInsuficienteException;

public class TestTarjeta {

    private Cuenta cuenta;

    

    
	@SuppressWarnings("unlikely-arg-type")
	@Test
    public void ingresar_conceptoValido_yCantidadPositiva_aumentaSaldo() throws Exception {
        double saldoAnterior = cuenta.getSaldo();
        cuenta.ingresar("Ingreso mensual", 1000.0);
        assertThat(cuenta.getSaldo(), equals(saldoAnterior + 1000.0));
    }

    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void ingresar_cantidadNegativa_lanzaExcepcion() {
        Exception exception = assertThrows(IngresoNegativoException.class, () -> cuenta.ingresar("Ingreso negativo", -100.0));
        assertThat(exception.getMessage(), equals("No se puede ingresar una cantidad negativa"));
    }



        @SuppressWarnings("unlikely-arg-type")
		@Test
        public void retirar_conceptoValido_yCantidadPositiva_disminuyeSaldo() throws IngresoNegativoException, SaldoInsuficienteException {
            cuenta.ingresar("Ingreso mensual", 1000.0);
            double saldoAnterior = cuenta.getSaldo();
            cuenta.retirar("Pago de renta", 500.0);
            assertThat(cuenta.getSaldo(), equals(saldoAnterior - 500.0));
        }

        @SuppressWarnings("unlikely-arg-type")
		@Test
        public void retirar_cantidadNegativa_lanzaExcepcion() {
            Exception exception = assertThrows(IngresoNegativoException.class, () -> cuenta.retirar("Retiro negativo", -100.0));
            assertThat(exception.getMessage(), equals("No se puede retirar una cantidad negativa"));
        }

        @SuppressWarnings("unlikely-arg-type")
		@Test
        public void retirar_saldoInsuficiente_lanzaExcepcion() {
            Exception exception = assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar("Retiro mayor al saldo", 1000.0));
            assertThat(exception.getMessage(), equals("Saldo insuficiente"));
        }
        
        @SuppressWarnings("unlikely-arg-type")
		@Test
        public void retirar_conceptoValido_yCantidadPositiva_disminuyeSaldo1() throws IngresoNegativoException, SaldoInsuficienteException {
            cuenta.ingresar("Ingreso mensual", 1000.0);
            double saldoAnterior = cuenta.getSaldo();
            cuenta.retirar("Pago de renta", 500.0);
            assertThat(cuenta.getSaldo(), equals(saldoAnterior - 500.0));
        }

        private void assertThat(double saldo, boolean equals) {
			// TODO Auto-generated method stub
			
		}

		@SuppressWarnings("unlikely-arg-type")
		@Test
        public void retirar_cantidadNegativa_lanzaExcepcion1() {
            Exception exception = assertThrows(IngresoNegativoException.class, () -> cuenta.retirar("Retiro negativo", -100.0));
            assertThat(exception.getMessage(), equals("No se puede retirar una cantidad negativa"));
        }

        private void assertThat(String message, boolean equals) {
			// TODO Auto-generated method stub
			
		}

		@SuppressWarnings("unlikely-arg-type")
		@Test
        public void retirar_saldoInsuficiente_lanzaExcepcion1() {
            Exception exception = assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar("Retiro mayor al saldo", 1000.0));
            assertThat(exception.getMessage(), equals("Saldo insuficiente"));
        }
        @SuppressWarnings("unlikely-arg-type")
		@Test
        public void addMovimiento_agregaMovimiento_aumentaTamanoMovimientos() {
            int tamanoAnterior = cuenta.mMovimientos.size();
            Movimiento movimiento = new Movimiento();
            cuenta.addMovimiento(movimiento);
            assertThat(cuenta.mMovimientos.size(), equals(tamanoAnterior + 1));
        }

        @Test
        @DisplayName("Test adding a positive amount to account")
        void test_ingresar_positive_amount() throws IngresoNegativoException {
            Cuenta cuenta = new Cuenta("123", "John");
            cuenta.ingresar("Salary", 1000.0);
            assertEquals(cuenta.getSaldo(), 1000.0);
        }

        @Test
        @DisplayName("Test adding a negative amount to account")
        void test_ingresar_negative_amount() {
            Cuenta cuenta = new Cuenta("123", "John");
            assertThrows(IngresoNegativoException.class, () -> cuenta.ingresar("Negative amount", -100.0));
        }

        @Test
        @DisplayName("Test withdrawing a valid amount from account")
        void test_retirar_valid_amount() throws IngresoNegativoException, SaldoInsuficienteException {
            Cuenta cuenta = new Cuenta("123", "John");
            cuenta.ingresar("Salary", 1000.0);
            cuenta.retirar("Rent", 500.0);
            assertEquals(cuenta.getSaldo(), 500.0);
        }

        @Test
        @DisplayName("Test withdrawing an amount greater than balance from account")
        void test_retirar_amount_greater_than_balance() {
            Cuenta cuenta = new Cuenta("123", "John");
            assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar("Exceeded balance", 500.0));
        }

        @Test
        @DisplayName("Test withdrawing a negative amount from account")
        void test_retirar_negative_amount() {
            Cuenta cuenta = new Cuenta("123", "John");
            assertThrows(IngresoNegativoException.class, () -> cuenta.retirar("Negative amount", -100.0));
        }

        @SuppressWarnings("unlikely-arg-type")
		@Test
        @DisplayName("Test getSaldo method returns the correct balance")
        void test_getSaldo() throws IngresoNegativoException, SaldoInsuficienteException {
            Cuenta cuenta = new Cuenta("123", "John");
            cuenta.ingresar("Salary", 1000.0);
            cuenta.ingresar("Bonus", 500.0);
            cuenta.retirar("Rent", 800.0);
            assertThat(cuenta.getSaldo(), equals(700.0));
        }
        @SuppressWarnings("unlikely-arg-type")
		@Test
        @DisplayName("Test setting and getting mConcepto field")
        void test_mConcepto() {
            Movimiento movimiento = new Movimiento();
            movimiento.setConcepto("Test concept");
            assertThat(movimiento.getConcepto(), equals("Test concept"));
        }
		private void assertThat(int i, boolean equals) {
			// TODO Auto-generated method stub
			
		}
    }





