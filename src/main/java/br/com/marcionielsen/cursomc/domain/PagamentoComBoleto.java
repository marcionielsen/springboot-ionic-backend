package br.com.marcionielsen.cursomc.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.marcionielsen.cursomc.util.Util;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_VENCIMENTO", nullable = false)
	private Date dataVencimento;

	public PagamentoComBoleto() {
		super();
	}

	public PagamentoComBoleto(Long id, Integer estadoPagamento, Date dataPagamento, BigDecimal valorFatura,
			BigDecimal valorDesconto, BigDecimal valorJuros, BigDecimal valorMora, BigDecimal valorMulta, Pedido pedido,
			Date dataVencimento) {
		super(id, estadoPagamento, dataPagamento, valorFatura, valorDesconto, valorJuros, valorMora, valorMulta,
				pedido);
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "PagamentoComBoleto [ " + super.toString() + ", dataVencimento="
				+ Util.formatoDataHora(dataVencimento.toInstant()) + "]";
	}

}
