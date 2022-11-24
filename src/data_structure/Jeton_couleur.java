package data_structure;

import java.awt.Color;
//PlayPegs subclass of Pegs
import java.util.*;

public class Jeton_couleur extends Jeton {

	/*** ATTRIBUTS STATIQUES ***/
	private static Color[] colors = { Color.red, Color.blue, Color.cyan, Color.yellow, Color.MAGENTA, Color.orange };
	private static ArrayList<String> USED_COLORS = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("RED");
			add("BLUE");
			add("CYAN");
			add("YELLOW");
			add("MAGENTA");
			add("ORANGE");
		}
	};

	/*** METHODES ***/

	/* Constructeurs */
	// Ne touchez pas � ce constructeur
	public Jeton_couleur(String s) {
	}

	/*
	 * A COMPLETER : ajouter un constructeur vide initialisant le jeton avec une
	 * couleur al�atoire de l'attribut USED_COLORS - cf 2.2.1/e)/3.
	 */
	public Jeton_couleur() {
		Random r = new Random();
		int i = r.nextInt(USED_COLORS.size());
		this._color = USED_COLORS.get(i);
	}

	/*
	 * A COMPLETER : ajouter un constructeur prenant un entier en entr�e, et
	 * initialisant l'attribut _color avec la couleur de USED_COLORS correspondante
	 * - cf 2.2.1/e)/4.
	 */
	public Jeton_couleur(int i) {
		this._color = USED_COLORS.get(i);
	}

	/* Getters */
	/* A COMPLETER */
	/* Ajoutez deux getters : getUSED_COLORS et getColors - cf 2.2.1/e)/5. et 6. */
	public static ArrayList<String> getUSED_COLORS() {
		return USED_COLORS;
	}

	public static Color[] getColors() {
		return colors;
	}
	/* Autres */

	// Cette m�thode renvoi l'indice de colors correspondant � la couleur pass�e en
	// param�tre
	// Ne touchez pas � cette fonction
	public static int colorToInt(Color c) {
		int i = 0;
		for (Color elem : Jeton_couleur.colors) {
			if (elem.equals(c)) {
				return i;
			}
			i++;
		}
		System.out.println("Erreur de saisie!");
		return -1;
	}

	/*
	 * M�thode evaluation Cette m�thode renvoi : - GREEN (0) si le jeton � la m�me
	 * valeur que le jeton de solutionGagnante � la position pos - BLACK (1) si le
	 * jeton � la m�me valeur que n'importe quel autre jeton de solutionGagnante -
	 * WHITE (2) sinon
	 */

	public Jeton_indice evaluation(Row solutionGagnante, int pos) {
		/* A COMPLETER - cf 2.2.2/e) */
		Boolean bonneValeurEtBonnePosition = false;
		Boolean bonneValeurEtMauvaisePosition = false;
		for (int i = 0; i < solutionGagnante.rowGet().size(); i++) {
			if (solutionGagnante.rowGet(i).equals(this) && i == pos) {
				bonneValeurEtBonnePosition = true;
			} else if (solutionGagnante.rowGet(i).equals(this)) {
				bonneValeurEtMauvaisePosition = true;
			}
		}
		if (bonneValeurEtBonnePosition) {
			return new Jeton_indice(0);
		} else if (bonneValeurEtMauvaisePosition) {
			return new Jeton_indice(1);
		} else {
			return new Jeton_indice(2);
		}
	}
}
