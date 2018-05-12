package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Vendedor;
import br.com.marcionielsen.cursomc.dto.VendedorDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IVendedorRepository;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class VendedorService {

	@Autowired
	private IVendedorRepository repo;

	public Vendedor findById(Long id) {
		Optional<Vendedor> vendedor = repo.findById(id);

		return vendedor.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Vendedor.class.getName()));
	}

	public List<Vendedor> listAll() {
		List<Vendedor> lista = repo.findAll();

		return lista;
	}

	public Page<Vendedor> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		return null;
	}

	public Vendedor insert(Vendedor obj) {
		return null;
	}

	public Vendedor update(Vendedor obj) {
		return null;
	}

	public void delete(Long id) {

	}

	public Vendedor fromDTO(VendedorDTO obj) {
		return null;
	}
	
}
