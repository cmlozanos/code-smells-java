package cmls.spring.codesmells.level.classes;

/**
 * (Caracteristicas envidiadas)
 * 
 * Explicación: La clase usa métodos de otra clase excesivamente
 * 
 * Problema: Cuando tenemos una clase que hace uso excesivo de métodos de otras
 * clases, pero no aporta funcionalidad.
 * 
 * Solución: Es preferible hacer uso de la clase final. Por lo que eliminamos la
 * clase intermedia y quitamos complejidad
 * 
 * @author Carlos Lozano
 *
 */
public class FeatureEnvy {

	static class Problem {

		static class SumOperator {
			private int numberA;
			private int numberB;

			SumOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int sum() {
				return this.numberA + this.numberB;
			}
		}

		static class SubstractOperator {
			private int numberA;
			private int numberB;

			SubstractOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int substractAMinusB() {
				return this.numberA - this.numberB;
			}

			public int substractBMinusA() {
				return this.numberB - this.numberA;
			}

			public int absoluteSubstract() {
				return this.numberA > 0 ? this.substractAMinusB() : this.substractBMinusA();
			}
		}

		static class A {
			private int numberA;
			private int numberB;

			A(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int sum() {
				return new SumOperator(this.numberA, this.numberB).sum();
			}

			public int substract() {
				return new SubstractOperator(this.numberA, this.numberB).absoluteSubstract();
			}

		}

		static class Main {
			public static void main(String args[]) {
				int numberA = 1;
				int numberB = 2;
				A a = new A(numberA, numberB);
				System.out.println("sum: " + a.sum());
				System.out.println("substract: " + a.substract());
			}
		}
	}

	static class Solution {

		static class SumOperator {
			private int numberA;
			private int numberB;

			SumOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int sum() {
				return this.numberA + this.numberB;
			}
		}

		static class SubstractOperator {
			private int numberA;
			private int numberB;

			SubstractOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int substractAMinusB() {
				return this.numberA - this.numberB;
			}

			public int substractBMinusA() {
				return this.numberB - this.numberA;
			}

			public int absoluteSubstract() {
				return this.numberA > 0 ? this.substractAMinusB() : this.substractBMinusA();
			}
		}

		static class Main {
			public static void main(String args[]) {
				int numberA = 1;
				int numberB = 2;
				System.out.println("sum: " + new SumOperator(numberA, numberB).sum());
				System.out.println("substract: " + new SubstractOperator(numberA, numberB).absoluteSubstract());
			}
		}
	}

}
