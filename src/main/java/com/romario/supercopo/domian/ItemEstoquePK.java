package com.romario.supercopo.domian;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Embeddable
public class ItemEstoquePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="estoque_id")
	private Estoque estoque;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estoque, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEstoquePK other = (ItemEstoquePK) obj;
		return Objects.equals(estoque, other.estoque) && Objects.equals(produto, other.produto);
	}

	
	
	
}
