package cmls.spring.codesmells.level.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * (Efectos colaterales no controlados)
 * 
 * Explicación: Es muy facil que ocurran RuntimeExceptions y que los tests no lo
 * estén controlando
 * 
 * Problema: Cuando hacemos una clase de test, es posible que no estemos
 * controlando una parte del código con su debida cobertura
 * 
 * Solución: Deberíamos hacer un control de la clase A, más profundo y analizar
 * los casos donde puedan ocurrir excepciones en tiempo de ejecución, como puede
 * ser el envío de un valor vacio, para ello capturamos las posibles excepciones
 * y asignamos el comportamiento necesario.
 * 
 * @author Carlos Lozano
 *
 */
public class UncontrolledSideEffects {

	static class Problem {
		static class A {
			static int stringIntoInt(String paramA) {
				return Integer.parseInt(paramA);
			}
		}

		class ATest {
			// @Test
			public void givenStringWhenConvertThenShouldReturnIntValue() {
				// given
				String paramAString = "1";

				// when
				int paramAInt = Problem.A.stringIntoInt(paramAString);

				// then
				assertEquals(1, paramAInt);
			}
		}
	}

	static class Solution {
		static class A {
			static int stringIntoInt(String paramA) {
				try {
					return Integer.parseInt(paramA);
				} catch (NumberFormatException nfe) {
					return -999;
				}
			}
		}

		class ATest {
			// @Test
			public void givenStringWhenConvertThenShouldReturnIntValue() {
				// given
				String paramAString = "1";

				// when
				int paramAInt = Problem.A.stringIntoInt(paramAString);

				// then
				assertEquals(1, paramAInt);
			}

			// @Test
			public void givenNullStringWhenConvertThenShouldReturnInvalidIntValue() {
				// given
				String paramAString = null;
				int INVALID_INT_VALUE = -999;

				// when
				int paramAInt = Problem.A.stringIntoInt(paramAString);

				// then
				assertEquals(INVALID_INT_VALUE, paramAInt);
			}
		}
	}

}
