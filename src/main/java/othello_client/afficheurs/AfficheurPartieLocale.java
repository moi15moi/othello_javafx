package othello_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import othello.enumerations.Couleur;
import othello.modeles.Grille.GrilleLectureSeule;
import othello.modeles.Jeton.JetonLectureSeule;
import othello_client.vues.VuePartieLocale;
import othello_javafx.modeles.PartieLocale.PartieLocaleLectureSeule;

public abstract class AfficheurPartieLocale<V extends VuePartieLocale>

		extends Afficheur<PartieLocaleLectureSeule, V> {

	@Override
	public void initialiserAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
		J.appel(this);

		vue.creerGrille();
	}

	@Override
	public void rafraichirAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
		J.appel(this);

		GrilleLectureSeule grille = partieLectureSeule.getGrille();

		rafraichirGrille(grille, vue);
		
		vue.joueurCourant(partieLectureSeule.getCouleurCourante());

	}

	private void rafraichirJoueurCourant(Couleur couleurCourante) {
		J.appel(this);
		

		
	}
	private void rafraichirGrille(GrilleLectureSeule grille, VuePartieLocale vue) {
		J.appel(this);

		JetonLectureSeule[][] jetons = grille.getJetons();
		boolean[][] coupPossible = grille.getCoupPossibles();
		
		for (int indiceColonne = 0; indiceColonne < jetons.length; indiceColonne++) {

			for (int indiceLigne = 0; indiceLigne < jetons[indiceColonne].length; indiceLigne++) {
				vue.cacherJeton(indiceColonne, indiceLigne);
				
				if (coupPossible[indiceColonne][indiceLigne]) {
					vue.afficherCoupPossible(indiceColonne, indiceLigne);
				}
				
				if (jetons[indiceColonne][indiceLigne] != null) {
					JetonLectureSeule jeton = jetons[indiceColonne][indiceLigne];
					Couleur couleur = jeton.getCouleur();
					vue.afficherJeton(indiceColonne, indiceLigne, couleur);
				}
			}

		}
		
	}
}
