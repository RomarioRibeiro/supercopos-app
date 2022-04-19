package com.romario.supercopo.dto;

import java.io.Serializable;

import com.romario.supercopo.domian.Produto;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	
	public ProdutoDTO() {
		
	}

		public ProdutoDTO(Produto obj) {
			id = obj.getId();
			nome = obj.getNome();
		}
		

	public ProdutoDTO(Integer id,String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
