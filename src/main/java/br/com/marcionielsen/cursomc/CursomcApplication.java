package br.com.marcionielsen.cursomc;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
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
import br.com.marcionielsen.cursomc.domain.Fornecedor;
import br.com.marcionielsen.cursomc.domain.Pagamento;
import br.com.marcionielsen.cursomc.domain.PagamentoComBoleto;
import br.com.marcionielsen.cursomc.domain.PagamentoComCartao;
import br.com.marcionielsen.cursomc.domain.Pedido;
import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.domain.Vendedor;
import br.com.marcionielsen.cursomc.domain.enums.BandeiraCartao;
import br.com.marcionielsen.cursomc.domain.enums.EstadoPagamento;
import br.com.marcionielsen.cursomc.domain.enums.TipoCliente;
import br.com.marcionielsen.cursomc.repositories.interfaces.IBairroRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICategoriaRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICidadeRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IClienteRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEnderecoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IEstadoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IFornecedorRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IPagamentoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IPedidoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IProdutoRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IVendedorRepository;

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

	@Autowired
	private IFornecedorRepository fornecedorRepo;

	@Autowired
	private IVendedorRepository vendedorRepo;

	@Autowired
	private IPedidoRepository pedidoRepo;

	@Autowired
	private IPagamentoRepository pagamentoRepo;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Criação de Categorias, Produtos, Vendedores e Fornecedores
		Fornecedor f1 = new Fornecedor(null, "Logitec Brasil", "47.988.766/0001-90", "fale.conosco@logitec.com.br");
		Fornecedor f2 = new Fornecedor(null, "Asus Brasil", "79.363.261/0001-26", "fale.conosco@asus.com.br");
		Fornecedor f3 = new Fornecedor(null, "Hp Brasil", "05.424.247/0001-59", "fale.conosco@hp.com.br");
		Fornecedor f4 = new Fornecedor(null, "Gecore", "80.752.451/0001-14", "fale.conosco@gecore.com.br");
		Fornecedor f5 = new Fornecedor(null, "Makro", "66.721.898/0001-03", "fale.conosco@makro.com.br");

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Material de Limpeza");

		Produto p1 = new Produto(null, "Computador", BigDecimal.valueOf(2000.00), f2);
		Produto p2 = new Produto(null, "Impressora", BigDecimal.valueOf(800.00), f3);
		Produto p3 = new Produto(null, "Mouse", BigDecimal.valueOf(80.00), f1);

		Produto p4 = new Produto(null, "Caneta Azul", BigDecimal.valueOf(4.50), f4);
		Produto p5 = new Produto(null, "Clips Grande - CX. 100", BigDecimal.valueOf(10.00), f4);
		Produto p6 = new Produto(null, "Papel A4 - PCT", BigDecimal.valueOf(35.00), f4);

		Produto p7 = new Produto(null, "Vassoura", BigDecimal.valueOf(10.00), f5);
		Produto p8 = new Produto(null, "Sabão Liquido", BigDecimal.valueOf(35.00), f5);
		Produto p9 = new Produto(null, "Pano de Chão", BigDecimal.valueOf(3.50), f5);

		Vendedor v1 = new Vendedor(null, "José Carlos", "jose.carlos@gmail.com");
		Vendedor v2 = new Vendedor(null, "Maria Claudia", "maria.claudia@gmail.com");
		Vendedor v3 = new Vendedor(null, "Paulo Renato", "paulo.renato@gmail.com");
		Vendedor v4 = new Vendedor(null, "Fernanda da Silva", "fernanda.silva@gmail.com");

		v1.getTelefones().addAll(Arrays.asList("(27) 98081-8281"));
		v2.getTelefones().addAll(Arrays.asList("(27) 98071-8382"));
		v3.getTelefones().addAll(Arrays.asList("(27) 98061-8483"));
		v4.getTelefones().addAll(Arrays.asList("(27) 98091-8584"));

		// Criação de Estados, Cidades, Bairros, Clientes, Endereços dos clientes,
		// Fornecedores e Endereços dos fornecedores
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

		Bairro b14 = new Bairro(null, "BAIRRO INDUSTRIAL", c10);

		Cliente cli1 = new Cliente(null, "Márcio Nielsen Baptista", "marcio.nielsen@gmail.com", "858.260.737-72",
				TipoCliente.PESSOA_FISICA);

		Endereco ende1 = new Endereco(null, "Av. Jerônimo Monteiro", "2551", "CASA", "29.120-002", b1, cli1, null);

		// Ligação clientes com telefones
		cli1.getTelefones().addAll(Arrays.asList("(27) 3535-0475", "(27) 98182-7229"));

		// Ligação clientes com endereços
		cli1.getEnderecos().addAll(Arrays.asList(ende1));

		// Ligação de fornecedor com produtos
		f1.getProdutos().addAll(Arrays.asList(p3));
		f2.getProdutos().addAll(Arrays.asList(p1));
		f3.getProdutos().addAll(Arrays.asList(p2));
		f4.getProdutos().addAll(Arrays.asList(p4, p5, p6));
		f5.getProdutos().addAll(Arrays.asList(p7, p8, p9));

		// Ligação de fornecedor com telefones
		f1.getTelefones().addAll(Arrays.asList("(11) 3434-3500", "(11) 3434-3501"));
		f2.getTelefones().addAll(Arrays.asList("(11) 3434-3600", "(11) 3434-3602"));
		f3.getTelefones().addAll(Arrays.asList("(11) 3434-3700", "(11) 3434-3703"));
		f4.getTelefones().addAll(Arrays.asList("(27) 3535-3800", "(11) 3535-3804"));
		f5.getTelefones().addAll(Arrays.asList("(27) 3535-3900", "(11) 3535-3905"));

		// Endereços dos fornecedores
		Endereco endeFornec1 = new Endereco(null, "Rua Projetada", "1", "Quadra A", "03135-020", b14, null, f1);
		Endereco endeFornec2 = new Endereco(null, "Rua Projetada", "2", "Quadra B", "06541-035", b14, null, f2);
		Endereco endeFornec3 = new Endereco(null, "Rua Projetada", "3", "Quadra C", "04535-005", b14, null, f3);
		Endereco endeFornec4 = new Endereco(null, "Rua Antonio Ataide", "53", "Loja A", "29704-438", b2, null, f4);
		Endereco endeFornec5 = new Endereco(null, "Av. Carlos Lindemberg", "S/N", "Lote A", "29908-280", b1, null, f5);

		// Ligação de fornecedores com endereços
		f1.getFiliais().addAll(Arrays.asList(endeFornec1));
		f2.getFiliais().addAll(Arrays.asList(endeFornec2));
		f3.getFiliais().addAll(Arrays.asList(endeFornec3));
		f4.getFiliais().addAll(Arrays.asList(endeFornec4));
		f5.getFiliais().addAll(Arrays.asList(endeFornec5));

		// Ligação de cidades com bairros
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

		// Ligação de estados com cidades
		e1.getCidades().addAll(Arrays.asList(c1, c2, c3));
		e2.getCidades().addAll(Arrays.asList(c4, c5, c6));
		e3.getCidades().addAll(Arrays.asList(c7, c8, c9));
		e4.getCidades().addAll(Arrays.asList(c10, c11, c12));

		// Ligação de categorias com produtos
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4, p5, p6));
		cat3.getProdutos().addAll(Arrays.asList(p7, p8, p9));

		// Ligação de produtos com categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat3));
		p9.getCategorias().addAll(Arrays.asList(cat3));

		Pedido ped1 = new Pedido(null, Date.valueOf(LocalDate.now(ZoneId.systemDefault())), null, cli1, ende1);
		Pedido ped2 = new Pedido(null, Date.valueOf(LocalDate.now(ZoneId.systemDefault())), null, cli1, ende1);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO.getCodigo(),
				Date.valueOf(LocalDate.now(ZoneId.systemDefault())), BigDecimal.valueOf(350.00), BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, ped1, 6, BigDecimal.valueOf(350.00 / 6),
				BandeiraCartao.MASTER_CARD.getCodigo());

		Date dataSistema = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE.getCodigo(), dataSistema,
				BigDecimal.valueOf(700.00), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, ped2,
				dataSistema);

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		
		// Gravação dos registros no banco H2DB
		vendedorRepo.saveAll(Arrays.asList(v1, v2, v3, v4));

		estadoRepo.saveAll(Arrays.asList(e1, e2, e3, e4));
		cidadeRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
		bairroRepo.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14));

		clienteRepo.saveAll(Arrays.asList(cli1));
		enderecoRepo.saveAll(Arrays.asList(ende1));

		fornecedorRepo.saveAll(Arrays.asList(f1, f2, f3, f4, f5));
		enderecoRepo.saveAll(Arrays.asList(endeFornec1, endeFornec2, endeFornec3, endeFornec4, endeFornec5));

		categRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		prodtRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
		
		pedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepo.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
