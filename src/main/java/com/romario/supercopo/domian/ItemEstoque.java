package com.romario.supercopo.domian;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ItemEstoque implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemEstoquePK id = new ItemEstoquePK();
	
	
	private Integer quantidade;
	
	public ItemEstoque () {
		
	}

	public ItemEstoque(Integer quantidade, Estoque estoque, Produto produto) {	
		this.quantidade = quantidade;
		id.setEstoque(estoque);
		id.setProduto(produto);
		
		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ItemEstoquePK getId() {
		return id;
	}

	public void setId(ItemEstoquePK id) {
		this.id = id;
	}
	
	
	@JsonIgnore
	public Estoque getEstoque() {
		return id.getEstoque();
	}

	public void setEstoque(Estoque estoque) {
		id.setEstoque(estoque);
	}

	public Produto getProduto() {

		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEstoque other = (ItemEstoque) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
