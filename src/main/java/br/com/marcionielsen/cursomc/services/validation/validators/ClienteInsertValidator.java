package br.com.marcionielsen.cursomc.services.validation.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.marcionielsen.cursomc.controllers.exceptions.FieldMessage;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.dto.ClienteEnderecoTelefonesDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.services.validation.annotations.ClienteInsertValid;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsertValid, ClienteEnderecoTelefonesDTO> {

	@Autowired 
	private IClienteRepository repoCliente; 
	
	@Override
	public void initialize(ClienteInsertValid ann) {
	}

	@Override
	public boolean isValid(ClienteEnderecoTelefonesDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista

		Cliente cliente = repoCliente.findByEmail(objDto.getEmail());
		
		if (cliente != null ) {
			list.add(new FieldMessage("email", "Este e-mail, já está em uso por outro cliente!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getNomeCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
