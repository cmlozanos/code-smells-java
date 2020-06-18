package cmls.spring.codesmells.level.application;

/**
 * (Código duplicado)
 * 
 * Explicación: Código identico o similar en más de una ubicación
 * 
 * Problema: Aunque los métodos de las clases A y B se llamen diferentes,
 * encontramos la misma funcionalidad en ambos. Esto genera posibles problemas
 * en un futuro ya que ambos métodos nos deberían generar el mismo resultado.
 * 
 * Solución: Refactorizamos el código para unificar la funcionalidad.
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
