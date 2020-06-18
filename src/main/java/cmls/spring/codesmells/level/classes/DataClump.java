package cmls.spring.codesmells.level.classes;

/**
 * (Agrupado de datos)
 * 
 * Explicación: Es recomendable la agrupación de variables dentro de un objeto,
 * antes que pasar un grupo de variables que se pasan juntas en varias partes
 * del programa.
 * 
 * Problema: Encontramos varios métodos usando los mismos parametros, para poder
 * hacer sus evaluaciones, esto nos sugiere una refactorización.
 * 
 * Solución: Creamos un objeto que almacene todos los parametros, de forma que
 * sea más facil la translación de información.
 * 
 * @author Carlos Lozano
 *
 */
public class DataClump {

	static class Problem {

		static class A {

			public boolean itsMe(String name, String lastname, int age, char gender, boolean hasBabies) {
				System.out.println("name: " + name);
				System.out.println("lastname: " + lastname);
				System.out.println("age: " + age);
				System.out.println("gender: " + gender);
				System.out.println("hasBabies: " + hasBabies);

				return (name == "Carlos" && lastname == "Lozano" && age == 30 && gender == 'M' && hasBabies);
			}

			public boolean itsStephan(String name, String lastname, int age, char gender, boolean hasBabies) {
				System.out.println("name: " + name);
				System.out.println("lastname: " + lastname);
				System.out.println("age: " + age);
				System.out.println("gender: " + gender);
				System.out.println("hasBabies: " + hasBabies);

				return (name == "Stephan" && lastname == "Graham" && age == 40 && gender == 'M' && !hasBabies);
			}

			public boolean itsClara(String name, String lastname, int age, char gender, boolean hasBabies) {
				System.out.println("name: " + name);
				System.out.println("lastname: " + lastname);
				System.out.println("age: " + age);
				System.out.println("gender: " + gender);
				System.out.println("hasBabies: " + hasBabies);

				return (name == "Clara" && lastname == "Martinez" && age == 31 && gender == 'F' && hasBabies);
			}
		}

		public static void main(String args[]) {
			A a = new A();
			boolean resultItsme = a.itsMe("Carlos", "Lozano", 30, 'M', true);
			boolean resultItsmeWithStephan = a.itsMe("Stephan", "Graham", 40, 'M', false);
			boolean resultItsStephan = a.itsStephan("Stephan", "Graham", 40, 'M', false);
			boolean resultItsClara = a.itsClara("Clara", "Martinez", 31, 'F', true);

			System.out.println("resultItsme: " + resultItsme);
			System.out.println("resultItsmeWithStephan: " + resultItsmeWithStephan);
			System.out.println("resultItsStephan: " + resultItsStephan);
			System.out.println("resultItsClara: " + resultItsClara);
		}
	}

	static class Solution {
		static class Person {
			private String name;
			private String lastname;
			private int age;
			private char gender;
			private boolean hasBabies;

			Person(String name, String lastname, int age, char gender, boolean hasBabies) {
				this.name = name;
				this.lastname = lastname;
				this.age = age;
				this.gender = gender;
				this.hasBabies = hasBabies;
			}

			@Override
			public String toString() {
				return "Person [name=" + name + ", lastname=" + lastname + ", age=" + age + ", gender=" + gender
						+ ", hasBabies=" + hasBabies + "]";
			}
		}

		static class A {

			public boolean itsMe(Person person) {
				System.out.println("person: " + person);
				return (person.name == "Carlos" && person.lastname == "Lozano" && person.age == 30
						&& person.gender == 'M' && person.hasBabies);
			}

			public boolean itsStephan(Person person) {
				System.out.println("person: " + person);
				return (person.name == "Stephan" && person.lastname == "Graham" && person.age == 40 && person.gender == 'M' && !person.hasBabies);
			}

			public boolean itsClara(Person person) {
				System.out.println("person: " + person);
				return (person.name == "Clara" && person.lastname == "Martinez" && person.age == 31 && person.gender == 'F' && person.hasBabies);
			}
		}

		public static void main(String args[]) {
			A a = new A();

			Person carlos = new Person("Carlos", "Lozano", 30, 'M', true);
			Person stephan = new Person("Stephan", "Graham", 40, 'M', false);
			Person clara = new Person("Clara", "Martinez", 31, 'F', true);
			
			boolean resultItsme = a.itsMe(carlos);
			boolean resultItsmeWithStephan = a.itsMe(stephan);
			boolean resultItsStephan = a.itsStephan(stephan);
			boolean resultItsClara = a.itsClara(clara);

			System.out.println("resultItsme: " + resultItsme);
			System.out.println("resultItsmeWithStephan: " + resultItsmeWithStephan);
			System.out.println("resultItsStephan: " + resultItsStephan);
			System.out.println("resultItsClara: " + resultItsClara);
		}
	}

}
