package othello_javafx.commandes.changer_nom_joueur_un;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class      ChangerNomJoueurUn 
       extends    Commande<ChangerNomJoueurUnPourEnvoi, ChangerNomJoueurUnRecue>
       implements ChangerNomJoueurUnPourEnvoi, ChangerNomJoueurUnRecue {
	
	private String nomJoueurUn;

	@Override
	public String getNomJoueurUn() {
		J.appel(this);
		
		return nomJoueurUn;
	}

	@Override
	public void setNomJoueurUn(String nomJoueurUn) {
		J.appel(this);
		
		this.nomJoueurUn = nomJoueurUn;
	}

}
