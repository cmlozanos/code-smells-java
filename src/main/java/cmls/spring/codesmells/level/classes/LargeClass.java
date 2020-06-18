package cmls.spring.codesmells.level.classes;

/**
 * (Clase enorme)
 * 
 * Explicación: El tamaño de la clase es desmesurado. (Anti patron God Object)
 * 
 * Problema: Cuando tenemos una clase con múltiples operaciones, se hace dificil
 * entender las lógicas aplicadas a la misma, y además complica el hecho de
 * realizar modificaciones y tests sobre la misma.
 * 
 * Solución: Desacoplamos las funcionalidades, de forma que agrupamos en varios
 * operadores
 * 
 * @author Carlos Lozano
 *
 */
public class LargeClass {

	static class Problem {

		class Operator {
			private int numberA;
			private int numberB;
			private static final int INVALID_NUMBER = -9999;

			Operator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int sum() {
				return this.numberA + this.numberB;
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

			public int divideAByB() {
				return this.numberB == 0 ? Operator.INVALID_NUMBER : this.numberA / this.numberB;
			}

			public int divideBByA() {
				return this.numberA == 0 ? Operator.INVALID_NUMBER : this.numberB / this.numberA;
			}

			public int multiplyAByB() {
				return this.numberA * this.numberB;
			}

			public int multiplyBByA() {
				return this.numberB * this.numberA;
			}

			public int powAByB() {
				double doubleNumberA = Integer.valueOf(this.numberA).doubleValue();
				double doubleNumberB = Integer.valueOf(this.numberB).doubleValue();
				double doubleNumberPow = Math.pow(doubleNumberA, doubleNumberB);
				return Double.valueOf(doubleNumberPow).intValue();
			}

			public int powBByA() {
				double doubleNumberB = Integer.valueOf(this.numberB).doubleValue();
				double doubleNumberA = Integer.valueOf(this.numberA).doubleValue();
				double doubleNumberPow = Math.pow(doubleNumberB, doubleNumberA);
				return Double.valueOf(doubleNumberPow).intValue();
			}
		}
	}

	static class Solution {
		class SumOperator {
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

		class SubstractOperator {
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

		class DivideOperator {
			private int numberA;
			private int numberB;
			private static final int INVALID_NUMBER = -9999;

			DivideOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int divideAByB() {
				return this.numberB == 0 ? DivideOperator.INVALID_NUMBER : this.numberA / this.numberB;
			}

			public int divideBByA() {
				return this.numberA == 0 ? DivideOperator.INVALID_NUMBER : this.numberB / this.numberA;
			}
		}

		class MultiplyOperator {
			private int numberA;
			private int numberB;

			MultiplyOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int multiplyAByB() {
				return this.numberA * this.numberB;
			}

			public int multiplyBByA() {
				return this.numberB * this.numberA;
			}
		}

		class PowOperator {
			private int numberA;
			private int numberB;

			PowOperator(int numberA, int numberB) {
				this.numberA = numberA;
				this.numberB = numberB;
			}

			public int powAByB() {
				double doubleNumberA = Integer.valueOf(this.numberA).doubleValue();
				double doubleNumberB = Integer.valueOf(this.numberB).doubleValue();
				double doubleNumberPow = Math.pow(doubleNumberA, doubleNumberB);
				return Double.valueOf(doubleNumberPow).intValue();
			}

			public int powBByA() {
				double doubleNumberB = Integer.valueOf(this.numberB).doubleValue();
				double doubleNumberA = Integer.valueOf(this.numberA).doubleValue();
				double doubleNumberPow = Math.pow(doubleNumberB, doubleNumberA);
				return Double.valueOf(doubleNumberPow).intValue();
			}
		}

	}

}
