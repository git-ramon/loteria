package br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario extends Model{
	
	@NotEmpty (message="{usuario.nome.campovazio}")
	@Size(max = 16, message="{usuario.nome.tamanho}")
	private String nome;
	
	@NotEmpty (message="{usuario.sobrenome.campovazio}")
	@Size(max = 16, message="{usuario.sobrenome.tamanho}")
	private String sobrenome;
	
	@NotEmpty (message="{usuario.email.campovazio}")
	@Size(max = 30, message="{usuario.email.tamanho}")
	private String email;
	
	@NotEmpty (message="{usuario.senha.campovazio}")
	@Size(min = 4, max = 20, message="{usuario.senha.tamanho}")
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
