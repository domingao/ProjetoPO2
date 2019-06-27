package Telas;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.IntegerField;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TelaFilmes extends Application {
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

		Label Filmes = new Label("Filmes :");
		Filmes.setTextFill(Color.WHITE);
		Filmes.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		Filmes.setLayoutX(20);
		Filmes.setLayoutY(30);

		// imagens filme

		Image fotoVing = new Image(
				"https://upload.wikimedia.org/wikipedia/pt/thumb/9/90/Avengers_Infinity_War.jpg/250px-Avengers_Infinity_War.jpg",
				300, 200, true, false);
		ImageView imagemvng = new ImageView(fotoVing);
		imagemvng.setTranslateX(50);
		imagemvng.setTranslateY(80);
		Label vingadores = new Label("Vingadores: Guerra Infinita");
		vingadores.setTextFill(Color.WHITE);
		vingadores.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		vingadores.setLayoutX(40);
		vingadores.setLayoutY(280);

		Image fotoVing1 = new Image(
				"https://upload.wikimedia.org/wikipedia/pt/thumb/9/9b/Avengers_Endgame.jpg/250px-Avengers_Endgame.jpg",
				300, 200, true, false);
		ImageView imagemvng1 = new ImageView(fotoVing1);
		imagemvng1.setTranslateX(300);
		imagemvng1.setTranslateY(340);
		Label vingadores1 = new Label("Vingadores: Ultimato");
		vingadores1.setTextFill(Color.WHITE);
		vingadores1.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		vingadores1.setLayoutX(300);
		vingadores1.setLayoutY(540);

		Image fotoVing2 = new Image(
				"https://upload.wikimedia.org/wikipedia/pt/thumb/6/69/The_Avengers_Cartaz.jpg/250px-The_Avengers_Cartaz.jpg",
				300, 200, true, false);
		ImageView imagemvng2 = new ImageView(fotoVing2);
		imagemvng2.setTranslateX(300);
		imagemvng2.setTranslateY(80);
		Label vingadores2 = new Label("Vingadores");
		vingadores2.setTextFill(Color.WHITE);
		vingadores2.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		vingadores2.setLayoutX(300);
		vingadores2.setLayoutY(280);

		Image fotoSW = new Image(
				"https://http2.mlstatic.com/dvd-star-warso-imperio-contra-ataca-D_NQ_NP_14786-MLB20090415104_052014-F.jpg",
				300, 200, true, false);
		ImageView imagemSW = new ImageView(fotoSW);
		imagemSW.setTranslateX(50);
		imagemSW.setTranslateY(340);
		Label starwars = new Label("        Star Wars:\nO Imperio Contra-Ataca");
		starwars.setTextFill(Color.WHITE);
		starwars.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		starwars.setLayoutX(50);
		starwars.setLayoutY(540);

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
		Button btvoltar = new Button("Voltar");
		btvoltar.setTextFill(Color.DARKSLATEGREY);
		btvoltar.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		btvoltar.setLayoutX(20);
		btvoltar.setLayoutY(600);

		pane.getChildren().addAll(btvoltar, vingadores, imagemvng, vingadores1, vingadores2, imagemvng2, imagemvng1,
				imagemSW, starwars, Filmes);

		btvoltar.setOnAction(e -> btvoltars(stagew));

		stagew.show();
		
		//açoes
		
		imagemvng.setOnMouseClicked(e -> {
			try {
				stagew.close();
				new VerFilme().start(new Stage(), vingadores.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		imagemvng1.setOnMouseClicked(e -> {
			try {
				stagew.close();
				new VerFilme().start(new Stage(), vingadores1.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		imagemvng2.setOnMouseClicked(e -> {
			try {
				stagew.close();
				new VerFilme().start(new Stage(), vingadores2.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		imagemSW.setOnMouseClicked(e -> {
			try {
				stagew.close();
				new VerFilme().start(new Stage(), starwars.getText());

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		

	}

	private void atualizaHoras() {
		Date agora = new Date();
		lblRelogio.setText(formatador.format(agora));
	}

	public void btvoltars(Stage stage) {
		try {
			stage.close();
			new TelaPrincipal().start(new Stage());
		} catch (Exception e) {
			//
			e.printStackTrace();
		}

	}

}
