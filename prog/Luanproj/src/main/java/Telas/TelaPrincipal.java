package Telas;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Main.Main;
import Telas.TelaSeries;
import Telas.TelaAnimes;
import Telas.TelaFilmes;
import Telas.TelaLancamentos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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

public class TelaPrincipal extends Application {
	private AnchorPane pane;
	Label lblRelogio = new Label();
	SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");

	@Override
	public void start(final Stage stage) throws Exception {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);

		BackgroundImage backg = new BackgroundImage(
				new Image("https://i2.wp.com/obscenidadedigital.com/wp-content/uploads/2017/10/gradiente.png", 900, 800,
						false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		// then you set to your node
		pane.setBackground(new Background(backg));
		// label
		Label sugestao = new Label("Sugestoes :");
		sugestao.setTextFill(Color.WHITE);
		sugestao.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		sugestao.setLayoutX(20);
		sugestao.setLayoutY(100);

		// botao
		Button btprodutos = new Button("Filmes");
		btprodutos.setLayoutX(80);
		btprodutos.setLayoutY(10);
		btprodutos.setTextFill(Color.DARKSLATEGREY);
		btprodutos.setFont(Font.font("verdana", FontWeight.BOLD, 25));

		Button usuarios = new Button("usuarios");
		usuarios.setLayoutX(1);
		usuarios.setLayoutY(1);
		usuarios.setTextFill(Color.DARKSLATEGREY);
		usuarios.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		usuarios.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					stage.close();
					new UsuariosAPP().Usuarios(new Stage());
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
			}
		});

		btprodutos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					stage.close();
					new TelaFilmes().start(new Stage());
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
			}
		});

		Button btclientes = new Button("Series");
		btclientes.setLayoutX(220);
		btclientes.setLayoutY(10);
		btclientes.setTextFill(Color.DARKSLATEGREY);
		btclientes.setFont(Font.font("verdana", FontWeight.BOLD, 25));

		btclientes.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					stage.close();
					new TelaSeries().start(new Stage());
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
			}
		});

		Button btfornecedores = new Button("Animes");
		btfornecedores.setLayoutX(360);
		btfornecedores.setLayoutY(10);
		btfornecedores.setTextFill(Color.DARKSLATEGREY);
		btfornecedores.setFont(Font.font("verdana", FontWeight.BOLD, 25));

		btfornecedores.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					stage.close();
					new TelaAnimes().start(new Stage());
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
			}
		});

		Button btvendas = new Button("Lançamentos");
		btvendas.setLayoutX(515);
		btvendas.setLayoutY(10);
		btvendas.setTextFill(Color.DARKSLATEGREY);
		btvendas.setFont(Font.font("verdana", FontWeight.BOLD, 25));

		btvendas.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					stage.close();
					new TelaLancamentos().start(new Stage());
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
			}
		});
		// imagens filmes

		Image fotoVing = new Image(
				"https://ombrelo.com.br/wp-content/uploads/2018/04/Avengers-Infinity-War-Easter-Eggs-Missed.jpg", 200,
				100, true, false);
		ImageView imagemvng = new ImageView(fotoVing);
		imagemvng.setTranslateX(50);
		imagemvng.setTranslateY(150);
		Label vingadores = new Label("Vingadores: Guerra Infinita");
		vingadores.setTextFill(Color.WHITE);
		vingadores.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		vingadores.setLayoutX(60);
		vingadores.setLayoutY(250);

		Image fotoSW = new Image(
				"https://http2.mlstatic.com/dvd-star-warso-imperio-contra-ataca-D_NQ_NP_14786-MLB20090415104_052014-F.jpg",
				300, 200, true, false);
		ImageView imagemSW = new ImageView(fotoSW);
		imagemSW.setTranslateX(50);
		imagemSW.setTranslateY(300);
		Label starwars = new Label("        Star Wars:\nO Imperio Contra-Ataca");
		starwars.setTextFill(Color.WHITE);
		starwars.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		starwars.setLayoutX(50);
		starwars.setLayoutY(500);

		// fim imagens filmes
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

		Button btvoltar = new Button("Voltar");
		btvoltar.setTextFill(Color.DARKSLATEGREY);
		btvoltar.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		btvoltar.setLayoutX(20);
		btvoltar.setLayoutY(600);

		btvoltar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					stage.close();
					new Main().start(new Stage());
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
			}
		});

		pane.getChildren().addAll(usuarios, starwars, vingadores, imagemSW, sugestao, imagemvng, btprodutos, btvoltar,
				btclientes, btfornecedores, btvendas);

		stage.show();

		// açoes
		imagemvng.setOnMouseClicked(e -> {
			try {
				stage.close();
				new VerFilme().start(new Stage(), vingadores.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		imagemSW.setOnMouseClicked(e -> {
			try {
				stage.close();
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
}