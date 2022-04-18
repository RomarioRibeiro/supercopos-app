package com.romario.supercopo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.supercopo.domian.Categoria;
import com.romario.supercopo.domian.dto.CategoriaDTO;
import com.romario.supercopo.repository.CategoriaRepository;
import com.romario.supercopo.service.exception.DatalIntegrityExcepition;
import com.romario.supercopo.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Categoria update(Categoria obj) {
		Categoria newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}

	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatalIntegrityExcepition("Não e possivel excluir uma categoria que possui produtos");
		}

	}

	public List<Categoria> findAll() {

		return repo.findAll();
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}

	private void updateData(Categoria newobj ,Categoria obj) {
		newobj.setNome(obj.getNome());
	;
	}
	
}
