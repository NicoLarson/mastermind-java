package bonus;

import data_structure.Jeton;
import data_structure.Jeton_couleur;
import data_structure.Jeton_indice;
import data_structure.Row;

public class BotIntelligent implements Joueur {

	public static CerveauBot[] cerveau = new CerveauBot[6];
	private int counter;
	public Row<Jeton_couleur> proposition;
	public Row<Jeton_couleur> oldProposition;

	public BotIntelligent() {
	}

	public void initCerveauBot() {
		CerveauBot red = new CerveauBot("RED");
		CerveauBot blue = new CerveauBot("BLUE");
		CerveauBot cyan = new CerveauBot("CYAN");
		CerveauBot yellow = new CerveauBot("YELLOW");
		CerveauBot magenta = new CerveauBot("MAGENTA");
		CerveauBot orange = new CerveauBot("ORANGE");
		cerveau[0] = red;
		cerveau[1] = blue;
		cerveau[2] = cyan;
		cerveau[3] = yellow;
		cerveau[4] = magenta;
		cerveau[5] = orange;
	}

	public void displayArrayCerveau() {
		for (CerveauBot jeton : cerveau) {
			System.out.println("Couleur : " + jeton.couleur);
			System.out.println("position : " + jeton.position);
			System.out.println("dejaJoue : " + jeton.dejaJoue);
			System.out.println("bonneCouleur : " + jeton.bonneCouleur);
			System.out.println("---------------------------");
		}
	}

	public void initProposition() {
		this.proposition = new Row<Jeton_couleur>();
		for (int i = 0; i < 4; ++i) {
			Jeton_couleur j = new Jeton_couleur("NONE");
			this.proposition.rowAdd(j);
		}
	}

	public void firstPlay() {
		this.initProposition();
		this.proposition.rowSet(new Jeton_couleur(0), 0);
		this.proposition.rowSet(new Jeton_couleur(1), 1);
		this.proposition.rowSet(new Jeton_couleur(2), 2);
		this.proposition.rowSet(new Jeton_couleur(3), 3);
		cerveau[0].dejaJoue = true;
		cerveau[1].dejaJoue = true;
		cerveau[2].dejaJoue = true;
		cerveau[3].dejaJoue = true;
	}

	public Jeton_couleur proposerJeton() {
		Jeton_couleur j = new Jeton_couleur();

		for (int i = 0; i < 5; i++) {
			if (cerveau[i].dejaJoue == false && !cerveau[i].bonneCouleur) {
				cerveau[i].dejaJoue = true;
				return new Jeton_couleur(i);
			}
		}

		boolean bonneCouleur = false;
		while (bonneCouleur == false) {
			Jeton_couleur newJeton = new Jeton_couleur();
			for (int i = 0; i < 5; i++) {
				if (newJeton._color == cerveau[i].couleur && cerveau[i].bonneCouleur == true) {
					bonneCouleur = true;
					return newJeton;
				}
			}
		}
		return j;
	}

	public void setProposition(Row<Jeton_couleur> oldProposition, Row<Jeton_indice> indice) {
		this.oldProposition = oldProposition;

		for (int i = 0; i < 4; i++) {
			if (indice.rowGet(i).toString() == "GREEN") {
				this.proposition.rowSet(this.oldProposition.rowGet(i), i);
				for (CerveauBot jeton : cerveau) {
					if (oldProposition.rowGet(i)._color == jeton.couleur) {
						jeton.position = true;
						jeton.bonneCouleur = true;
						jeton.dejaJoue = true;
					}
				}
			} else if (indice.rowGet(i).toString() == "BLACK") {
				for (CerveauBot jeton : cerveau) {
					if (oldProposition.rowGet(i)._color == jeton.couleur) {
						jeton.position = false;
						jeton.bonneCouleur = true;
						jeton.dejaJoue = true;
					}
				}
				this.proposition.rowSet(proposerJeton(), i);
			} else if (indice.rowGet(i).toString() == "WHITE") {
				for (CerveauBot jeton : cerveau) {
					if (oldProposition.rowGet(i)._color == jeton.couleur) {
						jeton.bonneCouleur = false;
						jeton.dejaJoue = true;
					}
				}
				this.proposition.rowSet(proposerJeton(), i);
			}
		}
	}

	@Override
	public void setProposition() {
		this.proposition = new Row<Jeton_couleur>();
		for (int i = 0; i < 4; ++i) {
			Jeton_couleur j = new Jeton_couleur();
			this.proposition.rowAdd(j);
		}
	}

	@Override
	public void setProposition(Row<Jeton_indice> indice) {
		// TODO Auto-generated method stub

	}

}
