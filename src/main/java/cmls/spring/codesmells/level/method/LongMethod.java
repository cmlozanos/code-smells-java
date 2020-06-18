package cmls.spring.codesmells.level.method;

/**
 * (Metodo largo)
 * 
 * Explicaci�n: Ocurre cuando un m�todo es m�s grande de la cuenta, lo que
 * dificulta su lectura
 * 
 * Problema: Tenemos un metodo que pasa de las 7 l�neas de c�digo por lo que nos
 * obliga a hacer una lectura inmersiva para poder trazar bien el
 * comportamiento.
 * 
 * Soluci�n: Separamos los comportamientos en m�todos m�s peque�os. A la hora de
 * separar en varios m�todos es posible que incurramos en el (Large class code
 * smell) dado que separamos en m�ltiples trozos y esto nos obliga a generar
 * nuevos m�todos con lo que sumamos l�neas de codificaci�n.
 *
 * 
 * @author Carlos Lozano
 *
 */
public class LongMethod {

	static class Problem {
		static class A {
			public void method() {
				int number = 40;
				int number10percent = number * 10 / 100;
				double random = Math.random();
				double randomBy10percentOfNumber = random * number10percent;
				System.out.println("Loggin random number: " + random);
				System.out.println("Loggin random number By 10 percent of Number: " + randomBy10percentOfNumber);
				double result;
				if (random > 10) {
					int numberByNumber10Percent = number * number10percent;
					result = numberByNumber10Percent / randomBy10percentOfNumber;
				} else {
					if (random == 10) {
						int numberByNumber10Percent = number * number10percent;
						result = random / numberByNumber10Percent;
					} else {
						double numberByRandom = number * random;
						result = random / numberByRandom;
					}
				}
				double resultBy10Percent = result * 10 / 100;
				double totalResult = result + resultBy10Percent;
				double taxes = 0.21;
				double totalResultPlusTaxes = totalResult * taxes;
				System.out.println("totalResultPlusTaxes: " + totalResultPlusTaxes);
			}
		}
	}

	static class Solution {
		static class A {
			public void method() {
				double result = computeResult();
				printResultPlusTaxes(result);
			}

			private double computeResult() {
				int number = 40;
				int number10percent = number * 10 / 100;
				double random = Math.random();
				double randomBy10percentOfNumber = random * number10percent;
				System.out.println("Loggin random number: " + random);
				System.out.println("Loggin random number By 10 percent of Number: " + randomBy10percentOfNumber);
				return getResult(number, number10percent, random, randomBy10percentOfNumber);
			}

			private double getResult(int number, int number10percent, double random, double randomBy10percentOfNumber) {
				if (random > 10) {
					int numberByNumber10Percent = number * number10percent;
					return numberByNumber10Percent / randomBy10percentOfNumber;
				}

				if (random == 10) {
					int numberByNumber10Percent = number * number10percent;
					return random / numberByNumber10Percent;
				}

				double numberByRandom = number * random;
				return random / numberByRandom;
			}

			private void printResultPlusTaxes(double result) {
				double resultBy10Percent = result * 10 / 100;
				double totalResult = result + resultBy10Percent;
				double taxes = 0.21;
				double totalResultPlusTaxes = totalResult * taxes;
				System.out.println("totalResultPlusTaxes: " + totalResultPlusTaxes);
			}

		}
	}

}
