package othello_javafx.commandes.Cliquer;

import java.awt.Color;

import commun_client.commandes.Commande;

public class Cliquer extends Commande<CliquerPourEnvoi, CliquerRecue> implements  CliquerPourEnvoi, CliquerRecue{
	private Color fondEcran;

	@Override
	public Color getCouleurFondEcran() {
		
		return fondEcran;
	}

	@Override
	public void setCouleurFondEcran(Color couleur) {
		this.fondEcran = couleur;
		
	}
}
