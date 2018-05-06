package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Vendedor;
import br.com.marcionielsen.cursomc.repositories.interfaces.IVendedorRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class VendedorService implements IGenericaService<Vendedor> {

	@Autowired
	private IVendedorRepository repo;

	@Override
	public Vendedor findById(Long id) {
		Optional<Vendedor> vendedor = repo.findById(id);

		return vendedor.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Vendedor.class.getName()));
	}

	@Override
	public List<Vendedor> listAll() {
		List<Vendedor> lista = repo.findAll();

		return lista;
	}

	@Override
	public Vendedor insert(Vendedor obj) {
		return null;
	}

	@Override
	public Vendedor update(Vendedor obj) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

}
