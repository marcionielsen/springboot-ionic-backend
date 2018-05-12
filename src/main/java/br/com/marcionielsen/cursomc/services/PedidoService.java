package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Pedido;
import br.com.marcionielsen.cursomc.dto.PedidoDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IPedidoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class PedidoService {

	@Autowired
	private IPedidoRepository repo;

	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repo.findById(id);

		return pedido.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Pedido.class.getName()));
	}

	public List<Pedido> listAll() {
		List<Pedido> lista = repo.findAll();

		return lista;
	}

	public Page<Pedido> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	public Pedido insert(Pedido obj) {
		return null;
	}

	public Pedido update(Pedido obj) {
		return null;
	}

	public void delete(Long id) {
	}

	public Pedido fromDTO(PedidoDTO obj) {
		return null;
	}

}
