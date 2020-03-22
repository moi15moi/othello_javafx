package othello_javafx.commandes.jouer_ici;

import commun_client.commandes.CommandeRecue;

public interface JouerIciRecue extends CommandeRecue {
	
	int getIndiceColonne();
	int getIndiceLigne();
}
