package bonus;

import data_structure.Jeton_couleur;
import data_structure.Jeton_indice;
import data_structure.Row;

public class BotIntelligent implements Joueur {

  private Row<Jeton_indice> indice;
  private int counter;
  public Row<Jeton_couleur> proposition;
  public Row<Jeton_couleur> oldProposition;

  public BotIntelligent(Row<Jeton_couleur> oldProposition, int counter, Row<Jeton_indice> indice) {
    this.oldProposition = oldProposition;
    this.indice = indice;
    this.counter = counter;
  }

  public void setProposition(Row<Jeton_indice> indice) {
    String[] indiceCouleurWhite = new String[4];
    String[] indiceCouleurBlack = new String[4];

    for (int i = 0; i < 4; i++) {
      if (indice.rowGet(i).toString() == "WHITE") {
        indiceCouleurWhite[i] = "WHITE";
      } else {
        indiceCouleurWhite[i] = "NONE";
      }
    }
    for (int i = 0; i < 4; i++) {
      if (indice.rowGet(i).toString() == "BLACK") {
        indiceCouleurBlack[i] = "BLACK";
      } else {
        indiceCouleurBlack[i] = "NONE";
      }
    }

    this.proposition = this.oldProposition;
    for (int i = 0; i < 4; ++i) {
      if (this.indice.rowGet(i).toString() == "GREEN") {
        this.proposition.rowSet(this.oldProposition.rowGet(i), i);
      } else if (this.indice.rowGet(i).toString() == "WHITE") {
        Jeton_couleur j = new Jeton_couleur();
        this.proposition.rowSet(j, i);
      } else if (this.indice.rowGet(i).toString() == "BLACK") {
        Jeton_couleur j = new Jeton_couleur();
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

}
