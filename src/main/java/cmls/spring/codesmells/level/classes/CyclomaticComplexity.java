package cmls.spring.codesmells.level.classes;

/**
 * (Complejidad ciclom�tica)
 * 
 * Explicaci�n: Demasiadas ramas o b�cles. Esto puede indicar que una funci�n
 * necesita ser descompuesta en funciones m�s peque�as o que es una funci�n con
 * potencial para ser simplificada.
 * 
 * Problema: Anidamiento excesivo en los bucles, lo que dificulta la lectura
 * 
 * Soluci�n: Simplificamos los bucles para su desacoplamiento.
 * 
 * @author Carlos Lozano
 *
 */
public class CyclomaticComplexity {

	static class Problem {

		class A {
			private static final String NO = "No";
			private static final String YES = "Yes";

			public String isMammalian(int paramA) {
				if (paramA > 0) { // level 1
					if (paramA > 1) { // level 2
						if (paramA > 2) { // level 3
							if (paramA > 3) { // level 4
								if (paramA > 4) { // level 5
									return NO;
								} else if (paramA == 4) { // level 5-6
									return YES;
								}
							} else if (paramA == 3) {
								return YES;
							}
						} else if (paramA == 2) {
							return NO;
						}
					} else if (paramA == 1) {
						return YES;
					}
				} else if (paramA == 0) {
					return YES;
				}
				return NO;
			}
		}
	}

	static class Solution {
		class A {
			private static final String NO = "No";
			private static final String YES = "Yes";

			public String isMammalian(int paramA) {
				if (paramA == 0) {
					return YES;
				}
				if (paramA == 1) {
					return YES;
				}
				if (paramA == 2) {
					return YES;
				}
				if (paramA == 3) {
					return YES;
				}
				if (paramA == 4) {
					return YES;
				}
				return NO;
			}
		}
	}

}
