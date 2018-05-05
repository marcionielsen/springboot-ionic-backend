package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.marcionielsen.cursomc.util.Util;

@Entity
@Table(name = "ITEM_PEDIDOS")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	@Column(name = "QTD_PRODUTO", nullable = false)
	private Integer quantidade;

	@Column(name = "VLR_DESCONTO_ITEM")
	private BigDecimal desconto;

	@Column(name = "VLR_PRECO_ITEM", nullable = false)
	private BigDecimal preco;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, BigDecimal desconto, BigDecimal preco) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.preco = preco;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
		if (!(obj instanceof ItemPedido)) {
			return false;
		}
		ItemPedido other = (ItemPedido) obj;
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
		return "ItemPedido [ itemPedidoPK = [pedido=" + id.getPedido().toString() + ", produto="
				+ id.getProduto().toString() + "] , quantidade=" + quantidade + ", desconto="
				+ Util.formatoMoeda(desconto) + ", preco=" + Util.formatoMoeda(preco) + "]";
	}

}
