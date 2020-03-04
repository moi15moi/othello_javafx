package othello_javafx.commandes.Cliquer;

import java.awt.Color;

import commun_client.commandes.CommandePourEnvoi;

public interface CliquerPourEnvoi extends CommandePourEnvoi{
	void setCouleurFondEcran(Color couleur);
}
