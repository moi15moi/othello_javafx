package othello_serveur;

import commun.debogage.J;
import static othello_javafx.Constantes.*;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() {
		J.appel(Principal.class);
		
		ServeurOthello serveur = new ServeurOthello(PORT);
		serveur.start();
	}

}
