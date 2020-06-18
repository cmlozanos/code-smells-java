package cmls.spring.codesmells.level.classes;

/**
 * (Casting hacia abajo)
 * 
 * Explicación: Puede romper el modelo de abstracción. La abstracción puede ser
 * eliminada. Podemos tener problemas de casting
 * 
 * Problema: Se plantean los dos siguientes problemas, hacer un upcasting y
 * downcasting sobre B y A, y otro problema que viene de hacer un upcasting
 * sobre C y A y un downcasting sobre A y B
 * 
 * Solución: Ante el primer problema, la solución tornará en los naming, de
 * forma que a la hora de hacer la herencia no estemos sobreescribiendo los
 * valores (Refused bequest smell), de esta forma garantizamos que no haya
 * pérdida de información. Ante el segundo problema, debemos hacer un check para
 * comprobar si el objeto a downcastear es de este tipo de instancia.
 * 
 * 
 * *** Upcasting: Casting hacia la clase padre
 * 
 * *** Refused bequest: Rechazo de los origenes
 * 
 * @author Carlos Lozano
 *
 */
public class DownCasting {

	static class Problem {

		static abstract class A {
			public int number = 1;
		}

		static class B extends A {
			public int number = 2;
		}

		static class C extends A {
			public int number = 3;
		}

		public static void main(String args[]) {

			A a = new B();
			B b = (B) a;
			System.out.println("a: " + a.number + " b: " + b.number); // a = 1; b = 2

			A a2 = new C();
			B b2 = (B) a2; // Exception of Class Cast Exception
		}
	}

	static class Solution {
		static abstract class A {
			public int number = 1;
		}

		static class B extends A {
			public int numberB = 2;
		}

		static class C extends A {
			public int numberC = 3;
		}

		public static void main(String args[]) {

			A a = new B();
			B b = (B) a;
			System.out.println("a: " + a.number + " b: " + b.number + " b: " + b.numberB); // a = 2; b = 2

			A a2 = new C();
			if (a2 instanceof B) { // Check instance of Class
				B b2 = (B) a2;
				System.out.println("a2: " + a2.number + " b2: " + b2.number + " b2: " + b2.numberB); // never happened
																										// because
																										// initial class
																										// is C
			} else {
				System.out.println("invalid casting");
			}
		}
	}

}
