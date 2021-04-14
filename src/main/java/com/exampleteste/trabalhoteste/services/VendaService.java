package com.exampleteste.trabalhoteste.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.exampleteste.trabalhoteste.entities.Item;
import com.exampleteste.trabalhoteste.entities.Venda;
import com.exampleteste.trabalhoteste.repositories.VendaRepository;
import com.exampleteste.trabalhoteste.services.exceptions.DatabaseException;
import com.exampleteste.trabalhoteste.services.exceptions.ProductNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	public List<Venda> findAll() {
		return repository.findAll();
	}
	
	public Venda findById(Long id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	public Venda inserir(Item item) {
		Venda venda = new Venda(null, Instant.now());
		venda.getItens().add(item);
        return repository.save(venda);
    }
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ProductNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
//	public Venda update(Long id, Venda item) {
//		try {
//			Venda entity = repository.getOne(id);
//			updateData(entity, item);
//			return repository.save(entity);
//		}
//		catch(EntityNotFoundException e) {
//			throw new ProductNotFoundException(id);
//		}
//	}
//
//	private void updateData(Venda entity, Venda item) {
//		for (Item x : entity.getItens()) {
//			if (x.getId() == item.getId()) {
//				entity.getItens().add(item.);
//			}
//			else {
//				throw new ProductNotFoundException(item.getId());
//			}
//		}
//	}
}
