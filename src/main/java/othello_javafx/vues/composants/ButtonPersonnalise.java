package othello_javafx.vues.composants;

import java.awt.Color;
import java.util.Random;

import commun.debogage.J;
import javafx.animation.*;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class ButtonPersonnalise extends Button {

	private Timeline animationClick = new Timeline();

	public ButtonPersonnalise() {

		J.appel(this);

		creerAnimation();

		installerListeners();
		animationClick.setCycleCount(-1);
		this.setRandomColor();
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
				ButtonPersonnalise.this.opacityProperty().set(1);
			}
		});
		
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ButtonPersonnalise.this.setRandomColor();
			}
		});
	}



	private void setRandomColor() {
		Random rand = new Random();

		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		Color randomColor = new Color(r, g, b);

		this.setStyle("-fx-background-color: rgb(" + randomColor.getRed() + ", " + randomColor.getGreen() + ", "
				+ randomColor.getBlue() + ")");

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
