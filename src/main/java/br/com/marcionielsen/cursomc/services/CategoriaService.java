package br.com.marcionielsen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.dto.CategoriaDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICategoriaRepository;
import br.com.marcionielsen.cursomc.services.exceptions.IntegridadeDadosException;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;
import br.com.marcionielsen.cursomc.services.interfaces.IGenericaService;

@Service
public class CategoriaService extends AbstrataService<Categoria> implements IGenericaService<Categoria, CategoriaDTO> {

	@Autowired
	private ICategoriaRepository repo;

	@Override
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repo.findById(id);

		return categoria.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Categoria.class.getName()));
	}

	@Override
	public List<Categoria> listAll() {
		List<Categoria> lista = repo.findAll();

		return lista;
	}

	@Override
	public Page<Categoria> listPerPage(Integer numPage, Integer linesPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(numPage, linesPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	@Override
	public Categoria insert(Categoria obj) {

		obj.setId(null);

		return repo.save(obj);
	}

	@Override
	public Categoria update(Categoria obj) {
		Categoria newObj = findById(obj.getId());
		
		this.updateData(newObj, obj);
		
		return repo.save(obj);
	}

	@Override
	public void delete(Long id) {
		findById(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new IntegridadeDadosException(id.toString(), Categoria.class.getName());
		}
	}

	@Override
	public Categoria fromDTO(CategoriaDTO obj) {
		return new Categoria(obj.getId(), obj.getNome());
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
}
