package com.romario.supercopo.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.supercopo.domian.Categoria;
import com.romario.supercopo.domian.Estoque;
import com.romario.supercopo.domian.ItemEstoque;
import com.romario.supercopo.domian.Produto;
import com.romario.supercopo.repository.CategoriaRepository;
import com.romario.supercopo.repository.EstoqueRepository;
import com.romario.supercopo.repository.ItemEstoqueRepository;
import com.romario.supercopo.repository.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ItemEstoqueRepository itemEstoqueRepository;
	
	public void  instantiateTestDatabase() throws ParseException {
	
		Categoria cat1 = new Categoria(null, "Embalagem");
		Categoria cat2= new Categoria(null, "Caixa");
		
		Produto prod1 = new Produto(null, "copo ECO6L");
		Produto prod2 = new Produto(null, "copo ECO4L");
		Produto prod3 = new Produto(null, "copo LONG DRING");
		Produto prod4 = new Produto(null, "ECO6L");
		Produto prod5 = new Produto(null, "ECO4L");
		Produto prod6 = new Produto(null, " LONG DRING");
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		prod4.getCategorias().addAll(Arrays.asList(cat2));
		prod5.getCategorias().addAll(Arrays.asList(cat2));
		prod6.getCategorias().addAll(Arrays.asList(cat2));
		
	
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6));
		
		Estoque est1 = new Estoque(null, "Caixas");
		Estoque est2 = new Estoque(null, "Caixas");
		Estoque est3 = new Estoque(null, "Caixas");
		Estoque est4 = new Estoque(null, "Empalagem");
		Estoque est5 = new Estoque(null, "Empalagem");
		Estoque est6 = new Estoque(null, "Empalagem");		
		estoqueRepository.saveAll(Arrays.asList(est1,est2,est3,est4,est5,est6));
		
		
		ItemEstoque iet1 = new ItemEstoque(15, est1, prod4);
		ItemEstoque iet2 = new ItemEstoque(35, est1, prod5);
		ItemEstoque iet3 = new ItemEstoque(100, est1, prod6);
		ItemEstoque iet4 = new ItemEstoque(15, est1, prod1);
		ItemEstoque iet5 = new ItemEstoque(35, est1, prod2);
		ItemEstoque iet6 = new ItemEstoque(100, est1, prod3);
		
		
		itemEstoqueRepository.saveAll(Arrays.asList(iet1,iet2,iet3,iet4,iet5,iet6));
		
		
	}
}
