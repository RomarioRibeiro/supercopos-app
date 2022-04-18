package com.romario.supercopo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.supercopo.domian.Estoque;
import com.romario.supercopo.domian.ItemEstoque;
import com.romario.supercopo.repository.EstoqueRepository;
import com.romario.supercopo.repository.ItemEstoqueRepository;
import com.romario.supercopo.service.exception.DatalIntegrityExcepition;
import com.romario.supercopo.service.exception.ObjectNotFoundException;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repo;
	
	@Autowired
	private ItemEstoqueRepository itens;
		
	public Estoque find(Integer id) {
		Optional<Estoque> obj = repo.findById(id);			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Estoque.class.getName()));
	}
	
	
	
	public Estoque inserir (Estoque obj) {
		obj.setId(null);
		
		
		return repo.save(obj);
	}
	
	public ItemEstoque subtrair (Integer quanRetirado, int idproduto) {
		ItemEstoque itensestoqueproduto = itens.findProduto(idproduto);
		itensestoqueproduto.setQuantidade(itensestoqueproduto.getQuantidade() - quanRetirado);
		if(itensestoqueproduto.getQuantidade() <= 0 ) {
			Optional<ItemEstoque> objt = Optional.empty();
			
			return objt.orElseThrow(() -> new  ObjectNotFoundException("Estoque abaixo do limite"));
		}else {
			
			return itens.save(itensestoqueproduto);
		}
		
		
	}
	

	public ItemEstoque somar (Integer quansomar, int idproduto) {
		ItemEstoque itensestoqueproduto = itens.findProduto(idproduto);
		itensestoqueproduto.setQuantidade(itensestoqueproduto.getQuantidade() + quansomar);		
		return itens.save(itensestoqueproduto);
	}
	
	public void  delete(Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e ) {
		throw  new DatalIntegrityExcepition("Não e possivel excluir uma categoria que possui produtos");
		}
	
	}
	
}
