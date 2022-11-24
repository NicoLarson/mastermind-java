package data_structure;

public class Jeton_indice extends Jeton {

	/*
	 * GREEN (0) = right color in the right place BLACK (1) = right color in the
	 * wrong place WHITE (2) = wrong
	 */
	private static final String[] USED_COLORS = { "GREEN", "BLACK", "WHITE" };

	/* Constructeurs */
	public Jeton_indice() {
	}

	/* A COMPLETER : ajouter un constructeur prenant un entier n - cf 2.2.1/d)/3. */
	public Jeton_indice(int n) {
		this._color = USED_COLORS[n];
	}
}
