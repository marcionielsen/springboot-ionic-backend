package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Fornecedor;
import br.com.marcionielsen.cursomc.repositories.interfaces.IFornecedorRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class FornecedorService implements IGenericaService<Fornecedor> {

	@Autowired
	private IFornecedorRepository repo;

	@Override
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> fornecedor = repo.findById(id);

		return fornecedor.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! -> (Id: " + id + ", Tipo: " + Fornecedor.class.getName() + ")"));
	}

	@Override
	public List<Fornecedor> listAll() {
		List<Fornecedor> lista = repo.findAll();

		return lista;
	}

	@Override
	public Fornecedor inserir(Fornecedor obj) {
		return null;
	}

	@Override
	public Fornecedor editar(Fornecedor obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {

	}

}
