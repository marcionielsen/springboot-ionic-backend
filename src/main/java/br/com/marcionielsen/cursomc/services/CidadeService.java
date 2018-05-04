package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICidadeRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class CidadeService implements IGenericaService<Cidade> {

	@Autowired
	private ICidadeRepository repo;

	@Override
	public Cidade findById(Long id) {
		Optional<Cidade> cidade = repo.findById(id);

		return cidade.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! -> (Id: " + id + ", Tipo: " + Cidade.class.getName() + ")"));
	}

	@Override
	public List<Cidade> listAll() {
		List<Cidade> lista = repo.findAll();

		return lista;
	}

	@Override
	public Cidade inserir(Cidade obj) {
		return null;
	}

	@Override
	public Cidade editar(Cidade obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
