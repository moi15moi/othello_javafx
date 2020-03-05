package othello_javafx.commandes.Cliquer;

import javafx.scene.paint.Color;

import commun_client.commandes.CommandePourEnvoi;

public interface CliquerPourEnvoi extends CommandePourEnvoi{
	void setCouleurFondEcran(Color couleur);
}
