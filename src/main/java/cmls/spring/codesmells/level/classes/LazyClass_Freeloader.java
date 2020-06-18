package cmls.spring.codesmells.level.classes;

/**
 * (Clase perezosa o de ninguna responsabilidad)
 * 
 * Explicación: Dada una refactorización o varias, 
 * 
 * Problema: Encontramos declarado en la clase padre una funcionalidad getParamA
 * que en la clase hijo se ve sometida a un cambio total, por lo que lleva a
 * perder la funcionalidad heredada.
 * 
 * Solución: Eliminamos la clase, dada su nula aportación
 * 
 * @author Carlos Lozano
 *
 */
public class LazyClass_Freeloader {

	static class Problem {
		
		class BeforeRefactor_A {
			private int paramA;
			private int paramB;

			BeforeRefactor_A(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}

			public int sum() {
				return paramA + paramB;
			}

			public int divide() {
				return paramA / paramB;
			}
		}
		
		class AfterRefactor_A {
			private int paramA;
			private int paramB;

			AfterRefactor_A(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}

			public int sum() {
				return new AfterRefactor_SumA(paramA,paramB).apply();
			}

			public int divide() {
				return new AfterRefactor_DivideA(paramA,paramB).apply();
			}
		}
		class AfterRefactor_SumA {
			private int paramA;
			private int paramB;
			
			AfterRefactor_SumA(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}
			
			public int apply() {
				return paramA + paramB;
			}
		}
		
		class AfterRefactor_DivideA {
			private int paramA;
			private int paramB;
			
			AfterRefactor_DivideA(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}
			
			public int apply() {
				return paramA / paramB;
			}
		}
	}

	static class Solution {

		class SumA {
			private int paramA;
			private int paramB;
			
			SumA(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}
			
			public int apply() {
				return paramA + paramB;
			}
		}
		
		class DivideA {
			private int paramA;
			private int paramB;
			
			DivideA(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}
			
			public int apply() {
				return paramA / paramB;
			}
		}
	}

}
