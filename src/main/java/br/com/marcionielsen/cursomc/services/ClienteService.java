package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.dto.ClienteDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.services.exceptions.IntegridadeDadosException;
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
		PageRequest pageRequest = PageRequest.of(numPage, numLines, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	@Override
	public Cliente insert(Cliente obj) {
		return null;
	}

	@Override
	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}

	@Override
	public void delete(Long id) {
		findById(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new IntegridadeDadosException(id.toString(), Cliente.class.getName());
		}
	}

	@Override
	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(obj);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
