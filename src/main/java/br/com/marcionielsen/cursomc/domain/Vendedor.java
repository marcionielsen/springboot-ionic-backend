package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.Table;

@Entity
@Table(name="VENDEDORES", indexes = {
		@Index(name = "UK_NM_VENDEDOR", columnList = "NM_VENDEDOR", unique = true),
		@Index(name = "IDX_NM_VENDEDOR", columnList = "NM_VENDEDOR", unique = false) } )
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_VENDEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NM_VENDEDOR", nullable = false)
	private String nome;
	
	@Column(name = "DS_EMAIL_VENDEDOR")
	private String email;
	
	@ElementCollection
	@CollectionTable(name="TELEFONES_VENDEDOR", joinColumns = @JoinColumn(name = "CD_VENDEDOR", referencedColumnName="CD_VENDEDOR", foreignKey = @ForeignKey(name = "FK_TELEFONES_CD_VENDEDOR")), 
	           foreignKey = @ForeignKey(name = "FK_TELEFONES_CD_VENDEDOR") )
	private Set<String> telefones = new HashSet<>();

	public Vendedor() {
		super();
	}

	public Vendedor(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
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
		if (!(obj instanceof Vendedor)) {
			return false;
		}
		Vendedor other = (Vendedor) obj;
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
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", telefones=" + telefones + "]";
	}

}
