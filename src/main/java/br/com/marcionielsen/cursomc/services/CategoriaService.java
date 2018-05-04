package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICategoriaRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class CategoriaService implements IGenericaService<Categoria> {

	@Autowired
	private ICategoriaRepository repo;

	@Override
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repo.findById(id);

		return categoria.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! -> (Id: " + id + ", Tipo: " + Categoria.class.getName() + ")") );
	}

	@Override
	public List<Categoria> listAll() {
		List<Categoria> lista = repo.findAll();

		return lista;
	}

	@Override
	public Categoria inserir(Categoria obj) {
		return null;
	}

	@Override
	public Categoria editar(Categoria obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
