package br.com.marcionielsen.cursomc.domain.enums;

public enum TipoTelefone {
	
	TELEFONE_PRINCIPAL(1, "Telefone Principal"), TELEFONE_COMERCIAL(2, "Telefone Comercial"), CELULAR_PRINCIPAL(1, "Celular Principal"), CELULAR_COMERCIAL(1, "Celular Comercial"),;
	
	private Integer codigo;
	private String descricao;
	
	private TipoTelefone(Integer cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoTelefone toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoTelefone tipo : TipoTelefone.values()) {
			
			if (cod.equals( tipo.getCodigo() ) ) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id ENUM Inválido: " + cod.intValue());
	}
}
