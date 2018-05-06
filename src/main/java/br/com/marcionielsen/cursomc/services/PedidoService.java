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
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class PedidoService implements IGenericaService<Pedido, PedidoDTO> {

	@Autowired
	private IPedidoRepository repo;

	@Override
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repo.findById(id);

		return pedido.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Pedido.class.getName()));
	}

	@Override
	public List<Pedido> listAll() {
		List<Pedido> lista = repo.findAll();

		return lista;
	}

	@Override
	public Page<Pedido> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	@Override
	public Pedido insert(Pedido obj) {
		return null;
	}

	@Override
	public Pedido update(Pedido obj) {
		return null;
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public Pedido fromDTO(PedidoDTO obj) {
		return null;
	}

}
