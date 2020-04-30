package othello.messages.transmettre_coup;

import commun.debogage.J;
import commun.messages.Message;

public class TransmettreCoup extends Message<TransmettreCoupPourEnvoi, 
                                             TransmettreCoupRecu>

					         implements TransmettreCoupPourEnvoi, 
					                    TransmettreCoupRecu {
	
	private int indiceColonne;
	private int indiceLigne;

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}

	@Override
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}

	@Override
	public int getIndiceLigne() {
		return indiceLigne;
	}

	@Override
	public void setIndiceLigne(int indiceLigne) {
		this.indiceLigne = indiceLigne;
		
	}

}
