package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.repositories.interfaces.IProdutoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class ProdutoService implements IGenericaService<Produto> {

	@Autowired
	private IProdutoRepository repo;

	@Override
	public Produto findById(Long id) {
		Optional<Produto> produto = repo.findById(id);

		return produto.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! -> (Id: " + id + ", Tipo: " + Produto.class.getName() + ")"));
	}

	@Override
	public List<Produto> listAll() {
		List<Produto> lista = repo.findAll();

		return lista;
	}

	@Override
	public Produto inserir(Produto obj) {
		return null;
	}

	@Override
	public Produto editar(Produto obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {
	}

}
