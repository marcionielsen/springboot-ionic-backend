package br.com.marcionielsen.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.marcionielsen.cursomc.domain.Categoria;
import br.com.marcionielsen.cursomc.domain.Produto;
import br.com.marcionielsen.cursomc.repositories.interfaces.ICategoriaRepository;
import br.com.marcionielsen.cursomc.repositories.interfaces.IProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private ICategoriaRepository categRepo;

	@Autowired
	private IProdutoRepository prodtRepo;

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

		categRepo.saveAll(Arrays.asList(cat1, cat2, cat3));

		prodtRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
	}

}
