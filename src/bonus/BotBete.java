package bonus;

import data_structure.Jeton_couleur;
import data_structure.Jeton_indice;
import data_structure.Row;

public class BotBete implements Joueur {

  public Row<Jeton_couleur> proposition;

  public void setProposition() {
    this.proposition = new Row<Jeton_couleur>();
    for (int i = 0; i < 4; ++i) {
      Jeton_couleur j = new Jeton_couleur();
      this.proposition.rowAdd(j);
    }
  }

  @Override
  public void setProposition(Row<Jeton_indice> indice) {
  }
}
