package cmls.spring.codesmells.level.method;

/**
 * (Identificadores excesivamente largos)
 * 
 * Explicación: Esto ocurre al hacer un uso inapropiado de las naming conventions para proveer desambigüacion.
 * 
 * Problema: Nombre excesivamente largo, en un contexto poco definido. 
 * 
 * Solución: Renombramos la variable y el método de acceso para que aporte valor por ambas partes. De esta forma
 * le estamos dando valor a la información de contexto y acortamos nombre al valor real que aporta la variable.
 * Asumimos que al saber que es la Casa Uno, ya estamos hablando de todo lo demás.
 * 
 * @author Carlos Lozano
 *
 */
public class ExcessivelyLongIdentifiers {

	static class Problem {
		static class A {
			public void method() {
				int numberOfPersonsThatLivesIntoHouseNumberOneThatIsOutOfCountryAndItsAllowedToLive= 40;
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
