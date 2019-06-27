package bdapp;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class usuarioNetflix implements UsuarioInterface {
	
	private static ObservableList<usuario> usuario;

	public usuario getUser(String user) {
		
		if (user.equals("netflix"))
			return new usuario("netflix", "amem");
		else
			return null;
	}

//	public List<usuario> getUsers() {
//		bdapp.bdapp.add(new usuario("netflix", "admin"));
//		bdapp.bdapp.add(new usuario("netflix2", "admin"));
//		return getUsers();
//	}
//	
	
	public static ObservableList<usuario> getLista() {
		usuario = FXCollections.observableArrayList(new ArrayList<usuario>());
		usuario.add(new usuario("netflix", "admin"));
		usuario.add(new usuario("netflix2", "admin"));
		return usuario;
	}

	@Override
	public List<usuario> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
