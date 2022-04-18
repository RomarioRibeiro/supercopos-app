package com.romario.supercopo.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.supercopo.domian.Estoque;
import com.romario.supercopo.domian.ItemEstoque;
import com.romario.supercopo.service.EstoqueService;

@RestController
@RequestMapping(value = "/estoques")
public class EstoqueResouce {
	
	@Autowired
	private EstoqueService service;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estoque> find( @PathVariable Integer id  ) {
		Estoque obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert  ( @RequestBody Estoque obj) {
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{quantidade}/{idproduto}", method = RequestMethod.PUT)
	public ResponseEntity<?> subtrair( @PathVariable Integer quantidade, @PathVariable Integer idproduto) {
	ItemEstoque itemestoque = service.subtrair(quantidade,idproduto );
	
	return ResponseEntity.ok(itemestoque);
	}
	
	@RequestMapping(value = "somar/{quantidade}/{idproduto}", method = RequestMethod.PUT)
	public ResponseEntity<?> somar( @PathVariable Integer quantidade, @PathVariable Integer idproduto) {
	ItemEstoque itemestoque = service.somar(quantidade,idproduto );
	return ResponseEntity.ok(itemestoque);
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
}
