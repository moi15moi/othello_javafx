package othello_javafx.vues.composants;


import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import othello.enumerations.Couleur;
import othello_javafx.commandes.jouer_ici.JouerIci;
import othello_javafx.commandes.jouer_ici.JouerIciPourEnvoi;

public class CaseAjustable extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.6;
    
    
    private Color couleurBlanc;
    private Color couleurNoir;
    
    private int indiceColonne;
    private int indiceLigne;
	private JouerIciPourEnvoi jouerIciPourEnvoi;

    public CaseAjustable(Color couleurBlanc, Color couleurNoir, int indiceColonne, int indiceLigne) {
        super();
        J.appel(this);
        
        this.couleurBlanc = couleurBlanc;
        this.couleurNoir = couleurNoir;
        
        this.indiceColonne = indiceColonne;
        this.indiceLigne = indiceLigne;
        
        initialiserPinceau();
        dessinerCase();
        
        installerCapteurJouerIci();
    }

    public void afficherJeton(Couleur couleur) {
        J.appel(this);
        
        switch(couleur) {
        
            case BLANC:
                pinceau.setFill(couleurBlanc);
                dessinerCase();
            break;

            case NOIR:
                pinceau.setFill(couleurNoir);
                dessinerCase();
            break;
        }
    }

    @Override
    protected void reagirLargeurInitiale(double largeurInitiale) {
        J.appel(this);
        
        dessinerCase();
    }

    @Override
    protected void reagirHauteurInitiale(double hauteurInitiale) {
        J.appel(this);

        dessinerCase();
    }

    @Override
    protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
        J.appel(this);

        viderDessin();

        dessinerCase();
    }

    @Override
    protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
        J.appel(this);

        viderDessin();

        dessinerCase();
    }

    private void initialiserPinceau() {
        J.appel(this);

        pinceau.setFill(Color.WHITE);
        pinceau.setStroke(Color.BLACK);
        pinceau.setLineWidth(0.01*getWidth());
    }
    
    private void viderDessin() {
        J.appel(this);

        pinceau.clearRect(0, 0, getWidth(), getHeight());
    }
    
    private void dessinerCase() {
        J.appel(this);
        
        dessinerCase(TAILLE_POURCENTAGE);
    }

    private class Case {
        public double caseHautGaucheX;
        public double caseHautGaucheY;
        public double tailleCase;
    }
    
    private void dessinerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = calculerCase(taillePourcentage);
        
        dessinerFond(laCase);
        dessinerContour(laCase);
    }

    private void dessinerFond(Case laCase) {
        J.appel(this);

        pinceau.fillArc(laCase.caseHautGaucheX, 
                        laCase.caseHautGaucheY, 
                        laCase.tailleCase, 
                        laCase.tailleCase, 
                        0, 
                        360, 
                        ArcType.ROUND);
    }

    private void dessinerContour(Case laCase) {
        J.appel(this);

        pinceau.strokeArc(laCase.caseHautGaucheX, 
                          laCase.caseHautGaucheY, 
                          laCase.tailleCase, 
                          laCase.tailleCase, 
                          0, 
                          360, 
                          ArcType.OPEN);
    }

    private Case calculerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = new Case();

        double largeurDessin = getWidth();
        double hauteurDessin = getHeight();
        
        laCase.tailleCase = largeurDessin * taillePourcentage;

        if(hauteurDessin < largeurDessin) {
            laCase.tailleCase = hauteurDessin * taillePourcentage;
        }
        
        laCase.caseHautGaucheX = (largeurDessin - laCase.tailleCase) / 2;
        laCase.caseHautGaucheY = (hauteurDessin - laCase.tailleCase) / 2;
        
        return laCase;
    }
    
    
    public void installerCapteurJouerIci() {
		J.appel(this);
		
		this.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
								
				jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
				jouerIciPourEnvoi.setIndiceLigne(indiceLigne);
				jouerIciPourEnvoi.envoyerCommande();
				
			}
		});
		
	}

    public void obtenirJouerIciPourEnvoi() {
		J.appel(this);
		
		jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
	}
    
    public void verifierCommandesPossibles() {
		J.appel(this);
		
		jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
		jouerIciPourEnvoi.setIndiceLigne(indiceLigne);
		setActif(jouerIciPourEnvoi.siCommandePossible());
    }
    
    public void setActif(boolean caseAjustableActif) {
		J.appel(this);

		this.setDisable(!caseAjustableActif);
    }
}
