package Telas;

import bdapp.usuario;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UsuariosAPP {
	public void Usuarios(Stage stage) throws Exception {

		// creating the classes hierarchy
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(500, 600);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the users table
		TableView<usuario> materiaisL = new TableView<usuario>();
		materiaisL.setLayoutX(10);
		materiaisL.setLayoutY(50);
		materiaisL.setPrefSize(620, 420);
		materiaisL.setEditable(true);

		// creating the users table cols
		TableColumn<usuario, String> nome = new TableColumn<>("Nome");
		TableColumn<usuario, String> senha = new TableColumn<>("senha");
		TableColumn<usuario, String> idade = new TableColumn<>("idade");

		// configuring the cols
		nome.setCellValueFactory(new PropertyValueFactory<usuario, String>("nome"));
		nome.setCellFactory(TextFieldTableCell.forTableColumn());
		nome.setMinWidth(200);

		senha.setCellValueFactory(new PropertyValueFactory<usuario, String>("senha"));
		senha.setCellFactory(TextFieldTableCell.forTableColumn());
		senha.setMinWidth(200);

		idade.setCellValueFactory(new PropertyValueFactory<usuario, String>("idade"));
		idade.setCellFactory(TextFieldTableCell.forTableColumn());
		idade.setMinWidth(200);

		// adding the created cols to the table usersTable.getColumns().add(colName);
		materiaisL.getColumns().add(nome);
		materiaisL.getColumns().add(senha);
		materiaisL.getColumns().add(idade);

		materiaisL.setItems(bdapp.usuarioNetflix.getLista());
		// adding users data to the table

		Button btvoltar = new Button("Voltar");
		btvoltar.setTextFill(Color.DARKSLATEGREY);
		btvoltar.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		btvoltar.setLayoutX(20);
		btvoltar.setLayoutY(745);

		pane.getChildren().addAll(btvoltar, materiaisL);

		
		// setting some stage (window) properties
		stage.setTitle("nada");
		stage.setResizable(false);

		// showing the created UI
		stage.show();
		btvoltar.setOnAction(e -> btvoltars(stage));

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
}
