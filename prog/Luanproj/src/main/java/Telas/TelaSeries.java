

package Telas;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class TelaSeries extends Application {
	private	AnchorPane	pane;
	Label lblRelogio = new Label();
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
		

		Label Series = new Label("Series :");
		Series.setTextFill(Color.WHITE);
		Series.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		Series.setLayoutX(20);
		Series.setLayoutY(30);
		
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
		//imagens filme
		
		Image fotomr = new Image("http://br.web.img3.acsta.net/c_216_288/pictures/16/06/14/19/46/337804.jpg", 300, 200, true, false);
		ImageView imagemrrobot = new ImageView(fotomr);
		imagemrrobot.setTranslateX(50);
		imagemrrobot.setTranslateY(80);
		Label mrrobot = new Label("Mr Robot");
		mrrobot.setTextFill(Color.WHITE);
		mrrobot.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		mrrobot.setLayoutX(40);
		mrrobot.setLayoutY(280);
		
		
		Image fotogot = new Image("http://br.web.img3.acsta.net/pictures/19/03/21/16/15/4239577.jpg", 300, 200, true, false);
		ImageView imagemgot = new ImageView(fotogot);
		imagemgot.setTranslateX(50);
		imagemgot.setTranslateY(340);
		Label got = new Label("Game Of Thrones");
		got.setTextFill(Color.WHITE);
		got.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		got.setLayoutX(40);
		got.setLayoutY(540);
		
		
		Image fotosoa = new Image("https://media.fstatic.com/7AAYF_VNpKjq-XLDCfJ9cNE-yyA=/fit-in/290x478/smart/media/movies/covers/2015/09/sons-of-anarchy-appisodes_tNone.jpg", 300, 200, true, false);
		ImageView imagemsoa = new ImageView(fotosoa);
		imagemsoa.setTranslateX(300);
		imagemsoa.setTranslateY(80);
		Label soa = new Label("Sons Of Anarchy");
		soa.setTextFill(Color.WHITE);
		soa.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		soa.setLayoutX(300);
		soa.setLayoutY(280);
		
		
		
		Image fotoSW = new Image("https://http2.mlstatic.com/dvd-star-warso-imperio-contra-ataca-D_NQ_NP_14786-MLB20090415104_052014-F.jpg", 300, 200, true, false);
		ImageView imagemSW = new ImageView(fotoSW);
		imagemSW.setTranslateX(50);
		imagemSW.setTranslateY(340);
		Label starwars = new Label("        Star Wars:\nO Imperio Contra-Ataca");
		starwars.setTextFill(Color.WHITE);
		starwars.setFont(Font.font("verdana", FontWeight.BOLD, 12));
		starwars.setLayoutX(50);
		starwars.setLayoutY(540);
		
		//botao
		
		

		Button btvoltar = new Button("Voltar");
		btvoltar.setTextFill(Color.DARKSLATEGREY);
		btvoltar.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		btvoltar.setLayoutX(20);
		btvoltar.setLayoutY(600);
		
		
		pane.getChildren().addAll(btvoltar,imagemsoa,soa,got,imagemgot,imagemrrobot,mrrobot,Series);
		
		btvoltar.setOnAction(e -> handle(stagew));
		
		stagew.show();
		
	}
	private void atualizaHoras() {
		Date agora = new Date();
		lblRelogio.setText(formatador.format(agora));
	}
	
	public	void	handle(Stage stage)	{
		try {
			new	TelaPrincipal().start(new Stage());
			stage.close();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}

}
