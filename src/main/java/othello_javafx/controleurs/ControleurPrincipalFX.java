package othello_javafx.controleurs;

import static othello_javafx.Constantes.CHEMIN_CHAINES;
import static othello_javafx.Constantes.CHEMIN_PARAMETRE_CSS;
import static othello_javafx.Constantes.CHEMIN_PARAMETRE_FXML;
import static othello_javafx.Constantes.CHEMIN_PRINCIPAL_CSS;
import static othello_javafx.Constantes.CHEMIN_PRINCIPAL_FXML;

import java.io.File;
import java.io.IOException;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import othello.modeles.Parametre.Parametre;
import othello.modeles.Parametre.ParametreLectureSeule;
import othello.modeles.PartieLocale.PartieLocale;
import othello.modeles.PartieReseau.PartieReseau;
import othello.modeles.sauvegardes.Sauvegardes;
import othello_client.controleurs.ControleurPrincipal;
import othello_javafx.afficheurs.AfficheurParametreFX;
import othello_javafx.afficheurs.AfficheurPartieLocaleFX;
import othello_javafx.afficheurs.AfficheurPartieReseauFX;
import othello_javafx.afficheurs.AfficheurSauvegardesFX;
import othello_javafx.commandes.jouer_ici.JouerIciPourEnvoi;
import othello_javafx.commandes.nouvelle_partie.NouvellePartieLocale;
import othello_javafx.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import othello_javafx.commandes.ouvrir_parametres.OuvrirParametres;
import othello_javafx.commandes.ouvrir_parametres.OuvrirParametresRecue;
import othello_javafx.commandes.quitter.Quitter;
import othello_javafx.commandes.quitter.QuitterRecue;
import othello_javafx.vues.VueParametreFX;
import othello_javafx.vues.VuePartieFX;
import othello_javafx.vues.VuePartieReseauFX;
import othello_javafx.vues.VuePrincipaleFX;
import othello_javafx.vues.VueSauvegardesFX;
import othello_javafx.controleurs.ControleurPartieLocaleFX;
import othello_javafx.vues.VuePartieLocaleFX;
import othello_client.commandes.ouvrir_sauvegarde.OuvrirSauvegarde;
import othello_client.commandes.ouvrir_sauvegarde.OuvrirSauvegardeRecue;
import othello_client.commandes.sauvegarder_partie.SauvegarderPartie;
import othello_client.commandes.sauvegarder_partie.SauvegarderPartieRecue;
import othello_client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import othello_client.commandes.nouvelle_partie_reseau.NouvellePartieReseauRecue;

@SuppressWarnings("rawtypes")
public class ControleurPrincipalFX extends ControleurPrincipal<VuePrincipaleFX> {

	static private final Parametre parametres = new Parametre();
	private PartieLocale partieLocale;

