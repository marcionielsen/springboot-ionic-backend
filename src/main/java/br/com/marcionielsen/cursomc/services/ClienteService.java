package br.com.marcionielsen.cursomc.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Bairro;
import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.domain.Endereco;
import br.com.marcionielsen.cursomc.domain.Estado;
import br.com.marcionielsen.cursomc.domain.enums.TipoCliente;
import br.com.marcionielsen.cursomc.dto.ClienteDTO;
import br.com.marcionielsen.cursomc.dto.ClienteEnderecoTelefonesDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICidadeRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEnderecoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEstadoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.IntegridadeDadosException;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService  {

	@Autowired
	private IClienteRepository repo;

	@Autowired
	private IEnderecoRepository repoEndereco;

	@Autowired
	private ICidadeRepository repoCidade;

	@Autowired
	private IEstadoRepository repoUF;


	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repo.findById(id);

		return cliente.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Cliente.class.getName()));
	}

	public List<Cliente> listAll() {
		List<Cliente> lista = repo.findAll();

		return lista;
	}

	public Page<Cliente> listPerPage(Integer numPage, Integer numLines, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(numPage, numLines, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	public Cliente insert(ClienteEnderecoTelefonesDTO obj) {

		Cliente newObj = repo.save(fromDTO(obj));
		
		repoEndereco.saveAll(newObj.getEnderecos());
		
		return newObj;
	}

	public Cliente update(ClienteEnderecoTelefonesDTO obj) {
		
		Cliente newObj = this.findById(obj.getId());

		updateData(newObj, fromDTO(obj));

		Cliente saveObj = repo.save(newObj);
		
		return saveObj;
	}

	public void delete(Long id) {
		findById(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new IntegridadeDadosException(id.toString(), Cliente.class.getName());
		}
	}

	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(obj);
	}

	public Cliente fromDTO(ClienteEnderecoTelefonesDTO obj) {
		// Criando o Cliente
		Cliente cli = new Cliente(obj.getId(),obj.getNome(), obj.getEmail(), obj.getCpfCnpj(),TipoCliente.toEnum(obj.getTipo()) );
		
		// Criando a UF, a Cidade e o Bairro 
		Estado uf = repoUF.findById(obj.getEstado()).orElseThrow(() -> new ObjetoNaoEncontradoException(obj.getEstado().toString(), Estado.class.getName()));
		
		Cidade cidade = repoCidade.findById(obj.getCidade()).orElseThrow(() -> new ObjetoNaoEncontradoException(obj.getCidade().toString(), Cidade.class.getName()));
		
		Bairro bairro = new Bairro(obj.getBairro(), null, cidade);

		// Ligando a Cidade ao UF
		uf.getCidades().addAll(Arrays.asList(cidade));
		
		// Ligando o Bairro à Cidade
		cidade.getBairros().addAll(Arrays.asList(bairro));
		
		// Criando o Endereço do Cliente
		Endereco ende = new Endereco(null, obj.getLogradouro(), obj.getNumero(), obj.getComplemento(), obj.getCep(), bairro, cli, null);
				
		// Ligando o Endereço ao Cliente
		cli.getEnderecos().addAll(Arrays.asList(ende));
		
	    // Limpando o Set Original de Telefones (eliminando valores NULOS) e ligando os telefones ao Cliente
		obj.getTelefones().stream().filter(telefoneOri -> telefoneOri != null && !"".equals(telefoneOri)).forEach(telefoneOri -> cli.getTelefones().add(telefoneOri));
		
		return cli;
	}

	public Cliente fromEntity(Cliente Obj) {
		
		return Obj;		
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setCpfCnpj(obj.getCpfCnpj());
		newObj.setTipo(obj.getTipo());
		
		newObj.setEnderecos(obj.getEnderecos());
		newObj.setTelefones(obj.getTelefones());
	}
}
