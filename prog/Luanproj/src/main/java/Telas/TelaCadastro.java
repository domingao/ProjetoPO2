package Telas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import String.Strings;
import bdapp.bdapp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

public class TelaCadastro extends Application {
	private	AnchorPane	pane;
	Label lblRelogio= new Label();
	SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");

	@Override
	public void start(final Stage stagew) throws Exception {
		// TODO Auto-generated method stub
		pane	=	new	AnchorPane();
		pane.setPrefSize(800, 600);
		Scene scene = new Scene(pane);
		stagew.setScene(scene);
		stagew.setResizable(false);
		
		
		BackgroundImage backg= new BackgroundImage(new Image("https://i2.wp.com/obscenidadedigital.com/wp-content/uploads/2017/10/gradiente.png",900,800,false,true),
		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		//then you set to your node
		pane.setBackground(new Background(backg));
		
		
		//botao
		Label infonome = new Label("Digite seu nome:");
		infonome.setLayoutX(10);
		infonome.setLayoutY(10);
		
		TextField nome = new TextField();
		nome.setLayoutX(10);
		nome.setLayoutY(35);
		
		
		
		Label infosenha = new Label("Digite sua senha:");
		infosenha.setLayoutX(10);
		infosenha.setLayoutY(80);
		
		PasswordField senha = new PasswordField();
		senha.setLayoutX(10);
		senha.setLayoutY(105);
		
		Label confirmarsenhaa = new Label("Confirme sua senha");
		confirmarsenhaa.setLayoutX(210);
		confirmarsenhaa.setLayoutY(80);
		
		PasswordField confirmsenha = new PasswordField();
		confirmsenha.setLayoutX(210);
		confirmsenha.setLayoutY(105);
		
		Label infoidade = new Label("Digite sua idade");
		infoidade.setLayoutX(10);
		infoidade.setLayoutY(145);
		
		TextField idade = new TextField();
		idade.setLayoutX(10);
		idade.setLayoutY(170);
		
		
		Label infodatanasc = new Label("Data de Nascimento");
		infodatanasc.setLayoutX(10);
		infodatanasc.setLayoutY(210);
		
		DatePicker datanasc = new DatePicker();
		datanasc.setLayoutX(10);
		datanasc.setLayoutY(235);
		
		Button btSalvarPD = new Button(Strings.botaoSalvar);
		btSalvarPD.setTextFill(Color.DARKSLATEGREY);
		btSalvarPD.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		btSalvarPD.setLayoutX(750);
		btSalvarPD.setLayoutY(580);
		
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
		
		pane.getChildren().addAll(nome,senha,confirmsenha,idade,datanasc,infodatanasc,infonome,infosenha,confirmarsenhaa,infoidade,btvoltar,btSalvarPD);
		
		btSalvarPD.setOnAction(e -> btsalvar(stagew,nome.getText(),senha.getText(),confirmsenha.getText(),idade.getText(),datanasc.getValue()));
			
			
		
		btvoltar.setOnAction(e -> btvoltars(stagew));				
		
		stagew.show();
		
	}
	private void atualizaHoras() {
		Date agora = new Date();
		lblRelogio.setText(formatador.format(agora)); 
	}
	public void btvoltars(Stage stage) {
		try {
			stage.close();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
		
		
	}
	
	public void btsalvar(Stage stage,String nome, String senha, String confirmsenha, String idade, LocalDate datanascm){
			try {
				if (senha.equals(confirmsenha) && senha.isEmpty() == false && nome.isEmpty() == false) {
				new TelaSalvo().start(new Stage());
				bdapp.bancoapp(nome,senha,idade,datanascm);
				stage.close();
				}else {
					new TelaErro().start(new Stage());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

