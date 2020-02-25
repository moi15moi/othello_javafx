package othello.modeles.PartieLocale;

import java.util.Random;

import commun.debogage.J;
import commun.modeles.Modele;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {

	private int hauteurGrille = 10;
	private int largeur =  3 + (new Random().nextInt(5));
	private int hauteur = 4 + (new Random().nextInt(8));
	
	@Override
	public int getHauteurGrille() {
		J.appel(this);
		return hauteurGrille;
	}

	@Override
	public int getLargeur() {
	    J.appel(this);
	    return largeur;
	}

	@Override
	public int getHauteur() {
	    J.appel(this);
	    return hauteur;
	}
}
