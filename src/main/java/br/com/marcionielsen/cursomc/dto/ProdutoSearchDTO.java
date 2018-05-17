package br.com.marcionielsen.cursomc.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoSearchDTO extends AbstrataDTO {
	private static final long serialVersionUID = 1L;

	private String descricao;
	private List<Long> listaCategorias = new ArrayList<>();;

	public ProdutoSearchDTO() {
	}

	public ProdutoSearchDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Long> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Long> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

}
