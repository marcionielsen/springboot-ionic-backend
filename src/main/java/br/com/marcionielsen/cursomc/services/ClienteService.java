package br.com.marcionielsen.cursomc.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.marcionielsen.cursomc.domain.Bairro;
import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.domain.Endereco;
import br.com.marcionielsen.cursomc.domain.Estado;
import br.com.marcionielsen.cursomc.dto.ClienteDTO;
import br.com.marcionielsen.cursomc.dto.ClienteEnderecoTelefonesDTO;
import br.com.marcionielsen.cursomc.repositories.interfaces.IBairroRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICidadeRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEnderecoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEstadoRepository;
import br.com.marcionielsen.cursomc.services.exceptions.IntegridadeDadosException;
import br.com.marcionielsen.cursomc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {

	@Autowired
	private IClienteRepository repo;

	@Autowired
	private IEnderecoRepository repoEndereco;

	@Autowired
	private IBairroRepository repoBairro;

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

		repoEndereco.saveAll(saveObj.getEnderecos());

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
		System.out.println("//============================================================================");
		System.out.println(">> Carregando dados fromDTO toCliente << ");
		System.out.println("//----------------------------------------------------------------------------");
		System.out.println(">>-->> Criando o Cliente");
		System.out.println("new Cliente(" + obj.getId() + ", '" + obj.getNome() + "', '" + obj.getEmail() + "', '"
				+ obj.getCpfCnpj() + "', '" + obj.getTipo().toString() + "' );");

		// Criando o Cliente
		Cliente cli = new Cliente(obj.getId(), obj.getNome(), obj.getEmail(), obj.getCpfCnpj(), obj.getTipo());

		System.out.println("\n>> Obtendo o UF");
		// Obtendo o UF, a Cidade e o Bairro
		Estado uf = repoUF.findById(obj.getEstadoId()).orElseThrow(
				() -> new ObjetoNaoEncontradoException(obj.getEstadoId().toString(), Estado.class.getName()));

		System.out.println("\nUF = " + uf.getId().toString() + " - " + uf.getNome() + " - " + uf.getSigla());

		System.out.println("\n>>-->> Obtendo a Cidade");
		System.out.println(" -->> Criando o filtro");

		Cidade cidex = new Cidade();
		cidex.setEstado(uf);
		cidex.setNome(obj.getNomeCidade());

		ExampleMatcher exmtCidade = ExampleMatcher.matching()
				.withMatcher("nome", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.STARTING, true))
				.withMatcher("estado.id", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT, false));

		Example<Cidade> exCidade = Example.of(cidex, exmtCidade);

		System.out.println("    -->> Executando pesquisa no H2DB --> nomeCidade: " + obj.getNomeCidade() + " - ufId: "
				+ uf.getId());
		Cidade cidade = repoCidade.findOne(exCidade).orElse(new Cidade(null, obj.getNomeCidade(), uf));

		// findByNomeAndUF(obj.getNomeCidade(), uf.getId())
		// .orElse(new Cidade(null, obj.getNomeCidade(), uf));

		// .orElseThrow(() -> new
		// ObjetoNaoEncontradoException(obj.getEstado().toString(),
		// Estado.class.getName()));

		System.out.println("\nCIDADE = " + cidade.getId().toString() + " - " + cidade.getNome() + " - "
				+ cidade.getEstado().getSigla());

		System.out.println("\n>>-->> Obtendo o Bairro");
		System.out.println(" -->> Criando o filtro");

		Bairro bairex = new Bairro();
		bairex.setCidade(cidade);
		bairex.setNome(obj.getNomeBairro());

		ExampleMatcher exmtBairro = ExampleMatcher.matching()
				.withMatcher("nome", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.STARTING, true))
				.withMatcher("cidade.id", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT, false));

		Example<Bairro> exBairro = Example.of(bairex, exmtBairro);

		System.out.println("    -->> Executando pesquisa no H2DB --> nomeBairro: " + obj.getNomeBairro()
				+ " - cidadeId: " + cidade.getId());
		Bairro bairro = repoBairro.findOne(exBairro).orElse(new Bairro(null, obj.getNomeBairro(), cidade));

		// findByNomeAndCidadeId(obj.getNomeBairro(), cidade.getId())
		// .orElse(new Bairro(null, obj.getNomeBairro(), cidade));

		System.out.println("\nBAIRRO = " + bairro.getId().toString() + " - " + bairro.getNome() + " - "
				+ bairro.getCidade().getNome());

		System.out.println("\n");
		System.out.println("//----------------------------------------------------------------------------");
		System.out.println(">>-->> Ligando a Cidade ao UF");
		// Ligando a Cidade ao UF
		uf.getCidades().addAll(Arrays.asList(cidade));

		System.out.println(">>-->> Ligando o Bairro à Cidade");
		// Ligando o Bairro à Cidade
		cidade.getBairros().addAll(Arrays.asList(bairro));

		System.out.println("//----------------------------------------------------------------------------");
		System.out.println(">>-->> Criando/Obtendo o Endereço do Cliente");
		System.out.println(" -->> Criando o filtro");

		// Criando o Endereço do Cliente
		Endereco endex = new Endereco();
		endex.setLogradouro(obj.getLogradouro());
		endex.setNumero(obj.getNumero());
		//endex.setComplemento(obj.getComplemento());
		endex.setCep(obj.getCep());
		//endex.setFornecedor(null);
		//endex.setCliente(cli);

		ExampleMatcher exmtEndereco = ExampleMatcher.matching()
				.withMatcher("logradouro", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.STARTING, true))
				.withMatcher("numero", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT, true))
				.withMatcher("cep", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT, true))
