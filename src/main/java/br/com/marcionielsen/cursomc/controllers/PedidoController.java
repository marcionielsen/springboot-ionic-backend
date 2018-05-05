package br.com.marcionielsen.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcionielsen.cursomc.controllers.interfaces.IGenericaController;
import br.com.marcionielsen.cursomc.domain.Pedido;
import br.com.marcionielsen.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController implements IGenericaController<Pedido> {

	@Autowired
	private PedidoService pedidoService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

	@Override
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {

		List<Pedido> lista = pedidoService.listAll();
		return ResponseEntity.ok().body(lista);
	}

	@Override
	public ResponseEntity<Void> inserir(Pedido obj) {
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
