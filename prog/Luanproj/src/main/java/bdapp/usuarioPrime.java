package bdapp;

import java.util.ArrayList;
import java.util.List;

public class usuarioPrime  implements UsuarioInterface {

	public usuario getUser(String user) {
		
		if (user.equals("prime"))
			return new usuario("prime", "amem");
		else
			return null;
	}

	public List<usuario> getUsers() {
		List<usuario> users = new ArrayList<usuario>();
		users.add(new usuario("prime1", "admin"));
		users.add(new usuario("prime2", "admin"));
		return users;
	}

}
