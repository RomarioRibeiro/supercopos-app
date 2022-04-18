package com.romario.supercopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.supercopo.domian.ItemEstoque;

@Repository
public interface ItemEstoqueRepository extends JpaRepository <ItemEstoque , Integer> {
	@Query(value="select * from item_Estoque where id = ?",nativeQuery = true )
	ItemEstoque find(Integer id);
	
	@Query(value="select * from item_Estoque where produto_id = ?",nativeQuery = true )
	ItemEstoque findProduto(int idproduto);
}
