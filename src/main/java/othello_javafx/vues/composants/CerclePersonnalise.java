package othello_javafx.vues.composants;

import commun.debogage.J;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CerclePersonnalise extends Circle{

	private Timeline animationClick = new Timeline();

	public CerclePersonnalise() {

		J.appel(this);

		this.setFill(Color.WHITE);
		creerAnimation();

		installerListeners();
		animationClick.setCycleCount(-1);
	}
	
	private void installerListeners() {
		J.appel(this);
		
		this.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				J.appel(this);
				animationClick.playFromStart();
			}
		});

		this.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				animationClick.stop();
				CerclePersonnalise.this.opacityProperty().set(1);;
				
			}
		});
	}

	private void creerAnimation() {
		J.appel(this);

		double delaiMilisecondes = 600;
		double opaciteNormale = 1.0;
		double opaciteBasse = 0.6;

		animationClick.getKeyFrames().add(new KeyFrame(Duration.ZERO, new KeyValue(opacityProperty(), opaciteNormale)));

		animationClick.getKeyFrames()
				.add(new KeyFrame(new Duration(delaiMilisecondes), new KeyValue(opacityProperty(), opaciteBasse)));

		animationClick.getKeyFrames().add(
				new KeyFrame(new Duration(delaiMilisecondes * 2), new KeyValue(opacityProperty(), opaciteNormale)));
	}
}
