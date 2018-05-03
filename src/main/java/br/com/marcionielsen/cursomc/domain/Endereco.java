package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECOS", 
       indexes = { @Index(name = "IDX_CD_CEP", columnList = "CD_CEP", unique = false),
                   @Index(name = "UK_ENDERECO_UNICO", columnList = "NM_LOGRADOURO, NM_ENDERECO, DS_COMPLEMENTO, CD_CEP", unique = true) })
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_ENDERECO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NM_LOGRADOURO", nullable=false)
	private String logradouro;
	
	@Column(name = "NM_ENDERECO", nullable=false)
	private String numero;
	
	@Column(name = "DS_COMPLEMENTO", nullable=true)
	private String complemento;
	
	@Column(name = "CD_CEP", length=10, nullable=false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "CD_BAIRRO", nullable = false, referencedColumnName = "CD_BAIRRO", foreignKey = @ForeignKey(name = "FK_ENDERECOS_CD_BAIRRO"))
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(name = "CD_CLIENTE", nullable = false, referencedColumnName = "CD_CLIENTE", foreignKey = @ForeignKey(name = "FK_ENDERECOS_CD_CLIENTE"))
	private Cliente cliente;

	public Endereco() {
		super();
	}

	public Endereco(Long id, String logradouro, String numero, String complemento, String cep, Bairro bairro,
			Cliente cliente) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", cep=" + cep + ", bairro=" + bairro + ", cliente=" + cliente + "]";
	}

}
