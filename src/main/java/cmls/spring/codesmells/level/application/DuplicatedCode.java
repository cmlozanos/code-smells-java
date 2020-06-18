package cmls.spring.codesmells.level.application;

/**
 * (C�digo duplicado)
 * 
 * Explicaci�n: C�digo identico o similar en m�s de una ubicaci�n
 * 
 * Problema: Aunque los m�todos de las clases A y B se llamen diferentes,
 * encontramos la misma funcionalidad en ambos. Esto genera posibles problemas
 * en un futuro ya que ambos m�todos nos deber�an generar el mismo resultado.
 * 
 * Soluci�n: Refactorizamos el c�digo para unificar la funcionalidad.
 * 
 * @author Carlos Lozano
 *
 */
public class DuplicatedCode {

	class Problem {
		class A {
			int methodA(int paramA, int paramB) {
				return paramA + paramB;
			}
		}

		class B {
			int methodB(int paramA, int paramB) {
				return paramA + paramB;
			}

		}
	}

	static class Solution {
		class A {
			int methodA(int paramA, int paramB) {
				return C.methodC(paramA, paramB);
			}
		}

		class B {
			int methodB(int paramA, int paramB) {
				return C.methodC(paramA, paramB);
			}
		}

		static class C {
			static int methodC(int paramA, int paramB) {
				return paramA + paramB;
			}
		}
	}

}
