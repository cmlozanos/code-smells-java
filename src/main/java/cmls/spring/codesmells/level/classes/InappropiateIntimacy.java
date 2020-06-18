package cmls.spring.codesmells.level.classes;

/**
 * (Intimidad inapropiada)
 * 
 * Explicaci�n: Esto ocurre cuando una clase tiene dependencias en los detalles de implementaci�n
 * de otra clase
 * 
 * Problema: Encontramos l�gica pura de la clase A dentro de la clase relaccionada C, lo que indica que
 * no requiere saber nada de C para poder construir el resultado. Esto nos lleva a pensar que el m�todo
 * est� en el lugar inadecuado.
 * 
 * Soluci�n: Refactorizamos el m�todo para llevarlo a la clase que tiene su responsabilidad
 * 
 * @author Carlos Lozano
 *
 */
public class InappropiateIntimacy {

	static class Problem {

		class A {
			private int paramA;
			private int paramB;
			private C paramC;
			
			A (int paramA, int paramB, C paramC) {
				this.paramA = paramA;
				this.paramB = paramB;
				this.paramC = paramC;
			}
			public int getParamA() {
				return paramA;
			}
			public int getParamB() {
				return paramB;
			}
			public C getParamC() {
				return paramC;
			}
			
			public int getParamCResult () {
				return paramC.getResult();
			}
		}
		class C {
			private A paramA;
			private int paramB;
			
			C (A paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}
			public A getParamA() {
				return paramA;
			}
			public int getParamB() {
				return paramB;
			}
			
			public int getResult() {
				return this.paramA.getParamA() * this.paramA.getParamB();
			}
		}
	}

	static class Solution {

		class A {
			private int paramA;
			private int paramB;
			private C paramC;
			
			A (int paramA, int paramB, C paramC) {
				this.paramA = paramA;
				this.paramB = paramB;
				this.paramC = paramC;
			}
			public int getParamA() {
				return paramA;
			}
			public int getParamB() {
				return paramB;
			}
			public C getParamC() {
				return paramC;
			}
			
			public int getParamCResult () {
				return this.paramA * this.paramB;
			}
		}
		class C {
			private A paramA;
			private int paramB;
			
			C (A paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}
			public A getParamA() {
				return paramA;
			}
			public int getParamB() {
				return paramB;
			}
		}
	}

}
