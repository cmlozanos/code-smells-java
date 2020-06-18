package cmls.spring.codesmells.level.application;

/**
 * (Soluci�n a escopetazos)
 * 
 * Explicaci�n: Ocurre cuando un �nico cambio, provoca cambios de comportamiento
 * a m�ltiples clases
 * 
 * Problema: Una vez refactorizada la clase A, nos encontramos con que el m�todo
 * "validation" encierra el comportamiento necesario para la valoraci�n inicial,
 * pero ahora nos surge el siguiente problema, queremos modificar el
 * comportamiento de validaci�n para el m�todoB pero no queremos modificar el
 * comportamiento para el m�todoA
 * 
 * Soluci�n: Nos obliga a refactorizar de nuevo para poder separar los m�todos
 * de validaci�n
 * 
 * @author Carlos Lozano
 *
 */
public class ShotgunSurgery {

	class Problem {
		class A {
			String methodA(int paramA) {
				if (paramA > 5) {
					return "bigger than 5";
				}
				return "lower or equal to 5";
			}

			int methodB(int paramA, int paramB, int paramC) {
				if (paramA > 5) {
					return paramB;
				}
				return paramC;
			}
		}

		class RefactorizedA {
			String methodA(int paramA) {
				if (validation(paramA)) {
					return "bigger than 5";
				}
				return "lower or equal to 5";
			}

			int methodB(int paramA, int paramB, int paramC) {
				if (validation(paramA)) {
					return paramB;
				}
				return paramC;
			}

			boolean validation(int paramA) {
				return paramA > 5;
			}
		}
	}

	static class Solution {
		class SecondRefactorizedA {
			String methodA(int paramA) {
				if (validationA(paramA)) {
					return "bigger than 5";
				}
				return "lower or equal to 5";
			}

			int methodB(int paramA, int paramB, int paramC) {
				if (validationB(paramA)) {
					return paramB;
				}
				return paramC;
			}

			boolean validationA(int paramA) {
				return paramA > 5;
			}

			boolean validationB(int paramA) {
				return paramA > 5 && paramA < 10;
			}
		}
	}

}
