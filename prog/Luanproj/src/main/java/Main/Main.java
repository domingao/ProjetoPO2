package Main;
import java.text.SimpleDateFormat;
import java.util.Date;

import String.Strings;
import Telas.TelaCadastro;
import Telas.TelaErro;
import Telas.TelaFunçoes;
import Telas.TelaPrincipal;
import bdapp.bdapp;
import bdapp.usuario;
import bdapp.usuarioNetflix;
import bdapp.usuarioPrime;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
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
public class Main extends Application{
	Label lblRelogio = new Label();
	SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
	@Override
	public void start(final Stage stage) throws Exception {		
		stage.setTitle(Strings.labelLogin);
	
		
		
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(640, 480);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		
		Label whatsapp = new Label("(47)99215-8216");
		whatsapp.setLayoutX(70);
		whatsapp.setLayoutY(450);
		MaterialDesignIconView icon3 = new MaterialDesignIconView(MaterialDesignIcon.WHATSAPP);
		icon3.setLayoutX(30);
		icon3.setLayoutY(460);
		icon3.setScaleX(5);
		icon3.setScaleY(5);
		
		FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.USER);
		icon.setLayoutX(220);
		icon.setLayoutY(240);
		icon.setScaleX(3);
		icon.setScaleY(3);
		
		FontAwesomeIconView icon2 = new FontAwesomeIconView(FontAwesomeIcon.KEY);
		icon2.setLayoutX(220);
		icon2.setLayoutY(305);
		icon2.setScaleX(3);
		icon2.setScaleY(3);
		
		
		Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 10);
		lblRelogio.setFont(font);
		
		lblRelogio.setEffect(new DropShadow(10, Color.RED));
		
		KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		lblRelogio.setLayoutX(20);
		lblRelogio.setLayoutY(180);
		pane.getChildren().add(lblRelogio);

		
		
		
		//botao
		Button logar = new Button(Strings.botaoLogar);
		logar.setTextFill(Color.DIMGRAY);
		logar.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		logar.setLayoutX(380);
		logar.setLayoutY(330);
		
		Button Cadastro = new Button("Cadastro");
		Cadastro.setTextFill(Color.DIMGRAY);
		Cadastro.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		Cadastro.setLayoutX(180);
		Cadastro.setLayoutY(330);
		
		
		ComboBox<String> dbSource = new ComboBox<String>();
		dbSource.getItems().add("Netflix");
		dbSource.getItems().add("Prime");
		dbSource.getSelectionModel().select(0);
		dbSource.setLayoutX(10);
		dbSource.setLayoutY(150);
		dbSource.setOnAction(e -> changeDB(dbSource.getSelectionModel().getSelectedItem()));
		pane.getChildren().add(dbSource);
		
		
		Button Sair = new Button(Strings.botaoSair);
		Sair.setTextFill(Color.DIMGRAY);
		Sair.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		Sair.setLayoutX(10);
		Sair.setLayoutY(10);
		
		
		//label de LOGIN texto
		Label textoLogin = new Label(Strings.labelLogin);
		
		//label informaçao para login
		Label InfoLogin = new Label(Strings.InfoUser);
		final TextField Login = new TextField();
		
		Label InfoSenha = new Label(Strings.InfoSenha);
		final PasswordField Senha = new PasswordField();
		
		//sets layout login
		InfoLogin.setLayoutX(250);
		InfoLogin.setLayoutY(200);
		
		Login.setLayoutX(250);
		Login.setLayoutY(220);
		Login.setText("admin");
		
		//sets layout senha
		InfoSenha.setLayoutX(250);
		InfoSenha.setLayoutY(270);
		Senha.setLayoutX(250);
		Senha.setLayoutY(290);
		Senha.setText("admin");

		////
		textoLogin.setLayoutX(140);
		textoLogin.setLayoutY(60);
		
		
		textoLogin.setTextFill(Color.ORANGE);
		textoLogin.setFont(Font.font("verdana", FontWeight.BOLD, 50));
		
		Reflection reflet = new Reflection();
		textoLogin.setEffect(reflet);
		
		
		
		
		
		BackgroundImage backglogin= new BackgroundImage(new Image("https://i2.wp.com/obscenidadedigital.com/wp-content/uploads/2017/10/gradiente.png"),
		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		//then you set to your node
		pane.setBackground(new Background(backglogin));
		
		pane.getChildren().add(textoLogin);
		pane.getChildren().add(Login);
		pane.getChildren().add(Senha);
		pane.getChildren().add(InfoLogin);
		pane.getChildren().add(InfoSenha);
		pane.getChildren().add(logar);
		pane.getChildren().add(Sair);
		pane.getChildren().add(Cadastro);
		pane.getChildren().addAll(whatsapp,icon,icon2,icon3);
		stage.show();
		
		
		
		Cadastro.setOnAction(new	EventHandler<ActionEvent>()	{				
		public	void	handle(ActionEvent	event)	{
			try {
				new	TelaCadastro().start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}});
		
		Sair.setOnAction(new	EventHandler<ActionEvent>()	{				
		public	void	handle(ActionEvent	event)	{
			Sair();
		}});
				
		logar.setOnAction(e -> logar(stage, Login.getText(), Senha.getText()));				
		
	
	
			
		}
	
		private void Sair() {
		TelaFunçoes.sair();
		
		}
		
		private void atualizaHoras() {
			Date agora = new Date();
			lblRelogio.setText(formatador.format(agora)); 
		}
		
		private void changeDB(String selectedItem) {
			if (selectedItem.equals("Prime"))
				bdapp.users = new usuarioPrime();
			else if (selectedItem.equals("Netflix"))
				bdapp.users = new usuarioNetflix();
		}
		
		
		private void changeDB() {
			if (bdapp.users instanceof usuarioPrime)
				bdapp.users = new usuarioNetflix();
			else if (bdapp.users instanceof usuarioNetflix)
				bdapp.users = new usuarioPrime();
		}
		
		
		public void logar(Stage stage, String Login, String Senha){
				//usuario user = bdapp.users.getUser(Login);
				try {
					if	(Senha.equals("admin") && Login.equals("admin")){
						new	TelaPrincipal().start(new Stage());
						stage.close();
					}else {
						new TelaErro().start(new Stage());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}


	public static void main(String[] args) {
		launch(args);
	}



}

