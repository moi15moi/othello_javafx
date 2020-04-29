package othello_javafx;

public class Constantes {

	public static final String CHEMIN_CHAINES = "traductions.chaines";

	public static final String CHEMIN_PARAMETRE_FXML = "/fxml/parametre.xml";
	public static final String CHEMIN_PARAMETRE_CSS = "/css/parametre.css";

	public static final String CHEMIN_PRINCIPAL_FXML = "/fxml/principal.xml";
	public static final String CHEMIN_PRINCIPAL_CSS = "/css/principal.css";

	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/fxml/partieLocale.xml";
	public static final String CHEMIN_PARTIE_LOCALE_CSS = "/css/partieLocale.css";

	public static final int LARGEUR_SCENE = 220;
	public static final int HAUTEUR_SCENE = 380;

	public static final int HAUTEUR_DECORATION_FENETRE = 20;

	public static final int LARGEUR_FENETRE = LARGEUR_SCENE;
	public static final int HAUTEUR_FENETRE = HAUTEUR_SCENE + HAUTEUR_DECORATION_FENETRE;

	public static final int LARGEUR_GRILLE = 8;
	public static final int HAUTEUR_GRILLE = 8;
	
	public static final int PORT = 8765;
	public static final String ADRESSE_SERVEUR = String.format("ws://localhost:%s", PORT);
}
