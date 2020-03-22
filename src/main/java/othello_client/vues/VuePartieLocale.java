package othello_client.vues;

import commun_client.mvc.Vue;
import othello.enumerations.Couleur;

public interface VuePartieLocale extends Vue {

	void creerGrille(int largeur, int hauteur);
	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);

}
