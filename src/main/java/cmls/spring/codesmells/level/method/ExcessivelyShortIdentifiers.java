package cmls.spring.codesmells.level.method;

/**
 * (Identificadores excesivamente largos)
 * 
 * Explicaci�n: El nombre debe reducirse al m�nimo cuyo significado siga siendo
 * valioso. Como bien indica las naming conventions.
 * 
 * Problema: Nombre excesivamente corto, en un contexto definido.
 * 
 * Soluci�n: Renombramos la variable y aclaramos el proposito de la variable.
 * 
 * @author Carlos Lozano
 *
 */
public class ExcessivelyShortIdentifiers {

	static class Problem {
		static class A {
			public void peopleWhoLivesIntoHouseNumberOne() {
				int i = 40;
			}
		}
	}

	static class Solution {
		static class A {
			public void peopleWhoLivesIntoHouseNumberOne() {
				int number = 40;
			}
		}
	}

}
