package br.com.marcionielsen.cursomc.domain;

import java.util.Date;

import br.com.marcionielsen.cursomc.util.Util;

public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dataVencimento;

	public PagamentoComBoleto() {
		super();
	}

	public PagamentoComBoleto(Long id, Integer estadoPagamento, Date dataPagamento, Double valorFatura,
			Double valorDesconto, Double valorJuros, Double valorMora, Double valorMulta, Pedido pedido,
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
