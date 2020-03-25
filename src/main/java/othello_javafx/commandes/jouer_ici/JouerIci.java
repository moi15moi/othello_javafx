package othello_javafx.commandes.jouer_ici;

import commun.debogage.J;
import commun_client.commandes.Commande;
import othello.enumerations.Couleur;

public class JouerIci extends Commande<JouerIciPourEnvoi, 
                                       JouerIciRecue> 

                      implements JouerIciPourEnvoi, 
                                 JouerIciRecue {
	
	private int indiceColonne;
	private int indiceLigne;
	private Couleur couleurCourante;

	@Override
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}
	
	@Override
	public void setIndiceLigne(int indiceLigne) {
		J.appel(this);

		this.indiceLigne = indiceLigne;
	}
	
	@Override
	public void setCouleurCourante(Couleur couleurCourante) {
		J.appel(this);
		
		this.couleurCourante = couleurCourante;
	}

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}

	@Override
	public int getIndiceLigne() {
		J.appel(this);

		return indiceLigne;
	}

	@Override
	public Couleur getCouleurCourante() {
		J.appel(this);
		
		return couleurCourante;
	}
}
