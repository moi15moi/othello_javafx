package othello_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import othello.enumerations.Couleur;
import othello.modeles.Partie.GrilleLectureSeule;
import othello.modeles.Partie.JetonLectureSeule;
import othello.modeles.Partie.PartieLectureSeule;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.vues.VuePartie;
import othello_client.vues.VuePartieLocale;
import othello_javafx.controleurs.ControleurPrincipalFX;
import javafx.scene.paint.Color;

public abstract class AfficheurPartie<PLS extends PartieLectureSeule, V extends VuePartie> extends Afficheur<PLS, V> {

	@Override
	public void initialiserAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);

		vue.creerGrille();
	}

	@Override
	public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
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

	private void rafraichirGrille(GrilleLectureSeule grille, V vue) {
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
