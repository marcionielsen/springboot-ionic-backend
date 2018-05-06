package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Bairro;
import br.com.marcionielsen.cursomc.repositories.interfaces.IBairroRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class BairroService implements IGenericaService<Bairro> {

	@Autowired
	private IBairroRepository repo;

	@Override
	public Bairro findById(Long id) {
		Optional<Bairro> bairro = repo.findById(id);

		return bairro.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Bairro.class.getName()));
	}

	@Override
	public List<Bairro> listAll() {
		List<Bairro> lista = repo.findAll();

		return lista;
	}

	@Override
	public Bairro insert(Bairro obj) {
		return null;
	}

	@Override
	public Bairro update(Bairro obj) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

}
