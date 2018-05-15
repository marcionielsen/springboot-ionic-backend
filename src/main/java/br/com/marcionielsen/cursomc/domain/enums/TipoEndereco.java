package br.com.marcionielsen.cursomc.domain.enums;

public enum TipoEndereco {
	
	ENDERECO_PRINCIPAL(1, "Endereço Principal"), ENDERECO_COBRANCA(2, "Endereço Cobrança"), ENDERECO_ENTREGA(3, "Endereço Entrega"), ENDERECO_DEVOLUCAO(4, "Endereço Devolução");
	
	private Integer codigo;
	private String descricao;
	
	private TipoEndereco(Integer cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoEndereco toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoEndereco tipo : TipoEndereco.values()) {
			
			if (cod.equals( tipo.getCodigo() ) ) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id ENUM Inválido: " + cod.intValue());
	}
}
