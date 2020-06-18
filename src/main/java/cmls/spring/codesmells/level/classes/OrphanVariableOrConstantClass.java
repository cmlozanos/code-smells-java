package cmls.spring.codesmells.level.classes;

/**
 * (Variable huerfana o Clase de constantes)
 * 
 * Explicaci�n: Las constantes declaradas deben estar en la clase de su uso.
 * 
 * Problema: Tenemos una clase de constantes, que es consultada por una clase
 * externa.
 * 
 * Soluci�n: Dado su uso, deber�a estar en la clase que realiza la misma
 * funcionalidad. Esto simplifica la legibilidad del c�digo al tener que
 * consultar a una �nica clase.
 * 
 * @author Carlos Lozano
 *
 */
public class OrphanVariableOrConstantClass {

	static class Problem {

		static class Constants {
			public static final int INITIAL = 1;
			public static final int FINAL = 10;
		}

		static class A {
			public boolean isInitialOrFinal(int number) {
				return number == Constants.INITIAL || number == Constants.FINAL;
			}
		}

		public static void main(String args[]) {
			A a = new A();
			for (int i = 0; i <= 10; i++) {
				boolean initialOrFinal = a.isInitialOrFinal(1);
				System.out.println("i: " + i + " initialOrFinal: " + initialOrFinal);
			}
		}
	}

	static class Solution {
		static class A {
			public static final int INITIAL = 1;
			public static final int FINAL = 10;

			public boolean isInitialOrFinal(int number) {
				return number == INITIAL || number == FINAL;
			}
		}

		public static void main(String args[]) {
			A a = new A();
			for (int i = 0; i <= 10; i++) {
				boolean initialOrFinal = a.isInitialOrFinal(1);
				System.out.println("i: " + i + " initialOrFinal: " + initialOrFinal);
			}
		}
	}

}
