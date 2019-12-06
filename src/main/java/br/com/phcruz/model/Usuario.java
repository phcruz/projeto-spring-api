package br.com.phcruz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	private String nome;
	@NotNull(message = "O campo email é de preenchimento obrigatório.")
	private String email;
	@NotNull(message = "O campo senha é de preenchimento obrigatório.")
	private String senha;

	public Usuario() {
	}

	public Usuario(@NotEmpty(message = "O campo nome não pode ser vazio.") String nome,
			@NotNull(message = "O campo email é de preenchimento obrigatório.") String email,
			@NotNull(message = "O campo senha é de preenchimento obrigatório.") String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
