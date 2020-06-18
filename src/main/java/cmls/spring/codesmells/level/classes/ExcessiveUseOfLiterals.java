package cmls.spring.codesmells.level.classes;

/**
 * (Uso excesivo de literales)
 * 
 * Explicación: Los literales deben ser codificados como constantes para mejorar
 * la legibilidad. Adicionalmente los literales pueden ser externalizados dentro
 * de ficheros de recursos u otro tipo de almacenamiento, como base de datos,
 * donde sea posible.
 * 
 * Problema: Dentro de la clase A encontramos una cantidad de literales
 * desmesurada sin especificar unos genericos.
 * 
 * Solución: Extraemos los literales a constante, de modo adicional, en este
 * ejemplo, podemos darle significado a los literales int.
 * 
 * @author Carlos Lozano
 *
 */
public class ExcessiveUseOfLiterals {

	static class Problem {

		class A {
			public String isMammalian(int paramA) {
				switch (paramA) {
				case 0:
					return "Yes";
				case 1:
					return "Yes";
				case 2:
					return "No";
				case 3:
					return "No";
				case 4:
					return "Yes";
				case 5:
					return "Yes";
				default:
					return "No";
				}
			}
		}
	}

	static class Solution {
		class A {
			private static final int FOX = 0;
			private static final int PRIMATE = 1;
			private static final int SHARK = 2;
			private static final int DELFIN = 3;
			private static final int URSIDAE = 4;
			private static final int ROEDOR = 5;
			
			private static final String NO = "No";
			private static final String YES = "Yes";

			public String isMammalian(int paramA) {
				switch (paramA) {
				case FOX:
					return YES;
				case PRIMATE:
					return YES;
				case SHARK:
					return NO;
				case DELFIN:
					return NO;
				case URSIDAE:
					return YES;
				case ROEDOR:
					return YES;
				default:
					return NO;
				}
			}
		}
	}

}
