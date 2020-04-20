package othello_javafx.modeles.PartieLocale;

import commun.debogage.J;
import commun.modeles.Modele;
import javafx.scene.paint.Color;
import othello.enumerations.Couleur;
import othello.modeles.Grille.Grille;
import othello.modeles.Grille.GrilleLectureSeule;
import static othello_javafx.Constantes.*;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {

	private Couleur couleurCourante = Couleur.NOIR;

	private Grille grille;

	public PartieLocale() {
		J.appel(this);

		grille = new Grille();
	}

	public void jouerIci(int indiceColonne, int indiceLigne) {
		J.appel(this);

		effectuerCoup(indiceColonne, indiceLigne);
	}

	public void effectuerCoup(int indiceColonne, int indiceLigne) {
		J.appel(this);

		grille.ajouterJeton(indiceColonne, indiceLigne, couleurCourante);

		calculerChangementJeton(indiceColonne, indiceLigne);

		prochaineCouleur();

		calculerCoupPossible();
	}

	public void calculerChangementJeton(int indiceColonne, int indiceLigne) {

		if (siPossibleJouerGauche(indiceColonne, indiceLigne)) {
			int JetonMemeCouleur = siPossibleJouerGaucheTrouverJetonMemeCouleur(indiceColonne, indiceLigne);

			for (int j = indiceLigne - 1; j > JetonMemeCouleur; j--) {

				grille.ajouterJeton(indiceColonne, j, couleurCourante);
			}

		}

		if (siPossibleJouerDroite(indiceColonne, indiceLigne)) {
			int JetonMemeCouleur = siPossibleJouerDroiteTrouverJetonMemeCouleur(indiceColonne, indiceLigne);

			for (int j = indiceLigne + 1; j < JetonMemeCouleur; j++) {
				grille.ajouterJeton(indiceColonne, j, couleurCourante);
			}
		}

		if (siPossibleJouerHaut(indiceColonne, indiceLigne)) {
			int JetonMemeCouleur = siPossibleJouerHautTrouverJetonMemeCouleur(indiceColonne, indiceLigne);

			for (int j = indiceColonne - 1; j > JetonMemeCouleur; j--) {
				grille.ajouterJeton(j, indiceLigne, couleurCourante);
			}
		}

		if (siPossibleJouerBas(indiceColonne, indiceLigne)) {
			int JetonMemeCouleur = siPossibleJouerBasTrouverJetonMemeCouleur(indiceColonne, indiceLigne);

			for (int j = indiceColonne + 1; j < JetonMemeCouleur; j++) {
				grille.ajouterJeton(j, indiceLigne, couleurCourante);
			}
		}
		if (siPossibleJouerDiagonaleHautGauche(indiceColonne, indiceLigne)) {
			int[] JetonMemeCouleur = siPossibleJouerDiagonaleHautGaucheTrouverJetonMemeCouleur(indiceColonne,
					indiceLigne);

			int i_indiceColonneVerifAutreJeton = indiceColonne - 1, i_indiceLigneVerifAutreJeton = indiceLigne - 1;
			while (i_indiceColonneVerifAutreJeton > JetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton > JetonMemeCouleur[1]) {
				grille.ajouterJeton(i_indiceColonneVerifAutreJeton, i_indiceLigneVerifAutreJeton, couleurCourante);

				i_indiceColonneVerifAutreJeton--;
				i_indiceLigneVerifAutreJeton--;
			}

		}

		if (siPossibleJouerDiagonaleHautDroite(indiceColonne, indiceLigne)) {
			int[] JetonMemeCouleur = siPossibleJouerDiagonaleHautDroiteTrouverJetonMemeCouleur(indiceColonne,
					indiceLigne);

			int i_indiceColonneVerifAutreJeton = indiceColonne - 1, i_indiceLigneVerifAutreJeton = indiceLigne + 1;
			while (i_indiceColonneVerifAutreJeton > JetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton < JetonMemeCouleur[1]) {

				grille.ajouterJeton(i_indiceColonneVerifAutreJeton, i_indiceLigneVerifAutreJeton, couleurCourante);

				i_indiceColonneVerifAutreJeton--;
				i_indiceLigneVerifAutreJeton++;
			}
		}

		if (siPossibleJouerDiagonaleBasGauche(indiceColonne, indiceLigne)) {
			int[] JetonMemeCouleur = siPossibleJouerDiagonaleBasGaucheTrouverJetonMemeCouleur(indiceColonne,
					indiceLigne);

			int i_indiceColonneVerifAutreJeton = indiceColonne + 1, i_indiceLigneVerifAutreJeton = indiceLigne - 1;
			while (i_indiceColonneVerifAutreJeton < JetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton > JetonMemeCouleur[1]) {

				grille.ajouterJeton(i_indiceColonneVerifAutreJeton, i_indiceLigneVerifAutreJeton, couleurCourante);

				i_indiceColonneVerifAutreJeton++;
				i_indiceLigneVerifAutreJeton--;
			}
		}

		if (siPossibleJouerDiagonaleBasDroite(indiceColonne, indiceLigne)) {
			int[] JetonMemeCouleur = siPossibleJouerDiagonaleBasDroiteTrouverJetonMemeCouleur(indiceColonne,
					indiceLigne);

			int i_indiceColonneVerifAutreJeton = indiceColonne + 1, i_indiceLigneVerifAutreJeton = indiceLigne + 1;
			while (i_indiceColonneVerifAutreJeton < JetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton < JetonMemeCouleur[1]) {

				grille.ajouterJeton(i_indiceColonneVerifAutreJeton, i_indiceLigneVerifAutreJeton, couleurCourante);

				i_indiceColonneVerifAutreJeton++;
				i_indiceLigneVerifAutreJeton++;
			}
		}

	}

	private void prochaineCouleur() {
		J.appel(this);

		switch (couleurCourante) {

		case BLANC:
			couleurCourante = Couleur.NOIR;
			break;
		case NOIR:
			couleurCourante = Couleur.BLANC;
			break;
		}
	}

	public Couleur getCouleurNonCourante() {
		J.appel(this);
		Couleur couleurNonCourante = null;
		switch (couleurCourante) {

		case BLANC:
			couleurNonCourante = Couleur.NOIR;
			break;
		case NOIR:
			couleurNonCourante = Couleur.BLANC;
			break;
		}

		return couleurNonCourante;
	}

	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}

	public void setCouleurCourante(Couleur couleurCourante) {
		J.appel(this);
		this.couleurCourante = couleurCourante;
	}

	public GrilleLectureSeule getGrille() {
		// //J.appel(this);
		return (GrilleLectureSeule) grille;
	}

	public void setGrille(Grille grille) {
		J.appel(this);
		this.grille = grille;
	}

	public void calculerCoupPossible() {
		J.appel(this);

		for (int indiceColonne = 0; indiceColonne < this.grille.getJetons().length; indiceColonne++) {

			for (int indiceLigne = 0; indiceLigne < this.grille.getJetons()[indiceColonne].length; indiceLigne++) {

				boolean siPossibleJouerIci = false;

				if (getGrille().getJetons()[indiceColonne][indiceLigne] == null) {
					if (siPossibleJouerGauche(indiceColonne, indiceLigne)
							|| siPossibleJouerDroite(indiceColonne, indiceLigne)
							|| siPossibleJouerHaut(indiceColonne, indiceLigne)
							|| siPossibleJouerBas(indiceColonne, indiceLigne)
							|| siPossibleJouerDiagonaleHautGauche(indiceColonne, indiceLigne)
							|| siPossibleJouerDiagonaleHautDroite(indiceColonne, indiceLigne)
							|| siPossibleJouerDiagonaleBasGauche(indiceColonne, indiceLigne)
							|| siPossibleJouerDiagonaleBasDroite(indiceColonne, indiceLigne)) {
						siPossibleJouerIci = true;
					}

				}

				grille.ajouterCoupPossible(indiceColonne, indiceLigne, siPossibleJouerIci);
			}
		}
	}

	private int siPossibleJouerGaucheTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int indiceLigneProchainJetonMemeCouleur = -1;
		for (int i = indiceLigne - 2; i >= 0 && indiceLigneProchainJetonMemeCouleur == -1; i--) {
			if (getGrille().getJetons()[indiceColonne][i] != null
					&& getGrille().getJetons()[indiceColonne][i].getCouleur().equals(getCouleurCourante())) {

				indiceLigneProchainJetonMemeCouleur = i;
			}
		}

		return indiceLigneProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerGauche(int indiceColonne, int indiceLigne) {
		J.appel(this);

		boolean trouveJetonInvalide = true;

		int indiceLigneProchainJetonMemeCouleur = siPossibleJouerGaucheTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);

		if (indiceLigneProchainJetonMemeCouleur != -1) {
			trouveJetonInvalide = false;
			for (int j = indiceLigne - 1; j > indiceLigneProchainJetonMemeCouleur && !trouveJetonInvalide; j--) {

				if (getGrille().getJetons()[indiceColonne][j] == null
						|| !getGrille().getJetons()[indiceColonne][j].getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;

				}
			}
		}

		return !trouveJetonInvalide;
	}

	private int siPossibleJouerDroiteTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int indiceLigneProchainJetonMemeCouleur = -1;

		for (int i = indiceLigne + 2; i <= getGrille().getJetons()[indiceColonne].length - 1
				&& indiceLigneProchainJetonMemeCouleur == -1; i++) {
			if (getGrille().getJetons()[indiceColonne][i] != null) {

				if (getGrille().getJetons()[indiceColonne][i] != null
						&& getGrille().getJetons()[indiceColonne][i].getCouleur().equals(getCouleurCourante())) {

					indiceLigneProchainJetonMemeCouleur = i;
				}
			}
		}

		return indiceLigneProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerDroite(int indiceColonne, int indiceLigne) {
		J.appel(this);

		boolean trouveJetonInvalide = true;
		int indiceLigneProchainJetonMemeCouleur = siPossibleJouerDroiteTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);

		if (indiceLigneProchainJetonMemeCouleur != -1) {
			trouveJetonInvalide = false;
			for (int j = indiceLigne + 1; j < indiceLigneProchainJetonMemeCouleur && !trouveJetonInvalide; j++) {
				if (getGrille().getJetons()[indiceColonne][j] == null
						|| !getGrille().getJetons()[indiceColonne][j].getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}
			}
		}
		return !trouveJetonInvalide;
	}

	private int siPossibleJouerHautTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int indiceColonneProchainJetonMemeCouleur = -1;

		for (int i = indiceColonne - 2; i >= 0 && indiceColonneProchainJetonMemeCouleur == -1; i--) {

			if (getGrille().getJetons()[i][indiceLigne] != null) {

				if (getGrille().getJetons()[i][indiceLigne].getCouleur().equals(getCouleurCourante())) {

					indiceColonneProchainJetonMemeCouleur = i;
				}
			}
		}

		return indiceColonneProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerHaut(int indiceColonne, int indiceLigne) {
		J.appel(this);

		boolean trouveJetonInvalide = true;
		int indiceLigneProchainJetonMemeCouleur = siPossibleJouerHautTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);

		if (indiceLigneProchainJetonMemeCouleur != -1) {
			trouveJetonInvalide = false;
			for (int j = indiceColonne - 1; j > indiceLigneProchainJetonMemeCouleur && !trouveJetonInvalide; j--) {

				if (getGrille().getJetons()[j][indiceLigne] == null
						|| !getGrille().getJetons()[j][indiceLigne].getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}
			}
		}

		return !trouveJetonInvalide;
	}

	private int siPossibleJouerBasTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int indiceColonneProchainJetonMemeCouleur = -1;

		for (int i = indiceColonne + 2; i <= getGrille().getJetons().length - 1
				&& indiceColonneProchainJetonMemeCouleur == -1; i++) {

			if (getGrille().getJetons()[i][indiceLigne] != null) {

				if (getGrille().getJetons()[i][indiceLigne].getCouleur().equals(getCouleurCourante())) {

					indiceColonneProchainJetonMemeCouleur = i;
				}
			}
		}

		return indiceColonneProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerBas(int indiceColonne, int indiceLigne) {
		J.appel(this);

		boolean trouveJetonInvalide = true;
		int indiceLigneProchainJetonMemeCouleur = siPossibleJouerBasTrouverJetonMemeCouleur(indiceColonne, indiceLigne);

		if (indiceLigneProchainJetonMemeCouleur != -1) {
			trouveJetonInvalide = false;
			for (int j = indiceColonne + 1; j < indiceLigneProchainJetonMemeCouleur && !trouveJetonInvalide; j++) {

				if (getGrille().getJetons()[j][indiceLigne] == null
						|| !getGrille().getJetons()[j][indiceLigne].getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}
			}
		}

		return !trouveJetonInvalide;
	}

	private int[] siPossibleJouerDiagonaleHautGaucheTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int[] indiceProchainJetonMemeCouleur = new int[] { -1, -1 };

		int i_indiceColonne = indiceColonne - 2, i_indiceLigne = indiceLigne - 2;
		while (i_indiceColonne >= 0 && i_indiceLigne >= 0 && indiceProchainJetonMemeCouleur[0] == -1
				&& indiceProchainJetonMemeCouleur[1] == -1) {

			if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne] != null) {

				if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne].getCouleur().equals(getCouleurCourante())) {

					indiceProchainJetonMemeCouleur[0] = i_indiceColonne;
					indiceProchainJetonMemeCouleur[1] = i_indiceLigne;
				}
			}

			i_indiceColonne--;
			i_indiceLigne--;
		}

		return indiceProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerDiagonaleHautGauche(int indiceColonne, int indiceLigne) {
		J.appel(this);
		boolean trouveJetonInvalide = true;

		int[] indiceProchainJetonMemeCouleur = siPossibleJouerDiagonaleHautGaucheTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);

		if (indiceProchainJetonMemeCouleur[0] != -1 && indiceProchainJetonMemeCouleur[1] != -1) {
			trouveJetonInvalide = false;
			int i_indiceColonneVerifAutreJeton = indiceColonne - 1, i_indiceLigneVerifAutreJeton = indiceLigne - 1;
			while (i_indiceColonneVerifAutreJeton > indiceProchainJetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton > indiceProchainJetonMemeCouleur[1] && !trouveJetonInvalide) {

				if (getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton] == null
						|| !getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton]
								.getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}

				i_indiceColonneVerifAutreJeton--;
				i_indiceLigneVerifAutreJeton--;
			}
		}

		return !trouveJetonInvalide;
	}

	private int[] siPossibleJouerDiagonaleHautDroiteTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int[] indiceProchainJetonMemeCouleur = new int[] { -1, -1 };

		int i_indiceColonne = indiceColonne - 2, i_indiceLigne = indiceLigne + 2;
		while (i_indiceColonne >= 0 && i_indiceLigne <= getGrille().getJetons()[0].length - 1
				&& indiceProchainJetonMemeCouleur[0] == -1 && indiceProchainJetonMemeCouleur[1] == -1) {
			if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne] != null) {

				if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne].getCouleur().equals(getCouleurCourante())) {

					indiceProchainJetonMemeCouleur[0] = i_indiceColonne;
					indiceProchainJetonMemeCouleur[1] = i_indiceLigne;
				}
			}
			i_indiceColonne--;
			i_indiceLigne++;
		}

		return indiceProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerDiagonaleHautDroite(int indiceColonne, int indiceLigne) {
		J.appel(this);
		boolean trouveJetonInvalide = true;

		int[] indiceProchainJetonMemeCouleur = siPossibleJouerDiagonaleHautDroiteTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);

		if (indiceProchainJetonMemeCouleur[0] != -1 && indiceProchainJetonMemeCouleur[1] != -1) {
			trouveJetonInvalide = false;

			int i_indiceColonneVerifAutreJeton = indiceColonne - 1, i_indiceLigneVerifAutreJeton = indiceLigne + 1;
			while (i_indiceColonneVerifAutreJeton > indiceProchainJetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton < indiceProchainJetonMemeCouleur[1] && !trouveJetonInvalide) {

				if (getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton] == null
						|| !getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton]
								.getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}

				i_indiceColonneVerifAutreJeton--;
				i_indiceLigneVerifAutreJeton++;
			}
		}

		return !trouveJetonInvalide;

	}

	private int[] siPossibleJouerDiagonaleBasGaucheTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int[] indiceProchainJetonMemeCouleur = new int[] { -1, -1 };

		int i_indiceColonne = indiceColonne + 2, i_indiceLigne = indiceLigne - 2;
		while (i_indiceColonne <= getGrille().getJetons().length - 1 && i_indiceLigne >= 0
				&& indiceProchainJetonMemeCouleur[0] == -1 && indiceProchainJetonMemeCouleur[1] == -1) {
			if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne] != null) {

				if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne].getCouleur().equals(getCouleurCourante())) {

					indiceProchainJetonMemeCouleur[0] = i_indiceColonne;
					indiceProchainJetonMemeCouleur[1] = i_indiceLigne;
				}
			}
			i_indiceColonne++;
			i_indiceLigne--;
		}
		return indiceProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerDiagonaleBasGauche(int indiceColonne, int indiceLigne) {
		J.appel(this);

		boolean trouveJetonInvalide = true;

		int[] indiceProchainJetonMemeCouleur = siPossibleJouerDiagonaleBasGaucheTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);
		if (indiceProchainJetonMemeCouleur[0] != -1 && indiceProchainJetonMemeCouleur[1] != -1) {
			trouveJetonInvalide = false;

			int i_indiceColonneVerifAutreJeton = indiceColonne + 1, i_indiceLigneVerifAutreJeton = indiceLigne - 1;
			while (i_indiceColonneVerifAutreJeton < indiceProchainJetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton > indiceProchainJetonMemeCouleur[1] && !trouveJetonInvalide) {

				if (getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton] == null
						|| !getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton]
								.getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}

				i_indiceColonneVerifAutreJeton++;
				i_indiceLigneVerifAutreJeton--;
			}
		}

		return !trouveJetonInvalide;

	}

	private int[] siPossibleJouerDiagonaleBasDroiteTrouverJetonMemeCouleur(int indiceColonne, int indiceLigne) {
		J.appel(this);

		int[] indiceProchainJetonMemeCouleur = new int[] { -1, -1 };

		int i_indiceColonne = indiceColonne + 2, i_indiceLigne = indiceLigne + 2;
		while (i_indiceColonne <= getGrille().getJetons().length - 1
				&& i_indiceLigne <= getGrille().getJetons().length - 1 && indiceProchainJetonMemeCouleur[0] == -1
				&& indiceProchainJetonMemeCouleur[1] == -1) {
			if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne] != null) {

				if (getGrille().getJetons()[i_indiceColonne][i_indiceLigne].getCouleur().equals(getCouleurCourante())) {

					indiceProchainJetonMemeCouleur[0] = i_indiceColonne;
					indiceProchainJetonMemeCouleur[1] = i_indiceLigne;
				}
			}
			i_indiceColonne++;
			i_indiceLigne++;
		}

		return indiceProchainJetonMemeCouleur;
	}

	private boolean siPossibleJouerDiagonaleBasDroite(int indiceColonne, int indiceLigne) {
		J.appel(this);

		boolean trouveJetonInvalide = true;

		int[] indiceProchainJetonMemeCouleur = siPossibleJouerDiagonaleBasDroiteTrouverJetonMemeCouleur(indiceColonne,
				indiceLigne);
		if (indiceProchainJetonMemeCouleur[0] != -1 && indiceProchainJetonMemeCouleur[1] != -1) {
			trouveJetonInvalide = false;

			int i_indiceColonneVerifAutreJeton = indiceColonne + 1, i_indiceLigneVerifAutreJeton = indiceLigne + 1;
			while (i_indiceColonneVerifAutreJeton < indiceProchainJetonMemeCouleur[0]
					&& i_indiceLigneVerifAutreJeton < indiceProchainJetonMemeCouleur[1] && !trouveJetonInvalide) {

				if (getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton] == null
						|| !getGrille().getJetons()[i_indiceColonneVerifAutreJeton][i_indiceLigneVerifAutreJeton]
								.getCouleur().equals(getCouleurNonCourante())) {
					trouveJetonInvalide = true;
				}

				i_indiceColonneVerifAutreJeton++;
				i_indiceLigneVerifAutreJeton++;
			}
		}

		return !trouveJetonInvalide;
	}

	public boolean siPossibleJouerIci(int indiceColonne, int indiceLigne) {
		J.appel(this);

		return grille.getCoupPossibles()[indiceColonne][indiceLigne];

	}

}
