package bdapp;


import java.time.LocalDate;
import java.util.ArrayList;

public class bdapp {
	static ArrayList<usuario> bdapp = new ArrayList<usuario>();
	
	public static void bancoapp(String nome,String senha,String idade, LocalDate datanascm) {
		usuario user = new usuario(nome, senha, idade, datanascm);
		bdapp.add(user);
		
	}

	public static UsuarioInterface users = new usuarioNetflix();
}
