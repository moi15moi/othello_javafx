package othello.modeles.Parametre;

import javafx.scene.paint.Color;
import java.util.Random;

import commun.debogage.J;
import commun.modeles.Modele;

public class Parametre extends Modele<ParametreLectureSeule> implements ParametreLectureSeule {
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
	
	@Override
	public void setCouleurFondEcran(Color couleur) {
		J.appel(this);
		this.couleurFondEcran = couleur;
	}
	
	
	
	//Section getter
	@Override
	public Color getCouleurFondEcran() {
		
		return this.couleurFondEcran;
	}
}