//				.withMatcher("cliente.id", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT, false))
				;

		Example<Endereco> exEndereco = Example.of(endex, exmtEndereco);

		System.out.println("    -->> Executando pesquisa no H2DB --> logradouro: " + obj.getLogradouro() + " - numero: " + obj.getNumero() + " - cep: " + obj.getCep());
		Endereco ende = repoEndereco.findOne(exEndereco).orElse(new Endereco(null, obj.getLogradouro(), obj.getNumero(),
				obj.getComplemento(), obj.getCep(), bairro, cli, null));

//				.orElseThrow(() -> new ObjetoNaoEncontradoException(obj.getLogradouro() + " - " + obj.getNumero() + " - " + obj.getCep(),
//				 Endereco.class.getName()));


		// .findByLogradAndNumAndCepAndClienteId(obj.getLogradouro(), obj.getNumero(),
		// obj.getCep(), cli.getId())
		// .orElse(new Endereco(null, obj.getLogradouro(), obj.getNumero(),
		// obj.getComplemento(), obj.getCep(),
		// bairro, cli, null));

		ende.setCliente(cli);
		
		System.out.println("\nENDERECO = " + 
		                   "\n - logradouro: " + ende.getLogradouro() +
				           "\n - numero: " + ende.getNumero() +
				           "\n - complemento: " + ende.getComplemento() + 
 				           "\n - cep: " +  ende.getCep() + 
				           "\n - bairro: " + ende.getBairro().getNome() + 
				           "\n - cidade: " + ende.getBairro().getCidade().getNome() + 
				           "\n - UF: " + ende.getBairro().getCidade().getEstado().getNome() 
//				           + "\n - Cliente: " + ende.getCliente().getId().toString() + " - " + ende.getCliente().getNome() 
				 );

		System.out.println("\n");
		System.out.println("//----------------------------------------------------------------------------");
		System.out.println(">>-->> Ligando o Endereço ao Cliente");
		// Ligando o Endereço ao Cliente
		cli.getEnderecos().addAll(Arrays.asList(ende));

		System.out.println("\n");
		System.out.println("//----------------------------------------------------------------------------");
		System.out.println(
				">>-->> Limpando o Set Original de Telefones (eliminando valores NULOS) e ligando os telefones ao Cliente");
		// Limpando o Set Original de Telefones (eliminando valores NULOS) e ligando os
		// telefones ao Cliente
		obj.getTelefones().stream().filter(telefoneOri -> telefoneOri != null && !"".equals(telefoneOri))
				.forEach(telefoneOri -> cli.getTelefones().add(telefoneOri));

		System.out.println("\n");
		System.out.println("//----------------------------------------------------------------------------");
		System.out.println(">>-->> Retornando o Cliente");
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
