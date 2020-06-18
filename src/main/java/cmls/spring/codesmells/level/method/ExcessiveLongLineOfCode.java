package cmls.spring.codesmells.level.method;

import java.util.stream.Stream;

/**
 * (Linea de código excesivamente grande)
 * 
 * Explicación: Una linea que es excesivamente larga, complica la legibilidad y
 * los casos de prueba asociados.
 * 
 * Problema: Tenemos una línea que realiza múltiples operaciones y no separa las funcionalidades.
 * 
 * Solución: Separamos logicas de creación, filtrado, construcción y resultado
 * 
 * @author Carlos Lozano
 *
 */
public class ExcessiveLongLineOfCode {

	static class Problem {
		static class A {
			public void method() {
				int result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(e -> e > 5).map(e -> e * 10)
						.map(e -> e / 100).map(e -> e * 99 / 100 + 300 / 100 * 30 * 500).map(e -> e * 50)
						.mapToInt(e -> e).sum();
			}
		}
	}

	static class Solution {
		static class A {
			public void method() {
				Stream<Integer> values = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Stream<Integer> valuesFiltered = values.filter(e -> e > 5);
				Stream<Integer> computeValues = valuesFiltered.map(e -> e * 10)
						.map(e -> e / 100).map(e -> e * 99 / 100 + 300 / 100 * 30 * 500).map(e -> e * 50);
				int result = computeValues
						.mapToInt(e -> e).sum();
			}
		}
	}

}
