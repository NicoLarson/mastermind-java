package test;

import data_structure.Jeton;
import data_structure.Jeton_indice;

public class Test_Jeton_Jeton_indice {
	/* METHODE DE TEST, NE TOUCHER PAS AU CODE CI-DESSOUS */
	public static void main(String[] args) {
		System.out.println("*** Tests des classes Jeton et Jeton_indice ***");
		System.out.println("***** DEBUT DU TEST *****");
		Jeton_indice vide = new Jeton_indice();
		Jeton_indice vert = new Jeton_indice(0);

		// TEST1
		if (!vide._color.equals("NONE"))
			System.err.println(
					"TEST1 : un Jeton construit avec le constructeur vide doit avoir comme valeur \"NONE\" dans son attribut _color");

		// TEST2
		if (vide.equals(vert) != vide._color.equals(vert._color))
			System.err.println("TEST2 : la m�thode de comparaison ne retourne pas le r�sultat voulu");

		// TEST3
		if (!vide.toString().equals(vide._color))
			System.err.println("TEST3 : la m�thode toString ne renvoi pas de String �gal � son attribut _color");

		// TEST4
		if (!vide.toStringCentered().equals(" " + vide._color + "  "))
			System.err.println(
					"TEST4 : la m�thode toStringCentered ne renvoi pas de String de 7 caract�res ayant des espaces pour centrer la valeur de l'attribut _color");

		// TEST5
		if (!Jeton.toStringCentered("GREEN").equals(vert.toStringCentered())) {
			System.err.println(
					"TEST5 : la m�thode toStringCentered ne renvoi pas de String de 7 caract�res ayant des espaces pour centrer la valeur de l'attribut _color");
			System.err.println(
					"\t|" + Jeton.toStringCentered("GREEN") + "| different de |" + vert.toStringCentered() + "|");
		}

		// TEST6
		if (!vert._color.equals("GREEN"))
			System.err.println(
					"TEST6 : un Jeton_indice construit avec le constructeur doit avoir comme valeur d'attribut _color la valeur pass�e en argument");
		System.out.println("***** FIN DU TEST *****");
	}
}
