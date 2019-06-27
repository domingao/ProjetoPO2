package Telas;

import java.text.SimpleDateFormat;
import java.util.Date;

import String.Strings;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VerFilme extends Application {
	private AnchorPane pane;
	Label lblRelogio = new Label();
	SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");

	public void start(final Stage stagew, String nomeFilme) throws Exception {
		// TODO Auto-generated method stub
		pane = new AnchorPane();

		Scene scene = new Scene(pane);
		stagew.setScene(scene);
		stagew.setMaximized(false);
		stagew.setResizable(false);

		BackgroundImage backg = new BackgroundImage(
				new Image("https://i2.wp.com/obscenidadedigital.com/wp-content/uploads/2017/10/gradiente.png", 0, 0,
						false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		// then you set to your node
		pane.setBackground(new Background(backg));

		if (nomeFilme == "        Star Wars:\nO Imperio Contra-Ataca") {
			WebView webview = new WebView();
			webview.getEngine().load("https://www.youtube.com/watch?v=1T-opnRcc7s"); 
			webview.setPrefSize(1366, 768);
			pane.getChildren().add(webview);
			
		} else if (nomeFilme == "Vingadores: Guerra Infinita") {
			WebView webview = new WebView();
			webview.getEngine().load("https://www.youtube.com/watch?v=t_ULBP6V9bg"); 
			webview.setPrefSize(1366, 768);
			pane.getChildren().add(webview);
			
		}else if(nomeFilme == "Vingadores") {
			WebView webview = new WebView();
			webview.getEngine().load("https://www.youtube.com/watch?v=KeNEGtsCWEk"); 
			webview.setPrefSize(1366, 768);
			pane.getChildren().add(webview);
			
		}else if(nomeFilme == "Vingadores: Ultimato") {
			WebView webview = new WebView();
			webview.getEngine().load("https://www.youtube.com/watch?v=g6ng8iy-l0U"); 
			webview.setPrefSize(1366, 768);
			pane.getChildren().add(webview);
			
		}
		// botao
		Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 30);
		lblRelogio.setFont(font);

		lblRelogio.setEffect(new DropShadow(10, Color.RED));

		KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		lblRelogio.setLayoutX(500);
		lblRelogio.setLayoutY(745);
		pane.getChildren().add(lblRelogio);

		Button btvoltar = new Button("Voltar");
		btvoltar.setTextFill(Color.DARKSLATEGREY);
		btvoltar.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		btvoltar.setLayoutX(20);
		btvoltar.setLayoutY(745);

		pane.getChildren().addAll(btvoltar);

		btvoltar.setOnAction(e -> btvoltars(stagew));
		stagew.show();

	}

	public void btvoltars(Stage stage) {
		try {
			new TelaPrincipal().start(new Stage());
			stage.close();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}

	}

	private void atualizaHoras() {
		Date agora = new Date();
		lblRelogio.setText(formatador.format(agora));
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

}
