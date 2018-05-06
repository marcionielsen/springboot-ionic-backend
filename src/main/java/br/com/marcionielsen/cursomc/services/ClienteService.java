package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.dto.ClienteDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class ClienteService implements IGenericaService<Cliente, ClienteDTO> {

	@Autowired
	private IClienteRepository repo;

	@Override
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repo.findById(id);

		return cliente.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Cliente.class.getName()));
	}

	@Override
	public List<Cliente> listAll() {
		List<Cliente> lista = repo.findAll();

		return lista;
	}

	@Override
	public Page<Cliente> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	@Override
	public Cliente insert(Cliente obj) {
		return null;
	}

	@Override
	public Cliente update(Cliente obj) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public Cliente fromDTO(ClienteDTO obj) {
		return null;
	}

}
