package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Pedido;
import br.com.marcionielsen.cursomc.repositories.interfaces.IPedidoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class PedidoService implements IGenericaService<Pedido> {

	@Autowired
	private IPedidoRepository repo;

	@Override
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repo.findById(id);

		return pedido.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Pedido.class.getName()) );
	}

	@Override
	public List<Pedido> listAll() {
		List<Pedido> lista = repo.findAll();

		return lista;
	}

	@Override
	public Pedido inserir(Pedido obj) {
		return null;
	}

	@Override
	public Pedido editar(Pedido obj) {
		return null;
	}

	@Override
	public void excluir(Long id) {
	}

}
