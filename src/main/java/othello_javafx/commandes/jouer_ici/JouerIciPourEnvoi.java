package othello_javafx.commandes.jouer_ici;

import commun_client.commandes.CommandePourEnvoi;
import othello.enumerations.Couleur;

public interface JouerIciPourEnvoi extends CommandePourEnvoi { 
	
	void setIndiceColonne(int indiceColonne);
	void setIndiceLigne(int indiceLigne);
	void setCouleurCourante(Couleur couleurCourante);
	int getIndiceColonne();
}
