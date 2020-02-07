package othello_javafx.vues.composants;

import commun.debogage.J;
import commun_javafx.vues.composants.*;
import javafx.beans.NamedArg;
import java.io.InputStream;

public class CaseAjustable extends ImageAjustable {

	public CaseAjustable(@NamedArg("url") String url) {
		super(url);
		J.appel(this);
	}
}