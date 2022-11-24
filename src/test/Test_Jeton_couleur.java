package test;

import data_structure.Jeton_couleur;
import data_structure.Jeton_indice;
import data_structure.Row;

public class Test_Jeton_couleur {
	/* METHODE DE TEST, NE TOUCHER PAS AU CODE CI-DESSOUS */
    public static void main(String[] args) {
		System.out.println("*** Tests de la classe Jeton_couleur ***");
    	System.out.println("***** DEBUT DU TEST *****");
    	Jeton_couleur hazard = new Jeton_couleur();
    	Jeton_couleur vide = new Jeton_couleur("vide");
    	Jeton_couleur bleu = new Jeton_couleur(1);
    	Row<Jeton_couleur> sol = new Row<Jeton_couleur>();
    	sol.rowAdd(new Jeton_couleur(1));
    	sol.rowAdd(new Jeton_couleur(0));
    	
    	
    	//TEST1
    	if(!vide._color.equals("NONE"))
    		System.err.println("TEST1 : un Jeton_couleur construit avec le constructeur prenant un String en argument doit avoir comme valeur \"NONE\" dans son attribut _color (gr�ce � l'appel au constructeur parent)");
    	
    	//TEST1bis
    	if(!bleu._color.equals("BLUE"))
    		System.err.println("TEST1bis : un Jeton_couleur construit avec le constructeur prenant en entr�e un int doit avoir comme valeur le String dans la case de USED_COLORS ayant le int comme indice");
    	
    	//TEST1bisbis
    	boolean contains = false;
    	for(String elem : Jeton_couleur.getUSED_COLORS()) {
    		if(elem.equals(hazard._color)) {
    			contains = true;
    		}
    	}
    	if(!contains)
    		System.err.println("TEST1bisbis : un Jeton_couleur construit avec le constructeur ne prenant aucun argument doit obtenir une valeur al�atoire (gr�ce � Random) parmi les valeurs du tableau USED_COLORS");
    	
    	//TEST2
    	if(!bleu.evaluation(sol,0).equals(new Jeton_indice(0))) {
    		System.err.println("TEST2 : la m�thode evaluation doit renvoyer un Jeton_indice \"GREEN\" en cas d'�quivalence avec le jeton situ� � la position pos de la ligne ligneGagnante");
    		System.err.println("Jeton_indice renvoy� : "+bleu.evaluation(sol,0));
    	}
    	
    	//TEST3
    	if(!bleu.evaluation(sol,1).equals(new Jeton_indice(1))) {
    		System.err.println("TEST3 : la m�thode evaluation doit renvoyer un Jeton_indice \"BLACK\" en cas d'�quivalence avec un jeton de la ligne ligneGagnante (quelque soit sa position)");
    		System.err.println("Jeton_indice renvoy� : "+bleu.evaluation(sol,1));
    	}
    	
    	//TEST4
    	if(!vide.evaluation(sol,1).equals(new Jeton_indice(2))) {
    		System.err.println("TEST4 : la m�thode evaluation doit renvoyer un Jeton_indice \"WHITE\" en cas de non-�quivalence avec un jeton de la ligne ligneGagnante");
    		System.err.println("Jeton_indice renvoy� : "+vide.evaluation(sol,1));
    	}
    	System.out.println("***** FIN DU TEST *****");
    }
}
