package Telas;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class TelaSalvo extends Application {
	private	AnchorPane	pane;
	@Override
	public void start(Stage stage) throws Exception {
		pane	=	new	AnchorPane();
		pane.setPrefSize(160, 60);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
		
		 Image imagem = new Image("https://findicons.com/files/icons/1676/primo/128/info_black.png",32,32,true,false);
		 ImageView imagem2 = new ImageView(imagem); // 2
		 imagem2.setTranslateX(10);
		 imagem2.setTranslateY(20);
		 
		
		Label texto = new Label("Dados Salvos");
		texto.setTextFill(Color.WHITE);
		texto.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		texto.setLayoutX(50);
		texto.setLayoutY(30);
		
		
		BackgroundImage info= new BackgroundImage(new Image("https://madeirasgasometro.vteximg.com.br/arquivos/ids/168791-490-490/mdf-cristallo-cinza-sagrado-imagem-01.jpg",0,0,true,false),
		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		pane.setBackground(new Background(info));
		
		
		pane.getChildren().addAll(texto,imagem2);
	}
	

}
