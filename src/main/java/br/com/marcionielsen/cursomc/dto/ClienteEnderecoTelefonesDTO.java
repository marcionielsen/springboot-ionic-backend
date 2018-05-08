package br.com.marcionielsen.cursomc.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteEnderecoTelefonesDTO extends AbastractDTO {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O preenchimento do campo nome é obrigatório!")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres!")
	private String nome;

	@NotEmpty(message = "O preenchimento do campo email é obrigatório!")
	@Email(message = "O Email informado, não corresponde ao padrão aceitavél!")
	private String email;

	private String cpfCnpj;
	private Integer tipo;

	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private Long bairro;
	private Long cidade;
	private Long estado;

	private Set<String> telefones = new HashSet<>();
	
	public ClienteEnderecoTelefonesDTO() {
		super();
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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getBairro() {
		return bairro;
	}

	public void setBairro(Long bairro) {
		this.bairro = bairro;
	}

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long nomeCidade) {
		this.cidade = nomeCidade;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

}
