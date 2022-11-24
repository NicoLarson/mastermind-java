package test;

import data_structure.Jeton_couleur;
import data_structure.Jeton_indice;
import data_structure.Row;

public class Test_Row {
	/* METHODE DE TEST, NE TOUCHER PAS AU CODE CI-DESSOUS */
    public static void main(String[] args){
    	System.out.println("*** Tests de la classe Row ***");
    	System.out.println("***** DEBUT DU TEST *****");
    	Row<Jeton_couleur> test = new Row<Jeton_couleur>();
    	
    	//TEST1
    	if(test.rowGet().size() != 0)
    		System.err.println("TEST1 : Le constructeur de Row doit instancier une ArrayList vide dans l'attribut row");
    	
    	//TEST2
    	test.rowAdd(new Jeton_couleur(0));
    	test.rowAdd(new Jeton_couleur(1));
    	if(!test.contains(new Jeton_couleur(0)))
    		System.err.println("TEST2 : La m�thode contains doit renvoyer vrai si l'�l�ment est pr�sent dans row");
    	
    	//TEST3
    	if(test.contains(new Jeton_couleur(2)))
    		System.err.println("TEST3 : La m�thode contains doit renvoyer faux si l'�l�ment n'est pas pr�sent dans row");
    	
    	//TEST4
    	Row<Jeton_couleur> testbis = new Row<Jeton_couleur>();
    	testbis.rowAdd(new Jeton_couleur(0));
    	testbis.rowAdd(new Jeton_couleur(1));
    	if(!test.equals(testbis))
    		System.err.println("TEST4 : La m�thode equals doit renvoyer VRAI si les deux Row contiennent les m�mes valeurs");
    	
    	//TEST5
    	test.rowAdd(new Jeton_couleur(2));
    	testbis.rowAdd(new Jeton_couleur(3));
    	if(test.equals(testbis))
    		System.err.println("TEST5 : La m�thode equals doit renvoyer FAUX si les deux Row contiennent au moins une valeur diff�rente");
    	
    	//TEST6
    	if(!test.toString().equals("|  RED  | BLUE  | CYAN  |")) {
    		System.err.println("TEST6 : La m�thode toString doit renvoyer les valeurs les une � la suite des autres centr�es avec des espaces et s�par�s par un \"|\"");
    		System.err.println(test.toString());
    		System.err.println("Diff�rent de\n|  RED  | BLUE  | CYAN  |");
    	}
    	
    	//TEST7
    	if(!test.toStringSelect(1).equals("|  RED  |   x   | CYAN  |")) {
    		System.err.println("TEST7 : La m�thode toStringSelect doit renvoyer les valeurs les une � la suite des autres centr�es avec des espaces et s�par�s par un \"|\", avec un x entour� de 3 espaces de chaque cot�, pour remplacer la valeur de la position pass�e en argument");
    		System.err.println(test.toStringSelect(1));
    		System.err.println("Diff�rent de\n|  RED  |   x   | CYAN  |");
    	}
    	
    	//TEST8
    	if(!test.rowGet(1).equals(new Jeton_couleur(1))) {
    		System.err.println("TEST8 : La methode rowGet doit retourner le Jeton_couleur situ� � la position donn�e en argument");
    		System.err.println("R�sultat souhait� : BLUE");
    		System.err.println("R�sultat obtenu :   "+test.rowGet(1));
    	}
    	
    	//TEST9
    	test.rowAdd(new Jeton_couleur(0));
    	test.rowSet(new Jeton_couleur(3),2);
    	testbis.rowGet().add(new Jeton_couleur(0));
    	if(!test.equals(testbis)) {
    		System.err.println("TEST9 : La methode rowAdd doit ajouter dans l'attribut row le nouvel �l�ment");
    		System.err.println("R�sultat souhait� : "+test);
    		System.err.println("R�sultat obtenu :   "+testbis);
    	}
    	
    	//TEST10
    	test.rowSet(new Jeton_couleur(0),2);
    	testbis.rowGet().set(2, new Jeton_couleur(0));
    	if(!test.equals(testbis)) {
    		System.err.println("TEST10 : La methode rowAdd doit ajouter dans l'attribut row le nouvel �l�ment");
    		System.err.println("R�sultat souhait� : "+test);
    		System.err.println("R�sultat obtenu :   "+testbis);
    	}
    	
    	//TEST11
    	test.rowSet(new Jeton_couleur(0),2);
    	testbis.rowGet().set(2, new Jeton_couleur("vide"));
    	if(!test.complete())
    		System.err.println("TEST11 : La methode complete doit renvoyer VRAI si la Row contient 4 Jetons ayant une couleur diff�rente de \"NONE\"");
    	
    	if(testbis.complete())
    		System.err.println("TEST11bis : La methode complete doit renvoyer FAUX si la Row ne contient pas 4 Jetons ayant une couleur diff�rente de \"NONE\"");
    	
    	testbis.rowGet().remove(2);
    	if(testbis.complete())
    		System.err.println("TEST11bisbis : La methode complete doit renvoyer FAUX si la Row ne contient pas 4 Jetons ayant une couleur diff�rente de \"NONE\"");
    	
    	//TEST12
    	Row<Jeton_couleur> prop = new Row<Jeton_couleur>();
    	prop.rowAdd(new Jeton_couleur(0));
    	prop.rowAdd(new Jeton_couleur(0));
    	prop.rowAdd(new Jeton_couleur(1));
    	prop.rowAdd(new Jeton_couleur(3));
    	
    	Row<Jeton_indice> indices = new Row<Jeton_indice>();
    	indices.rowAdd(new Jeton_indice(0));
    	indices.rowAdd(new Jeton_indice(1));
    	indices.rowAdd(new Jeton_indice(1));
    	indices.rowAdd(new Jeton_indice(2));
    	if(!indices.equals(test.computeSoluce(prop))) {
    		System.err.println("TEST12 : La methode computeSoluce doit renvoyer une Row contenant des Jeton_indice : \"GREEN\" si les deux cases sont identiques, \"BLACK\" si la case contient un �l�ment pr�sent dans la solution, \"WHITE\" sinon.");
    		System.err.println("R�sultat souhait� : "+indices);
    		System.err.println("R�sultat obtenu :   "+test.computeSoluce(prop));
    	}
    	
    	//TEST13
    	if(indices.succeed()) {
    		System.err.println("TEST13 : La methode succeed doit renvoyer FAUX si la Row n'est pas remplie de Jeton_indice \"GREEN\"");
    	}
    	
    	//TEST14
    	for(int x = 0;x < 4;++x) {
    		indices.rowSet(new Jeton_indice(0), x);
    	}
    	if(!indices.succeed()) {
    		System.err.println("TEST14 : La methode succeed doit renvoyer VRAI si la Row est remplie de Jeton_indice \"GREEN\"");
    	}
    	
    	System.out.println("***** FIN DU TEST *****");
    }
}
