package cmls.spring.codesmells.level.application;

/**
 * (Variables mutables)
 * 
 * Explicación: Es complicado realizar una refactorización para las variables
 * que pueden ser mutadas
 * 
 * Problema: Cuando hacemos un llamado al metodo pintar, este reasigna el valor
 * por lo que termina pintando otro valor
 * 
 * Solución: Deberíamos hacer las variables inmutables, de esta forma nos
 * aseguramos que aunque operemos con los valores nunca sobreescribimos el valor
 * inicial, para ello nos apoyamos en las variables finales
 * 
 * @author Carlos Lozano
 *
 */
public class VariableMutations {

	static class Problem {
		static class A {
			static void main(String[] args) {
				String value = "a";
				operateWithValue(value);
				System.out.println(value);
			}

			static void operateWithValue(String paramA) {
				paramA = "b";
			}
		}
	}

	static class Solution {
		static class A {
			static void main(String[] args) {
				final String value = "a";
				final String newValue = operateWithValue(value);
				System.out.println(value);
				System.out.println(newValue);
			}

			static String operateWithValue(final String paramA) {
				return "b";
			}
		}
	}

}
