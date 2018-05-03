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
@Table(name="BAIRROS", indexes = { @Index(name = "IDX_NM_BAIRRO", columnList = "NM_BAIRRO", unique = false) })
public class Bairro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_BAIRRO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NM_BAIRRO", nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "CD_CIDADE", nullable = false, referencedColumnName = "CD_CIDADE", foreignKey = @ForeignKey(name = "FK_BAIRROS_CD_CIDADE"))
	private Cidade cidade;

	public Bairro() {
		super();
	}

	public Bairro(Long id, String nome, Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
		if (!(obj instanceof Bairro)) {
			return false;
		}
		Bairro other = (Bairro) obj;
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
		return "Bairro [id=" + id + ", nome=" + nome + ", cidade=" + cidade + "]";
	}

}
