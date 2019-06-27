package Telas;

import java.text.SimpleDateFormat;
import java.util.Date;

import String.Strings;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TelaAnimes extends Application {
	private AnchorPane pane;
	Label lblRelogio = new Label();
	SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");

	@Override
	public void start(final Stage stagew) throws Exception {
		// TODO Auto-generated method stub
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		Scene scene = new Scene(pane);
		stagew.setScene(scene);
		stagew.setResizable(false);

		BackgroundImage backg = new BackgroundImage(
				new Image("https://i2.wp.com/obscenidadedigital.com/wp-content/uploads/2017/10/gradiente.png", 900, 800,
						false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		// then you set to your node
		pane.setBackground(new Background(backg));

		Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 30);
		lblRelogio.setFont(font);

		lblRelogio.setEffect(new DropShadow(10, Color.RED));

		KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		lblRelogio.setLayoutX(350);
		lblRelogio.setLayoutY(600);
		pane.getChildren().add(lblRelogio);
		// botao

		Button btSalvarFD = new Button(Strings.botaoSalvar);
		btSalvarFD.setTextFill(Color.DARKSLATEGREY);
		btSalvarFD.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		btSalvarFD.setLayoutX(750);
		btSalvarFD.setLayoutY(580);

		Button btvoltar = new Button("Voltar");
		btvoltar.setTextFill(Color.DARKSLATEGREY);
		btvoltar.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		btvoltar.setLayoutX(20);
		btvoltar.setLayoutY(600);

		pane.getChildren().addAll(btSalvarFD, btvoltar);

		btvoltar.setOnAction(e -> handle(stagew));
		btSalvarFD.setOnAction(e -> btsalvarfd(stagew));

		stagew.show();

	}

	public void btsalvarfd(Stage stage) {
		try {
			stage.close();
			new TelaAnimes().start(new Stage());
			new TelaSalvo().start(new Stage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void atualizaHoras() {
		Date agora = new Date();
		lblRelogio.setText(formatador.format(agora));
	}

	public void handle(Stage stage) {
		try {
			new TelaPrincipal().start(new Stage());
			stage.close();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}

}