	static public ParametreLectureSeule getParametre() {
		J.appel(ControleurParametreFX.class);

		return parametres;
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);
				Systeme.quitter();
			}
		});

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);

				ouvrirParametres();

			}
		});

		installerRecepteurCommande(NouvellePartieLocale.class, new RecepteurCommandeMVC<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieLocaleRecue commande) {
				J.appel(this);

				nouvellePartieLocale();
			}
		});
		
		installerRecepteurCommande(NouvellePartieReseau.class, new RecepteurCommandeMVC<NouvellePartieReseauRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieReseauRecue commande) {
				J.appel(this);
				
				nouvellePartieReseau();
			}
		});
		
		installerRecepteurCommande(SauvegarderPartie.class, new RecepteurCommandeMVC<SauvegarderPartieRecue>() {
			@Override
			public void executerCommandeMVC(SauvegarderPartieRecue commande) {
				J.appel(this);
				
				sauvegarderPartieLocale(commande.getCheminDansHome());
			}

		});
		
		installerRecepteurCommande(OuvrirSauvegarde.class, new RecepteurCommandeMVC<OuvrirSauvegardeRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirSauvegardeRecue commande) {
				J.appel(this);
				
				ouvrirSauvegarde(commande.getCheminDansHome());
				
			}
		});
	}

	private void nouvellePartieLocale() {
		J.appel(this);

		partieLocale = new PartieLocale();
		partieLocale.initialiser();
		
		instancierMVCPartieLocale();
		
	}
	
	private void nouvellePartieReseau() {
		J.appel(this);
		
		VuePartieReseauFX vuePartieReseau = vue.creerVuePartieReseau();
		
		PartieReseau partie = new PartieReseau();
		
		AfficheurPartieReseauFX afficheur = new AfficheurPartieReseauFX();
		
		FabriqueControleur.creerControleur(ControleurPartieReseauFX.class, partie, vuePartieReseau, afficheur);
		
	}

	private void ouvrirParametres() {
		J.appel(this);

		ChargeurDeVue<VueParametreFX> chargeur = new ChargeurDeVue<VueParametreFX>(CHEMIN_PARAMETRE_FXML,
				CHEMIN_CHAINES, CHEMIN_PARAMETRE_CSS);

		VueParametreFX vue = chargeur.getVue();

		DoitEtre.nonNul(vue);

		AfficheurParametreFX afficheur = new AfficheurParametreFX();

		FabriqueControleur.creerControleur(ControleurParametreFX.class, parametres, vue, afficheur);

		// � ajouter dans le futur fichier parametre

		Scene scene = chargeur.nouvelleScene(600, 400);

		// ComboBox combo = (ComboBox) scene.lookup("#couleurPiece");

		// combo.getItems().addAll("Noir/Blanc", "Noir/Rouge", "Noir/Bleu",
		// "Blanc/Rouge", "Blanc/Bleu");

		// combo = (ComboBox) scene.lookup("#couleurPlateau");

		// combo.getItems().addAll("Blanc", "Noir", "Bleu", "Rouge", "Bleu", "Vert");

		DoitEtre.nonNul(scene);

		DialogueModal.ouvrirDialogueModal(scene);
	}
	
	private void sauvegarderPartieLocale(String cheminDansHome) {
		J.appel(this);

		if(partieLocale != null) {
			
			File fichierDansHome = Systeme.aPartirCheminDansHome(cheminDansHome);
			
			try {

				Json.sauvegarder(fichierDansHome, partieLocale);

			} catch (IOException e) {
				
				Erreur.nonFatale(String.format("Impossible d'�crire le fichier %s", fichierDansHome.getPath()), e);

			}
		}
	}
	
	private void ouvrirSauvegarde(String cheminDansHome) {
		J.appel(this);
		
		File sauvegarde = Systeme.aPartirCheminDansHome(cheminDansHome);
		
		try {

			partieLocale = Json.aPartirFichier(sauvegarde, PartieLocale.class);

		} catch (IOException e) {
			
			Erreur.fatale(String.format("La sauvegarde '%s' doit être valide", cheminDansHome), e);

		}
		
		instancierMVCPartieLocale();
	}
	
	private void instancierMVCPartieLocale() {
		J.appel(this);

		VuePartieLocaleFX vuePartieLocale = vue.creerVuePartieLocale();
		
		AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
		
		FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partieLocale, vuePartieLocale, afficheur);
	}
	
	private void afficherSauvegardes() {
		J.appel(this);
		
		VueSauvegardesFX vueSauvegardes = vue.creerVueSauvegardes();
		
		Sauvegardes lesSauvegardes = new Sauvegardes();
		
		AfficheurSauvegardesFX afficheur = new AfficheurSauvegardesFX();
		
		FabriqueControleur.creerControleur(ControleurSauvegardesFX.class, lesSauvegardes, vueSauvegardes, afficheur);
	}

	@Override
	protected void demarrer() {
		J.appel(this);
		afficherSauvegardes();
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void installerReceptionMessages() {
		// TODO Auto-generated method stub
		
	}

}
