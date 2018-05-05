package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FORNECEDORES", indexes = {
		@Index(name = "UK_NM_FORNECEDOR", columnList = "NM_FORNECEDOR", unique = true),
		@Index(name = "UK_CD_CNPJ_FORNECEDOR", columnList = "CD_CNPJ_FORNECEDOR", unique = true),
		@Index(name = "IDX_NM_FORNECEDOR", columnList = "NM_FORNECEDOR", unique = false),
		@Index(name = "IDX_CD_CNPJ_FORNECEDOR", columnList = "CD_CNPJ_FORNECEDOR", unique = false) })
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_FORNECEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NM_FORNECEDOR", nullable = false)
	private String razaoSocial;

	@Column(name = "CD_CNPJ_FORNECEDOR", nullable = false)
	private String cnpj;

	@Column(name = "DS_EMAIL_FORNECEDOR")
	private String email;

	@OneToMany(mappedBy = "fornecedor")
	private List<Endereco> filiais = new ArrayList<>();

	@OneToMany(mappedBy = "fornecedorDoProduto")
	private List<Produto> produtos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELEFONES_FORNECEDOR", 
	                 joinColumns = @JoinColumn(name = "CD_FORNECEDOR", referencedColumnName = "CD_FORNECEDOR", foreignKey = @ForeignKey(name = "FK_TELEFONES_CD_FORNECEDOR")), 
	                 foreignKey = @ForeignKey(name = "FK_TELEFONES_CD_FORNECEDOR"))
	private Set<String> telefones = new HashSet<>();

	public Fornecedor() {
		super();
	}

	public Fornecedor(Long id, String razaoSocial, String cnpj, String email) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Endereco> filiais) {
		this.filiais = filiais;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
		if (!(obj instanceof Fornecedor)) {
			return false;
		}
		Fornecedor other = (Fornecedor) obj;
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
		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", email=" + email
				+ ", filiais=" + filiais + ", produtos=" + produtos + ", telefones=" + telefones + "]";
	}
	
}
