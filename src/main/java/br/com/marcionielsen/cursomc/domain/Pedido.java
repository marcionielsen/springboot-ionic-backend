package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.marcionielsen.cursomc.util.Util;

@Entity
@Table(name="PEDIDOS")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CD_PEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date dataPedido;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "CD_CLIENTE", nullable = true, referencedColumnName = "CD_CLIENTE", foreignKey = @ForeignKey(name = "FK_PEDIDOS_CD_CLIENTE"))
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name="CD_ENDERECO_ENTREGA", nullable = true, referencedColumnName = "CD_ENDERECO", foreignKey = @ForeignKey(name = "FK_PEDIDOS_CD_ENDERECO_ENTREGA"))
	private Endereco enderecoDeEntrega;

	public Pedido() {
		super();
	}

	public Pedido(Long id, Date dataPedido, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
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
		if (!(obj instanceof Pedido)) {
			return false;
		}
		Pedido other = (Pedido) obj;
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
		return "Pedido [id=" + id + ", dataPedido=" + Util.formatoDataHora(dataPedido.toInstant()) + ", pagamento="
				+ pagamento + ", cliente=" + cliente + ", enderecoDeEntrega=" + enderecoDeEntrega + "]";
	}

}
