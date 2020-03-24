package othello_javafx.modeles.PartieLocale;

import commun.debogage.J;
import commun.modeles.Modele;
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
	
    public void jouerIci(int indiceColonne, int indiceLigne){
        J.appel(this);

        effectuerCoup(indiceColonne, indiceLigne);
    }

    public void effectuerCoup(int indiceColonne, int indiceLigne) {
        J.appel(this);

        grille.ajouterJeton(indiceColonne, indiceLigne, couleurCourante);
        prochaineCouleur();
    }

    private void prochaineCouleur() {
        J.appel(this);

        switch(couleurCourante) {

        case BLANC:
        	couleurCourante = Couleur.NOIR;
            break;
        case NOIR:
        	couleurCourante = Couleur.BLANC;
            break;
        }
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
		J.appel(this);
		return (GrilleLectureSeule) grille;
	}

	public void setGrille(Grille grille) {
		J.appel(this);
		this.grille = grille;
	}

	public boolean siPossibleJouerIci(int indiceColonne, int indiceLigne) {
		J.appel(this);
		
		boolean siPossibleJouerIci = false;
		
		if (getGrille().getJetons()[indiceColonne][indiceLigne] == null) {
			siPossibleJouerIci = true;
		}
		return siPossibleJouerIci;
	}



}
