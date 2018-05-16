package br.com.marcionielsen.cursomc.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.marcionielsen.cursomc.services.validation.annotations.ClienteInsertValid;
import br.com.marcionielsen.cursomc.services.validation.annotations.ClienteUpdateValid;
import br.com.marcionielsen.cursomc.services.validation.annotations.IsCpfCnpjValid;

@IsCpfCnpjValid
@ClienteInsertValid
@ClienteUpdateValid
public class ClienteEnderecoTelefonesDTO extends AbstrataDTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "O preenchimento do campo nome é obrigatório!")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres!")
	private String nome;

	@NotEmpty(message = "O preenchimento do campo email é obrigatório!")
	@Email(message = "O Email informado, não corresponde ao padrão aceitavél!")
	private String email;

	@NotEmpty(message = "O preenchimento do campo CPF/CNPJ é obrigatório!")
	private String cpfCnpj;

	private Integer tipo;

	@NotEmpty(message = "O preenchimento do campo logradouro é obrigatório!")
	private String logradouro;
	
	@NotEmpty(message = "O preenchimento do campo número é obrigatório!")
	private String numero;

	private String complemento;
	
	@NotEmpty(message = "O preenchimento do campo CEP é obrigatório!")
	private String cep;
	
	private String nomeBairro;
	
	private String nomeCidade;
	
	private Long estadoId;
	
	private Set<String> telefones = new HashSet<>();
	
	public ClienteEnderecoTelefonesDTO() {
		super();
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

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

}
