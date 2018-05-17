package br.com.marcionielsen.cursomc.dto;

import java.math.BigDecimal;

import br.com.marcionielsen.cursomc.domain.Produto;

public class ProdutoDTO extends AbstrataDTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private BigDecimal precoCusto;

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.precoCusto = obj.getPrecoCusto();		
	}

	public ProdutoDTO(Long id, String descricao, BigDecimal precoCusto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
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

}
