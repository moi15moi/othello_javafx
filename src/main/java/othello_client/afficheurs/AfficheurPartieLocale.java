package othello_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import othello.enumerations.Couleur;
import othello.modeles.Grille.GrilleLectureSeule;
import othello.modeles.Jeton.JetonLectureSeule;
import othello_client.vues.VuePartieLocale;
import othello_javafx.controleurs.ControleurPrincipalFX;
import othello_javafx.modeles.PartieLocale.PartieLocaleLectureSeule;
import javafx.scene.paint.Color;

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
		
		if (ControleurPrincipalFX.getParametre().getNomJoueurUn() != null) {
			vue.afficherNomJoueurUn(ControleurPrincipalFX.getParametre().getNomJoueurUn());

		}
		if (ControleurPrincipalFX.getParametre().getNomJoueurDeux() != null) {
			vue.afficherNomJoueurDeux(ControleurPrincipalFX.getParametre().getNomJoueurDeux());
		}
		
		if (ControleurPrincipalFX.getParametre().getCouleurFondEcran() != null) {
			vue.changerCouleurFond(ControleurPrincipalFX.getParametre().getCouleurFondEcran());
		}
	
				
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
