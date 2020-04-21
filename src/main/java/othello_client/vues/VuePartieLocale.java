package othello_client.vues;

import commun_client.mvc.Vue;
import othello.enumerations.Couleur;

public interface VuePartieLocale extends Vue {

	void creerGrille();

	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);
	
	void afficherCoupPossible(int indiceColonne, int indiceRangee);

	void cacherJeton(int indiceColonne, int indiceRangee);
	
	void joueurCourant(Couleur couleurCourante);
	
	void afficherNomJoueurUn(String nomJoueurUn);

}
