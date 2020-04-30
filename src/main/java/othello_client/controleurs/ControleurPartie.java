package othello_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import othello.enumerations.Couleur;
import othello.modeles.Partie.Grille;
import othello.modeles.Partie.Partie;
import othello.modeles.Partie.PartieLectureSeule;
import othello.modeles.PartieLocale.PartieLocale;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.afficheurs.AfficheurPartie;
import othello_client.vues.VuePartie;
import othello_client.vues.VuePartieLocale;
import othello_javafx.commandes.jouer_ici.JouerIci;
import othello_javafx.commandes.jouer_ici.JouerIciRecue;

public abstract class ControleurPartie<PLS extends PartieLectureSeule, P extends Partie<PLS>, V extends VuePartie, A extends AfficheurPartie<PLS, V>>

		extends ControleurModeleVue<PLS, P, V, A> {
	@Override
	protected void demarrer() {
		J.appel(this);

		// Placer les jetons au début
		Grille grille = (Grille) modele.getGrille();
		grille.ajouterJeton(4, 3, Couleur.NOIR);
		grille.ajouterJeton(3, 3, Couleur.BLANC);
		grille.ajouterJeton(3, 4, Couleur.NOIR);
		grille.ajouterJeton(4, 4, Couleur.BLANC);

		modele.setGrille(grille);
		modele.calculerCoupPossible();
		// PLS PartieLectureSeule = (PLS) modele;

		afficheur.rafraichirAffichage((PLS) modele, vue);

	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);

				reagirCommandeJouerIci(commande);

			}

			@Override
			public boolean siCommandePossible(JouerIciRecue commande) {
				J.appel(this);

				return modele.siPossibleJouerIci(commande.getIndiceColonne(), commande.getIndiceLigne());
			}

		});

	}

	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {

		modele.jouerIci(jouerIciRecue.getIndiceColonne(), jouerIciRecue.getIndiceLigne());

	}

}
