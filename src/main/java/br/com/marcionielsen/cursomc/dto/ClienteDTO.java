package br.com.marcionielsen.cursomc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.marcionielsen.cursomc.domain.Cliente;

public class ClienteDTO extends AbastractDTO {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "O preenchimento do campo nome é obrigatório!")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres!")
	private String nome;

	@NotEmpty(message = "O preenchimento do campo email é obrigatório!")
	@Email(message = "O Email informado, não corresponde ao padrão aceitavél!")
	private String email;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
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

}
