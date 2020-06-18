package cmls.spring.codesmells.level.method;

import java.util.Optional;

/**
 * (Excesivo uso de retornos de valor)
 * 
 * Explicación: Una funcion que retorna en más de 7 casos, genera más de 7 casos
 * de escape del método, lo que implica tener que determinar cual es la salida
 * correcta de la ejecución.
 * 
 * Problema: Tenemos un método con múltiples líneas, que provoca la lectura en
 * su totalidad para saber que valor retornará
 * 
 * Solución: Separamos las funcionalidades y le damos valor de contexto a cada
 * posible salida, de forma que aportemos más información de lo que está
 * ocurriendo.
 * 
 * @author Carlos Lozano
 *
 */
public class ExcessiveReturnOfData {

	static class Problem {
		static class A {
			public int peopleWhoLivesIntoHouseNumberOne(int numberOfCases) {
				if (numberOfCases == 1) {
					return 10;
				}
				if (numberOfCases == 4) {
					return 17;
				}
				if (numberOfCases == 14) {
					return 12;
				}
				if (numberOfCases == 19) {
					return 11;
				}
				if (numberOfCases == 20) {
					return 22;
				}
				if (numberOfCases == 34) {
					return 52;
				}
				if (numberOfCases == 36) {
					return 56;
				}
				if (numberOfCases == 54) {
					return 42;
				}
				if (numberOfCases == 60) {
					return 62;
				}
				if (numberOfCases == 56) {
					return 66;
				}
				return 99;
			}
		}
	}

	static class Solution {
		static class A {
			public Optional<Integer> peopleWhoLivesIntoHouseNumberOneCasesEqualLower10(int numberOfCases) {
				if (numberOfCases == 1) {
					return Optional.of(10);
				}
				if (numberOfCases == 4) {
					return Optional.of(17);
				}
				return Optional.empty();
			}

			public Optional<Integer> peopleWhoLivesIntoHouseNumberOneCasesEqualLower20(int numberOfCases) {
				if (numberOfCases == 14) {
					return Optional.of(12);
				}
				if (numberOfCases == 19) {
					return Optional.of(11);
				}
				if (numberOfCases == 20) {
					return Optional.of(22);
				}
				return Optional.empty();
			}

			public Optional<Integer> peopleWhoLivesIntoHouseNumberOneCasesEqualLower40(int numberOfCases) {
				if (numberOfCases == 34) {
					return Optional.of(52);
				}
				if (numberOfCases == 36) {
					return Optional.of(56);
				}
				return Optional.empty();
			}

			public Optional<Integer> peopleWhoLivesIntoHouseNumberOneCasesEqualLower50(int numberOfCases) {
				if (numberOfCases == 54) {
					return Optional.of(42);
				}
				if (numberOfCases == 56) {
					return Optional.of(66);
				}
				return Optional.empty();
			}

			public Optional<Integer> peopleWhoLivesIntoHouseNumberOneCasesEqualLower60(int numberOfCases) {
				if (numberOfCases == 60) {
					return Optional.of(62);
				}
				return Optional.empty();
			}

			public int peopleWhoLivesIntoHouseNumberOne(int numberOfCases) {
				Optional<Integer> lower10 = peopleWhoLivesIntoHouseNumberOneCasesEqualLower10(numberOfCases);
				if (lower10.isPresent()) {
					return lower10.get();
				}
				Optional<Integer> lower20 = peopleWhoLivesIntoHouseNumberOneCasesEqualLower20(numberOfCases);
				if (lower20.isPresent()) {
					return lower20.get();
				}
				Optional<Integer> lower40 = peopleWhoLivesIntoHouseNumberOneCasesEqualLower40(numberOfCases);
				if (lower40.isPresent()) {
					return lower40.get();
				}
				Optional<Integer> lower50 = peopleWhoLivesIntoHouseNumberOneCasesEqualLower50(numberOfCases);
				if (lower50.isPresent()) {
					return lower50.get();
				}
				Optional<Integer> lower60 = peopleWhoLivesIntoHouseNumberOneCasesEqualLower60(numberOfCases);
				if (lower60.isPresent()) {
					return lower60.get();
				}

				return 99;
			}
		}
	}

}
