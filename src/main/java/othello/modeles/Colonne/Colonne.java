package othello.modeles.Colonne;

import java.util.ArrayList;

import java.util.List;

import commun.debogage.J;
import othello.enumerations.Couleur;
import othello.modeles.Jeton.Jeton;
import othello.modeles.Jeton.JetonLectureSeule;

public class Colonne implements ColonneLectureSeule {
	
	private ArrayList<Jeton> jetons = new ArrayList<Jeton>(8);

	public void ajouterJeton(int indiceLigne, Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();
		
		jeton.initialiser(couleur);
		
		jetons.get(indiceLigne).equals(jeton);
		//jetons.add(jeton);
	}

	@Override
	public List<JetonLectureSeule> getJetons() {
		J.appel(this);
		
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		for(Jeton jeton : jetons) {

			jetonsLectureSeule.add((JetonLectureSeule) jeton);
		}
		
		return jetonsLectureSeule;
	}
}
