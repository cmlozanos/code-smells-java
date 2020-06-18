package cmls.spring.codesmells.level.method;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * (Demasiados parametros)
 * 
 * Explicación: Una lista excesiva de parametros dificulta el testing y es
 * indicativo de multiproposito, lo que nos hace pensar que debería ser
 * refactorizada
 * 
 * Problema: Encontramos el método de calcular precio, el cual tiene en cuenta
 * tanto los impuestos del pais como los atributos de la persona así como los
 * valores de los articulos. Esto nos sugiere que debe ser refactorizado el
 * método en distintas etapas.
 * 
 * Solución: Refactorizamos el método para separar las responsabilidades.
 * 
 * 1.- Separamos el cálculo de precio de todos los articulos
 * 
 * 2.- Separamos el cálculo de impuestos para el precio de todos los articulos
 * 
 * 3.- Separamos la funcionalidad que determina si aplica impuestos o no en base
 * a ser premium.
 *
 * 
 * @author Carlos Lozano
 *
 */
public class TooManyParameters {

	static class Problem {
		static class Article {
			public String name;
			public Double unitPrice;

			public Article(String name, Double unitPrice) {
				super();
				this.name = name;
				this.unitPrice = unitPrice;
			}

		}

		static class Country {
			public String name;
			public int tax;

			public Country(String name, int tax) {
				super();
				this.name = name;
				this.tax = tax;
			}

		}

		static class Person {
			public String name;
			public boolean premium;

			public Person(String name, boolean premium) {
				super();
				this.name = name;
				this.premium = premium;
			}

		}

		static class A {
			public Double calculatePrice(List<Article> articles, Country country, Person person) {
				double totalPrice = articles.stream().mapToDouble(a -> a.unitPrice).sum();
				if (person.premium) {
					return totalPrice;
				}
				double taxes = totalPrice * country.tax / 100;
				return totalPrice + taxes;
			}

			public static void main(String args[]) {
				Person carlos = new Person("Carlos", true);
				Person lara = new Person("Lara", false);
				Country spain = new Country("Spain", 21);
				Article car = new Article("car", 10000D);
				Article motorcicle = new Article("motorcicle", 8000D);
				List<Article> articles = Stream.of(car, motorcicle).collect(Collectors.toList());

				Double priceForCarlos = new A().calculatePrice(articles, spain, carlos);
				Double priceForLara = new A().calculatePrice(articles, spain, lara);
				System.out.println("priceForCarlos: " + priceForCarlos);
				System.out.println("priceForLara: " + priceForLara);
			}
		}
	}

	static class Solution {
		static class Article {
			public String name;
			public Double unitPrice;

			public Article(String name, Double unitPrice) {
				super();
				this.name = name;
				this.unitPrice = unitPrice;
			}

		}

		static class Country {
			public String name;
			public int tax;

			public Country(String name, int tax) {
				super();
				this.name = name;
				this.tax = tax;
			}

		}

		static class Person {
			public String name;
			public boolean premium;

			public Person(String name, boolean premium) {
				super();
				this.name = name;
				this.premium = premium;
			}

		}

		static class A {
			public Double priceAllArticles(List<Article> articles) {
				return articles.stream().mapToDouble(a -> a.unitPrice).sum();
			}

			public Double pricePlusTaxes(double price, int tax) {
				return price + (price * tax * 100);
			}

			public Double priceByPremium(boolean premium, Double price, Double priceWithTaxes) {
				return premium ? price : priceWithTaxes;
			}

			public static void main(String args[]) {
				Person carlos = new Person("Carlos", true);
				Person lara = new Person("Lara", false);
				Country spain = new Country("Spain", 21);
				Article car = new Article("car", 10000D);
				Article motorcicle = new Article("motorcicle", 8000D);
				List<Article> articles = Stream.of(car, motorcicle).collect(Collectors.toList());

				A a = new A();
				Double price = a.priceAllArticles(articles);
				Double pricePlusTaxes = a.pricePlusTaxes(price, spain.tax);

				Double priceForCarlos = a.priceByPremium(carlos.premium, price, pricePlusTaxes);
				Double priceForLara = a.priceByPremium(lara.premium, price, pricePlusTaxes);

				System.out.println("priceForCarlos: " + priceForCarlos);
				System.out.println("priceForLara: " + priceForLara);
			}
		}
	}

}
