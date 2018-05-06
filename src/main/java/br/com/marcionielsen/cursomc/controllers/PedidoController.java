package br.com.marcionielsen.cursomc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Pedido;
import br.com.marcionielsen.cursomc.dto.PedidoDTO;
import br.com.marcionielsen.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController extends AbstrataController implements IGenericaController<Pedido, PedidoDTO> {

	@Autowired
	private PedidoService pedidoService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {

		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> listAll() {

		List<Pedido> lista = pedidoService.listAll();
		
		List<PedidoDTO> listaDTO = lista.stream().map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	@Override
	public ResponseEntity<Page<PedidoDTO>> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		return null;
	}

	@Override
	public ResponseEntity<Void> insert(PedidoDTO obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(Long id, PedidoDTO obj) {
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		return null;
	}

}
