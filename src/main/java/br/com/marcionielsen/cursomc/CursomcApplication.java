package br.com.marcionielsen.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.marcionielsen.cursomc.domain.Bairro;
import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.domain.Cidade;
import br.com.marcionielsen.cursomc.domain.Cliente;
import br.com.marcionielsen.cursomc.domain.Endereco;
import br.com.marcionielsen.cursomc.domain.Estado;
import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.domain.enums.TipoCliente;
import br.com.marcionielsen.cursomc.repositories.interfaces.IBairroRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICategoriaRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICidadeRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEnderecoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEstadoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private ICategoriaRepository categRepo;

	@Autowired
	private IProdutoRepository prodtRepo;

	@Autowired
	private IEstadoRepository estadoRepo;

	@Autowired
	private ICidadeRepository cidadeRepo;

	@Autowired
	private IBairroRepository bairroRepo;

	@Autowired
	private IEnderecoRepository enderecoRepo;
	
	@Autowired
	private IClienteRepository clienteRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Material de Limpeza");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		Produto p4 = new Produto(null, "Caneta Azul", 4.50);
		Produto p5 = new Produto(null, "Clips Grande - CX. 100", 10.00);
		Produto p6 = new Produto(null, "Papel A4 - PCT", 35.00);

		Produto p7 = new Produto(null, "Vassoura", 10.00);
		Produto p8 = new Produto(null, "Sabão Liquido", 35.00);
		Produto p9 = new Produto(null, "Pano de Chão", 3.50);

		Estado e1 = new Estado(null, "Espirito Santo", "ES");
		Estado e2 = new Estado(null, "Rio de Janeiro", "RJ");
		Estado e3 = new Estado(null, "Minas Gerais", "MG");
		Estado e4 = new Estado(null, "São Paulo", "SP");

		Cidade c1 = new Cidade(null, "Vila Velha", e1);
		Cidade c2 = new Cidade(null, "Vitória", e1);
		Cidade c3 = new Cidade(null, "Guarapari", e1);

		Cidade c4 = new Cidade(null, "Rio de Janeiro", e2);
		Cidade c5 = new Cidade(null, "Niteroi", e2);
		Cidade c6 = new Cidade(null, "Campos dos Goytacazes", e2);

		Cidade c7 = new Cidade(null, "Belo Horizonte", e3);
		Cidade c8 = new Cidade(null, "Governador Valadares", e3);
		Cidade c9 = new Cidade(null, "Resplendor", e3);

		Cidade c10 = new Cidade(null, "São Paulo", e4);
		Cidade c11 = new Cidade(null, "Campinas", e4);
		Cidade c12 = new Cidade(null, "Ribeirão Preto", e4);

		Bairro b1 = new Bairro(null, "ARIBIRI", c1);
		Bairro b2 = new Bairro(null, "CENTRO", c1);
		Bairro b3 = new Bairro(null, "CENTRO", c2);
		Bairro b4 = new Bairro(null, "CENTRO", c3);
		
		Bairro b5 = new Bairro(null, "CENTRO", c4);
		Bairro b6 = new Bairro(null, "CENTRO", c5);
		Bairro b7 = new Bairro(null, "CENTRO", c6);
		Bairro b8 = new Bairro(null, "CENTRO", c7);
		Bairro b9 = new Bairro(null, "CENTRO", c8);
		Bairro b10 = new Bairro(null, "CENTRO", c9);
		Bairro b11 = new Bairro(null, "CENTRO", c10);
		Bairro b12 = new Bairro(null, "CENTRO", c11);
		Bairro b13 = new Bairro(null, "CENTRO", c12);
		
		Cliente cli1 = new Cliente(null, "Márcio Nielsen Baptista","marcio.nielsen@gmail.com", "858.260.737-72", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("(27) 3535-0475", "(27) 98182-7229"));
		
		Endereco ende1= new Endereco(null, "Av. Jerônimo Monteiro", "2551", "CASA", "29.120-002", b1, cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(ende1));
		
		c1.getBairros().addAll(Arrays.asList(b1, b2));
		c2.getBairros().addAll(Arrays.asList(b3));
		c3.getBairros().addAll(Arrays.asList(b4));
		c4.getBairros().addAll(Arrays.asList(b5));
		c5.getBairros().addAll(Arrays.asList(b6));
		c6.getBairros().addAll(Arrays.asList(b7));
		c7.getBairros().addAll(Arrays.asList(b8));
		c8.getBairros().addAll(Arrays.asList(b9));
		c9.getBairros().addAll(Arrays.asList(b10));
		c10.getBairros().addAll(Arrays.asList(b11));
		c11.getBairros().addAll(Arrays.asList(b12));
		c12.getBairros().addAll(Arrays.asList(b13));

		e1.getCidades().addAll(Arrays.asList(c1, c2, c3));
		e2.getCidades().addAll(Arrays.asList(c4, c5, c6));
		e3.getCidades().addAll(Arrays.asList(c7, c8, c9));
		e4.getCidades().addAll(Arrays.asList(c10, c11, c12));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4, p5, p6));
		cat3.getProdutos().addAll(Arrays.asList(p7, p8, p9));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p6.getCategorias().addAll(Arrays.asList(cat2));

		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat3));
		p9.getCategorias().addAll(Arrays.asList(cat3));

		estadoRepo.saveAll(Arrays.asList(e1, e2, e3, e4));
		cidadeRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
		bairroRepo.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13));
		
		clienteRepo.saveAll(Arrays.asList(cli1));
		enderecoRepo.saveAll(Arrays.asList(ende1));
		
		categRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		prodtRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
	}

}
