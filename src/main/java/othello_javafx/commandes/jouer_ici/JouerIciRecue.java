package othello_javafx.commandes.jouer_ici;

import commun_client.commandes.CommandeRecue;
import othello.enumerations.Couleur;

public interface JouerIciRecue extends CommandeRecue {
	
	int getIndiceColonne();
	int getIndiceLigne();
	Couleur getCouleurCourante();
}
