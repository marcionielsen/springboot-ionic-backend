package br.com.marcionielsen.cursomc.services.validation.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.marcionielsen.cursomc.controllers.exceptions.FieldMessage;
import br.com.marcionielsen.cursomc.domain.enums.TipoCliente;
import br.com.marcionielsen.cursomc.dto.ClienteEnderecoTelefonesDTO;
import br.com.marcionielsen.cursomc.services.validation.annotations.IsCpfCnpjValid;
import br.com.marcionielsen.cursomc.services.validation.util.Utilitario;

public class CpfCnpjValidator implements ConstraintValidator<IsCpfCnpjValid, ClienteEnderecoTelefonesDTO> {

	@Override
	public void initialize(IsCpfCnpjValid ann) {
	}

	@Override
	public boolean isValid(ClienteEnderecoTelefonesDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista

		if (TipoCliente.PESSOA_FISICA.getCodigo().equals(objDto.getTipo())
				&& !Utilitario.isValidCPF(objDto.getCpfCnpj())) {
			
			list.add(new FieldMessage("cpfCnpj", "CPF inválido!"));
		}

		if (TipoCliente.PESSOA_JURIDICA.getCodigo().equals(objDto.getTipo())
				&& !Utilitario.isValidCNPJ(objDto.getCpfCnpj())) {
			
			list.add(new FieldMessage("cpfCnpj", "CNPJ inválido!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getNomeCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
