# MASTERMIND

## Questions

### 2.2.1 Etape 1 : Les jetons

#### a) 2

#### b) Jeton <-- Jeton type 1

  <-- Jeton type 2

### 2.2.3 Etape 3 : Jeu sans interface graphique

#### c)

```
DEBUT
	Initialiser Row
 	Tentative = 0
 	Tant que Tentative < 10
  		Demander au joueur de saisir une combinaison
  		Comparer la combinaison saisie avec la combinaison secrète
  		Afficher le résultat de la comparaison
  		Si fonction succeed retourne true
   			Afficher le message de fin de partie
   			FIN
  		Sinon
   			Tentative ++
 	Fin Tant que
FIN
```