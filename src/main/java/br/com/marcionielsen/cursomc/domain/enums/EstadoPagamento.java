package br.com.marcionielsen.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");
	
	private Integer codigo;
	private String descricao;
	
	private EstadoPagamento(Integer cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento status : EstadoPagamento.values()) {
			
			if (cod.equals( status.getCodigo() ) ) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("Id ENUM Inválido: " + cod.intValue());
	}
}
