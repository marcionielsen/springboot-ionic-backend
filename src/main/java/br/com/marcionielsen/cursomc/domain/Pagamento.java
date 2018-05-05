package br.com.marcionielsen.cursomc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.marcionielsen.cursomc.domain.enums.EstadoPagamento;
import br.com.marcionielsen.cursomc.util.Util;

@Entity
@Table(name = "PAGAMENTOS", 
       indexes = {@Index(name = "IDX_PAGTOS_CD_PEDIDO_DT_PAGTO", columnList = "CD_PEDIDO, DT_PAGAMENTO", unique = false) })
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "CD_STATUS_PAGAMENTO", nullable = false)
	private Integer estadoPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_PAGAMENTO", nullable = false)
	private Date dataPagamento;

	@Column(name = "VLR_FATURA", nullable = false)
	private BigDecimal valorFatura;

	@Column(name = "VLR_DESCONTO_PGTO", nullable = false)
	private BigDecimal valorDesconto;

	@Column(name = "VLR_JUROS_PGTO", nullable = false)
	private BigDecimal valorJuros;

	@Column(name = "VLR_MORA_PGTO", nullable = false)
	private BigDecimal valorMora;

	@Column(name = "VLR_MULTA_PGTO", nullable = false)
	private BigDecimal valorMulta;

	@OneToOne
	@JoinColumn(name = "CD_PEDIDO")
	@MapsId
	private Pedido pedido;

	public Pagamento() {
		super();
	}

	public Pagamento(Long id, Integer estadoPagamento, Date dataPagamento, BigDecimal valorFatura, BigDecimal valorDesconto,
			BigDecimal valorJuros, BigDecimal valorMora, BigDecimal valorMulta, Pedido pedido) {
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

	public BigDecimal getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(BigDecimal valorFatura) {
		this.valorFatura = valorFatura;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public BigDecimal getValorMora() {
		return valorMora;
	}

	public void setValorMora(BigDecimal valorMora) {
		this.valorMora = valorMora;
	}

	public BigDecimal getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
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
				+ ", dataPagamento=" + Util.formatoDataHora(dataPagamento.toInstant()) + ", valorFatura=" + Util.formatoMoeda(valorFatura)
				+ ", valorDesconto=" + Util.formatoMoeda(valorDesconto) + ", valorJuros=" + Util.formatoMoeda(valorJuros) 
				+ ", valorMora=" + Util.formatoMoeda(valorMora) + ", valorMulta=" + Util.formatoMoeda(valorMulta) + ", pedido=" + pedido + "]";
	}

}
