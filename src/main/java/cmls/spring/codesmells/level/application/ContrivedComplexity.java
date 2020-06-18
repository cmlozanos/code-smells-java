package cmls.spring.codesmells.level.application;

/**
 * (Complejidad controlada)
 * 
 * Explicación: Hacer uso de patrones de diseño de forma forzada donde una
 * solución más simple sería suficiente.
 * 
 * Problema: Hacer uso del patron builder, para la declarativa de una clase de
 * un único parametro, no nos estaría mejorando la forma en que este se
 * instancia, ya que no es requerido abstraer el proceso de creación dada la
 * simplicidad del objeto.
 * 
 * Solución: Aplicamos el principio KISS (Keep it simple stupid)
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
