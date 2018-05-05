package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.marcionielsen.cursomc.util.Util;

@Entity
@Table(name = "PRODUTOS", indexes = { @Index(name = "UK_DS_PRODUTO", columnList = "DS_PRODUTO", unique = true) })
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_PRODUTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DS_PRODUTO", nullable = false)
	private String descricao;

	@Column(name = "VL_PRECO_CUSTO_PRODUTO", nullable = false)
	private BigDecimal precoCusto;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CD_FORNECEDOR", nullable = false, referencedColumnName = "CD_FORNECEDOR", foreignKey = @ForeignKey(name = "FK_PRODUTOS_CD_FORNECEDOR"))
	private Fornecedor fornecedorDoProduto;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTOS_CATEGORIAS", joinColumns = @JoinColumn(name = "CD_PRODUTO", referencedColumnName = "CD_PRODUTO", foreignKey = @ForeignKey(name = "FK_CD_PRODUTO")), inverseJoinColumns = @JoinColumn(name = "CD_CATEGORIA", referencedColumnName = "CD_CATEGORIA", foreignKey = @ForeignKey(name = "FK_CD_CATEGORIA")), foreignKey = @ForeignKey(name = "FK_CD_PRODUTO"), inverseForeignKey = @ForeignKey(name = "FK_CD_CATEGORIA"))
	private List<Categoria> categorias = new ArrayList<>();


	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {
		super();
	}

	public Produto(Long id, String descricao, BigDecimal precoCusto, Fornecedor fornecedorDoProduto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.fornecedorDoProduto = fornecedorDoProduto;
	}

	public List<Pedido> getPedidos() {
		List<Pedido> lista = new ArrayList<>();
		
		for(ItemPedido item : itens) {
			lista.add(item.getPedido());
		}
		
		return lista;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Fornecedor getFornecedorDoProduto() {
		return fornecedorDoProduto;
	}

	public void setFornecedorDoProduto(Fornecedor fornecedorDoProduto) {
		this.fornecedorDoProduto = fornecedorDoProduto;
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
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
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
		return "Produto [id=" + id + ", descricao=" + descricao + ", precoCusto=" + Util.formatoMoeda(precoCusto)
				+ ", fornecedorDoProduto=" + fornecedorDoProduto + ", categorias=" + categorias + ", itens=" + itens + "]";
	}

}
