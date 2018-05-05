package br.com.marcionielsen.cursomc.domain.enums;

public enum BandeiraCartao {
	MASTER_CARD(1, "Master Card"), VISA(2, "Visa"), CIELO(3, "Cielo"), 
	AMERICAN_EXPRESS(4, "American Express"), BANESCARD(5, "Banescard"), 
	DACASA(6, "Dacasa");

	private Integer codigo;
	private String descricao;

	private BandeiraCartao(Integer cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static BandeiraCartao toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (BandeiraCartao bandeira : BandeiraCartao.values()) {

			if (cod.equals(bandeira.getCodigo())) {
				return bandeira;
			}
		}

		throw new IllegalArgumentException("Id ENUM Inválido: " + cod.intValue());
	}

}
