package cmls.spring.codesmells.level.method;

/**
 * (Identificadores excesivamente largos)
 * 
 * Explicaci�n: Esto ocurre al hacer un uso inapropiado de las naming conventions para proveer desambig�acion.
 * 
 * Problema: Nombre excesivamente largo, en un contexto poco definido. 
 * 
 * Soluci�n: Renombramos la variable y el m�todo de acceso para que aporte valor por ambas partes. De esta forma
 * le estamos dando valor a la informaci�n de contexto y acortamos nombre al valor real que aporta la variable.
 * Asumimos que al saber que es la Casa Uno, ya estamos hablando de todo lo dem�s.
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
