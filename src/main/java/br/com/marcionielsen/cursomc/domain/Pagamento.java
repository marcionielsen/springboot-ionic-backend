package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import br.com.marcionielsen.cursomc.domain.enums.EstadoPagamento;
import br.com.marcionielsen.cursomc.util.Util;

public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer estadoPagamento;
	private Date dataPagamento;
	private Double valorFatura;
	private Double valorDesconto;
	private Double valorJuros;
	private Double valorMora;
	private Double valorMulta;

	private Pedido pedido;

	public Pagamento() {
		super();
	}

	public Pagamento(Long id, Integer estadoPagamento, Date dataPagamento, Double valorFatura, Double valorDesconto,
			Double valorJuros, Double valorMora, Double valorMulta, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
		this.dataPagamento = dataPagamento;
		this.valorFatura = valorFatura;
		this.valorDesconto = valorDesconto;
		this.valorJuros = valorJuros;
		this.valorMora = valorMora;
		this.valorMulta = valorMulta;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCodigo();
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(Double valorFatura) {
		this.valorFatura = valorFatura;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(Double valorJuros) {
		this.valorJuros = valorJuros;
	}

	public Double getValorMora() {
		return valorMora;
	}

	public void setValorMora(Double valorMora) {
		this.valorMora = valorMora;
	}

	public Double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		if (!(obj instanceof Pagamento)) {
			return false;
		}
		Pagamento other = (Pagamento) obj;
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
		return "Pagamento [id=" + id + ", estadoPagamento=" + EstadoPagamento.toEnum(estadoPagamento).getDescricao()
				+ ", dataPagamento=" + Util.formatoDataHora(dataPagamento.toInstant()) + ", valorFatura=" + valorFatura
				+ ", valorDesconto=" + valorDesconto + ", valorJuros=" + valorJuros + ", valorMora=" + valorMora
				+ ", valorMulta=" + valorMulta + ", pedido=" + pedido + "]";
	}

}
