package othello.modeles.Partie;

import static othello_javafx.Constantes.*;
import commun.debogage.J;
import othello.enumerations.Couleur;

public class Grille implements GrilleLectureSeule {

	private Jeton[][] jetons = new Jeton[LARGEUR_GRILLE][HAUTEUR_GRILLE];
	private boolean[][] coupPossible = new boolean[LARGEUR_GRILLE][HAUTEUR_GRILLE];

	public void ajouterJeton(int idColonne, int indiceLigne, Couleur couleur) {
		J.appel(this);

		Jeton jeton = new Jeton();

		jeton.initialiser(couleur);

		jetons[idColonne][indiceLigne] = jeton;
	}

	@Override
	public JetonLectureSeule[][] getJetons() {
		//J.appel(this);

		JetonLectureSeule[][] jetonsLectureSeule = new JetonLectureSeule[LARGEUR_GRILLE][HAUTEUR_GRILLE];

		for (int i = 0; i < this.jetons.length; i++) {

			for (int j = 0; j < this.jetons[i].length; j++) {
				jetonsLectureSeule[i][j] = this.jetons[i][j];
			}
		}

		return jetonsLectureSeule;
	}
	
	public void ajouterCoupPossible(int idColonne, int indiceLigne, boolean coupPossible) {
		J.appel(this);

		this.coupPossible[idColonne][indiceLigne] = coupPossible;

	}

	@Override
	public boolean[][] getCoupPossibles() {
		
		return this.coupPossible;
	}
}
