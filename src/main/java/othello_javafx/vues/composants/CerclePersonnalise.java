package othello_javafx.vues.composants;

import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class CerclePersonnalise extends HBox {

	private Timeline animationClick = new Timeline();

	private Circle circle = new Circle();

	public CerclePersonnalise() {

		J.appel(this);

		//creerAnimation();

		installerListeners();
		//animationClick.setCycleCount(-1);

		installerCercle();
		installerObservateurLargeur();
		installerObservateurHauteur();
	}

	private void installerCercle() {
		J.appel(this);

		circle.setFill(Color.WHITE);

		this.getChildren().add(circle);

	}

	private void installerObservateurLargeur() {
		J.appel(this);

		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				double ancienneLargeur = (double) oldValue;
				double nouvelleLargeur = (double) newValue;
				
				if(ancienneLargeur != 0) {
					
					redimensionnerCercleLargeur();					
				}
				
			}
		});
	}

	private void installerObservateurHauteur() {
		J.appel(this);

		heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);

				double ancienneHauteur = (double) oldValue;
				double nouvelleHauteur = (double) newValue;
				
				if(ancienneHauteur != 0) {
					
					redimensionnerCercleLargeur();					
				}
			}
		});
	}
	
	private class Case {
		public double caseHautGaucheX;
		public double caseHautGaucheY;
		public double tailleCase;
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

	private void redimensionnerCercleLargeur() {

		circle.setRadius(calculerCase(0.3).tailleCase);

		J.valeurs(getHeight());
	}
	
	private void redimensionnerCercleHauteur() {

		circle.setRadius(getHeight() * 0.1);
		
		J.valeurs(getWidth());
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
				CerclePersonnalise.this.opacityProperty().set(1);

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
