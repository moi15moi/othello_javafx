package othello_javafx.commandes.nouvelle_partie;

import commun_client.commandes.Commande;

public class NouvellePartieLocale extends Commande<NouvellePartieLocalePourEnvoi, 
                                             NouvellePartieLocaleRecue>

							implements NouvellePartieLocalePourEnvoi, 
							           NouvellePartieLocaleRecue {
}
