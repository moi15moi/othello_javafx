package othello.modeles.Grille;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.debogage.J;
import othello.enumerations.Couleur;
import othello.modeles.Colonne.Colonne;
import othello.modeles.Colonne.ColonneLectureSeule;

public class Grille implements GrilleLectureSeule {
	
	protected List<Colonne> colonnes;

	public void initialiser(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			colonnes.add(new Colonne());
		}
	}

	public void ajouterJeton(int idColonne, int indiceLigne, Couleur couleur) {
		J.appel(this);
		
		colonnes.get(idColonne).ajouterJeton(indiceLigne, couleur);
		//colonnes.get(idColonne).getJetons().get(indiceLigne).ajouterJeton(couleur);

	}

	@Override
	public List<ColonneLectureSeule> getColonnes() {
		J.appel(this);
		
		List<ColonneLectureSeule> colonnesLectureSeule = new ArrayList<>();
		
		for(Colonne colonne : colonnes) {
			
			colonnesLectureSeule.add((ColonneLectureSeule) colonne);
			
		}
		
		return colonnesLectureSeule;
		
	}



	

}
