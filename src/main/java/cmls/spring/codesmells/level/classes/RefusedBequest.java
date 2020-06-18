package cmls.spring.codesmells.level.classes;

/**
 * (Rechazo de origenes)
 * 
 * Explicaci�n: Una clase que sobreescribe un m�todo de la clase base de forma
 * que el contrato con la clase base no es honrado por la clase derivada (Liskov
 * Substitution Principle LSP)
 * 
 * Problema: Encontramos declarado en la clase padre una funcionalidad getParamA
 * que en la clase hijo se ve sometida a un cambio total, por lo que lleva a
 * perder la funcionalidad heredada.
 * 
 * Soluci�n: O bien generamos un nuevo m�todo a ser llamado, para no eliminar el
 * origen o bien hacemos una llamada interna a la clase padre. En este caso,
 * parece que la soluci�n m�s concreta podr�a ser la soluci�n 2.
 * 
 * @author Carlos Lozano
 *
 */
public class RefusedBequest {

	static class Problem {

		class A {
			private int paramA;
			private int paramB;

			A(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}

			public int getParamA() {
				return paramA;
			}

			public int getParamB() {
				return paramB;
			}
		}

		class B extends A {

			B(int paramA, int paramB) {
				super(paramA, paramB);
			}

			@Override
			public int getParamA() {
				return this.getParamB();
			}
		}
	}

	static class Solution1 {

		class A {
			private int paramA;
			private int paramB;

			A(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}

			public int getParamA() {
				return paramA;
			}

			public int getParamB() {
				return paramB;
			}
		}

		class B extends A {

			B(int paramA, int paramB) {
				super(paramA, paramB);
			}

			@Override
			public int getParamA() {
				super.getParamA();
				return this.getParamB();
			}
		}
	}

	static class Solution2 {

		class A {
			private int paramA;
			private int paramB;

			A(int paramA, int paramB) {
				this.paramA = paramA;
				this.paramB = paramB;
			}

			public int getParamA() {
				return paramA;
			}

			public int getParamB() {
				return paramB;
			}
		}

		class B extends A {

			B(int paramA, int paramB) {
				super(paramA, paramB);
			}

			public int getNewParamA() {
				return this.getParamB();
			}
		}
	}

}
