package othello_javafx.modeles.PartieLocale;

import java.util.Random;

import commun.debogage.J;
import commun.modeles.Modele;
import othello.enumerations.Couleur;
import othello.modeles.Grille.Grille;
import othello.modeles.Grille.GrilleLectureSeule;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {

	final private int largeur =  8;
	final private int hauteur = 8;
	
	private Couleur couleurCourante = Couleur.NOIR;

	private Grille grille;
	
	public PartieLocale() {
		J.appel(this);
		
		grille = new Grille();
		grille.initialiser(largeur);
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

	public int getLargeur() {
		J.appel(this);
		return largeur;
	}

	public int getHauteur() {
		J.appel(this);
		return hauteur;
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



}
