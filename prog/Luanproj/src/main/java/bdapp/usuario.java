package bdapp;

import java.time.LocalDate;

public class usuario {

	String nome;
	String senha;
	String idade;
	LocalDate data_nacm;
	
	public usuario(String nome, String senha, String idade, LocalDate datanascm) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.data_nacm = datanascm;
	}
	
	public usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public LocalDate getData_nacm() {
		return data_nacm;
	}

	public void setData_nacm(LocalDate data_nacm) {
		this.data_nacm = data_nacm;
	}



	
}
