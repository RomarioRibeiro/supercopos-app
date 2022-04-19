package com.romario.supercopo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.supercopo.domian.Produto;
import com.romario.supercopo.dto.ProdutoDTO;
import com.romario.supercopo.repository.ProdutoRepository;
import com.romario.supercopo.service.exception.DatalIntegrityExcepition;
import com.romario.supercopo.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
		
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",Tipo: " + Produto.class.getName()));
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Produto update (Produto obj) {
		find(obj.getId());
		
		return repo.save(obj);
	}
	
	public void  delete(Integer id) {
		find(id);
		try {
			
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e ) {
		throw  new DatalIntegrityExcepition("Não e possivel excluir uma categoria que possui produtos");
		}
	
	}
	
	public List<Produto> findAll() {

		return repo.findAll();
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome());
	}

	
	
	
}
