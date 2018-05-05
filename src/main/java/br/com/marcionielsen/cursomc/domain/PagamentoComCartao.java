package br.com.marcionielsen.cursomc.domain;

import java.util.Date;

import br.com.marcionielsen.cursomc.domain.enums.BandeiraCartao;

public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;
	private Double valorParcela;
	private Integer bandeiraCartao;

	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Long id, Integer estadoPagamento, Date dataPagamento, Double valorFatura,
			Double valorDesconto, Double valorJuros, Double valorMora, Double valorMulta, Pedido pedido,
			Integer numeroParcelas, Double valorParcela, Integer bandeiraCartao) {
		super(id, estadoPagamento, dataPagamento, valorFatura, valorDesconto, valorJuros, valorMora, valorMulta,
				pedido);

		this.numeroParcelas = numeroParcelas;
		this.valorParcela = valorParcela;
		this.bandeiraCartao = bandeiraCartao;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public BandeiraCartao getBandeiraCartao() {
		return BandeiraCartao.toEnum(bandeiraCartao);
	}

	public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao.getCodigo();
	}

	@Override
	public String toString() {
		return "PagamentoComCartao [ " + super.toString() + ", numeroParcelas=" + numeroParcelas + ", valorParcela="
				+ valorParcela + ", bandeiraCartao=" + BandeiraCartao.toEnum(bandeiraCartao).getDescricao() + "]";
	}

}
