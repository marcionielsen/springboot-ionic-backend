package br.com.marcionielsen.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCliente(Integer cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente tipo : TipoCliente.values()) {
			
			if (cod.equals( tipo.getCodigo() ) ) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id ENUM Inválido: " + cod.intValue());
	}
}
