package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CIDADES", indexes = { @Index(name = "IDX_NM_CIDADE", columnList = "NM_CIDADE", unique = false) })
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_CIDADE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NM_CIDADE", nullable = false)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy="cidade")
	private List<Bairro> bairros = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "CD_ESTADO", nullable = false, referencedColumnName = "CD_ESTADO", foreignKey = @ForeignKey(name = "FK_CD_ESTADO"))
	private Estado estado;

	public Cidade() {
		super();
	}

	public Cidade(Long id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		if (!(obj instanceof Cidade)) {
			return false;
		}
		Cidade other = (Cidade) obj;
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
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + ", bairros=" + bairros + "]";
	}

}
