package br.com.marcionielsen.cursomc.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.marcionielsen.cursomc.domain.enums.BandeiraCartao;
import br.com.marcionielsen.cursomc.util.Util;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	@Column(name = "QTD_PARCELAS", nullable = false)
	private Integer numeroParcelas;

	@Column(name = "VLR_PARCELA", nullable = false)
	private BigDecimal valorParcela;

	@Column(name = "CD_BANDEIRA_CARTAO", nullable = false)
	private Integer bandeiraCartao;

	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Long id, Integer estadoPagamento, Date dataPagamento, BigDecimal valorFatura,
			BigDecimal valorDesconto, BigDecimal valorJuros, BigDecimal valorMora, BigDecimal valorMulta, Pedido pedido,
			Integer numeroParcelas, BigDecimal valorParcela, Integer bandeiraCartao) {
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

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
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
				+ Util.formatoMoeda(valorParcela) + ", bandeiraCartao="
				+ BandeiraCartao.toEnum(bandeiraCartao).getDescricao() + "]";
	}

}
