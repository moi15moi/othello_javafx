package othello_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import othello.enumerations.Couleur;
import othello.modeles.Grille.Grille;
import othello_client.afficheurs.AfficheurPartieLocale;
import othello_client.vues.VuePartieLocale;
import othello_javafx.commandes.jouer_ici.JouerIci;
import othello_javafx.commandes.jouer_ici.JouerIciRecue;
import othello_javafx.modeles.PartieLocale.PartieLocale;
import othello_javafx.modeles.PartieLocale.PartieLocaleLectureSeule;

public abstract class ControleurPartieLocale<V extends VuePartieLocale, A extends AfficheurPartieLocale<V>>

		extends ControleurModeleVue<PartieLocaleLectureSeule, PartieLocale, V, A> {

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
		afficheur.rafraichirAffichage(modele, vue);

	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);

				modele.jouerIci(commande.getIndiceColonne(), commande.getIndiceLigne());

			}

			@Override
			public boolean siCommandePossible(JouerIciRecue commande) {
				J.appel(this);

				return modele.siPossibleJouerIci(commande.getIndiceColonne(), commande.getIndiceLigne());
			}

		});
	}

}
