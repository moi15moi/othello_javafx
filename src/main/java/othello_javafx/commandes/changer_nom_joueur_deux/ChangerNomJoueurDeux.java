package othello_javafx.commandes.changer_nom_joueur_deux;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class      ChangerNomJoueurDeux 
       extends    Commande<ChangerNomJoueurDeuxPourEnvoi, ChangerNomJoueurDeuxRecue>
       implements ChangerNomJoueurDeuxPourEnvoi, ChangerNomJoueurDeuxRecue {
	
	private String nomJoueurDeux;

	@Override
	public String getNomJoueurDeux() {
		J.appel(this);
		
		return nomJoueurDeux;
	}

	@Override
	public void setNomJoueurDeux(String nomJoueurDeux) {
		J.appel(this);
		
		this.nomJoueurDeux = nomJoueurDeux;
	}

}
