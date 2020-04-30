package othello.modeles.Parametre;

import javafx.scene.paint.Color;
import java.util.Random;

import commun.debogage.J;
import commun.modeles.Modele;

public class Parametre extends Modele<ParametreLectureSeule> implements ParametreLectureSeule {
	
	private String nomJoueurUn;
	private String nomJoueurDeux;

	Color couleurFondEcran;

	@Override
	public Color getCouleurAleatoire() {
		J.appel(this);

		Random rand = new Random();
		double r = ((float) rand.nextInt(255)) / 255.0;
		double g = ((float) rand.nextInt(255)) / 255.0;
		double b = ((float) rand.nextInt(255)) / 255.0;

		Color couleur = new Color(r, g, b, 1.0);

		return couleur;
	}
	
	public void setCouleurFondEcran(Color couleur) {
		J.appel(this);
		this.couleurFondEcran = couleur;
	}
	
	public void changerNomJoueurUn(String nomJoueurUn) {
		J.appel(this);
		
		this.nomJoueurUn = nomJoueurUn;
	}

	public void changerNomJoueurDeux(String nomJoueurDeux) {
		J.appel(this);
		
		this.nomJoueurDeux = nomJoueurDeux;
	}
	
	
	
	//Section getter
	@Override
	public Color getCouleurFondEcran() {
		
		return this.couleurFondEcran;
	}
	
	@Override
	public String getNomJoueurUn() {
		J.appel(this);
		
		return nomJoueurUn;
	}

	@Override
	public String getNomJoueurDeux() {
		J.appel(this);
		
		return nomJoueurDeux;
	}
	
}
