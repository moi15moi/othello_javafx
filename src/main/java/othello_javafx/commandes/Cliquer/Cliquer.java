package othello_javafx.commandes.Cliquer;

import javafx.scene.paint.Color;

import commun_client.commandes.Commande;

public class Cliquer extends Commande<CliquerPourEnvoi, CliquerRecue> implements  CliquerPourEnvoi, CliquerRecue{
	private Color couleurFondEcran;

	@Override
	public Color getCouleurFondEcran() {
		
		return couleurFondEcran;
	}

	@Override
	public void setCouleurFondEcran(Color couleur) {
		this.couleurFondEcran = couleur;
		
	}
}
