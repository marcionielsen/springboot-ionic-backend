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
import br.com.marcionielsen.cursomc.services.validation.annotations.ClienteUpdateValid;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdateValid, ClienteEnderecoTelefonesDTO> {

	@Autowired 
	private IClienteRepository repoCliente; 
	
	@Override
	public void initialize(ClienteUpdateValid ann) {
	}

	@Override
	public boolean isValid(ClienteEnderecoTelefonesDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getId() != null) {
			
			// inclua os testes aqui, inserindo erros na lista

			Cliente cliente = repoCliente.findByEmail(objDto.getEmail());
			
			// Validação de email duplicado, na atualização do cliente
			if (cliente != null && !cliente.getId().equals(objDto.getId())) {
				list.add(new FieldMessage("email", "Este e-mail, já está em uso por outro cliente!"));
			}
			
			for (FieldMessage e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getNomeCampo())
						.addConstraintViolation();
			}
			
		}
		
		return list.isEmpty();
	}
}
