package cmls.spring.codesmells.level.application;

/**
 * (Complejidad controlada)
 * 
 * Explicaci�n: Hacer uso de patrones de dise�o de forma forzada donde una
 * soluci�n m�s simple ser�a suficiente.
 * 
 * Problema: Hacer uso del patron builder, para la declarativa de una clase de
 * un �nico parametro, no nos estar�a mejorando la forma en que este se
 * instancia, ya que no es requerido abstraer el proceso de creaci�n dada la
 * simplicidad del objeto.
 * 
 * Soluci�n: Aplicamos el principio KISS (Keep it simple stupid)
 * 
 * @author Carlos Lozano
 *
 */
public class ContrivedComplexity {

	class Problem {
		class A {
			int variableA;

			A(int variableA) {
				this.variableA = variableA;
			}
		}

		class ABuilder {
			int variableA;

			ABuilder() {
				variableA = 0;
			}

			void setVariableA(int variableA) {
				this.variableA = variableA;
			}

			A build() {
				return new A(variableA);
			}

		}
	}

	static class Solution {
		class A {
			int variableA;

			A(int variableA) {
				this.variableA = variableA;
			}
		}
	}

}
