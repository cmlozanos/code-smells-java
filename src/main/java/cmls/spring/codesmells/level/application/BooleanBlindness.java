package cmls.spring.codesmells.level.application;

/**
 * (Ceguera booleana)
 * 
 * Explicaci�n: Un booleano es casi siempre la opci�n equivocada, ya que
 * requerimos saber su procedencia para poder saber su valor real.
 * 
 * Problema: Cuando hacemos un casting y el compilador no entiende su
 * funcionalidad ya que igualmente le obligaremos a hacer un downcasting en la
 * siguiente l�nea
 * 
 * Soluci�n: Delegamos la funcionalidad del m�todo plus a las clases
 * correspondientes, de esta forma evitamos el downcasting y la funcionalidad
 * queda recogida por su propietario
 * 
 * @author Carlos Lozano
 *
 */
public class BooleanBlindness {

	static class Problem {

		interface Num {
		}

		class Zero implements Num {
		}

		class Succ implements Num {
			public final Num pred;

			public Succ(Num pred) {
				this.pred = pred;
			}
		}

		/**
		 * Aqu� instanceof devuelve un booleano (comentario (1)), pero no lleva ninguna
		 * informaci�n sobre lo que ese booleano representa (es decir, que x es una
		 * instancia de Succ), as� que cuando llegamos a la siguiente l�nea (2) estamos
		 * obligado a hacer un cast inseguro. El programador sabe que est� a salvo del
		 * contexto, pero el compilador no.
		 * 
		 * @param x
		 * @param y
		 * @return
		 */
		Num plus(Num x, Num y) {
			if (x instanceof Succ) { // (1)
				Succ xAsSucc = (Succ) x; // (2)
				return new Succ(plus(xAsSucc.pred, y));
			} else {
				return y;
			}
		}
	}

	static class Solution {
		interface Num {
			Num plus(Num other);
		}

		class Zero implements Num {
			public Num plus(Num number) {
				return number;
			}
		}

		class Succ implements Num {
			public final Num pred;

			public Succ(Num pred) {
				this.pred = pred;
			}

			public Num plus(Num number) {
				return new Succ(pred.plus(number));
			}

		}
	}

}
