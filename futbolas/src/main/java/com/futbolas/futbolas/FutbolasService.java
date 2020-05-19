package com.futbolas.futbolas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FutbolasService {

	@Autowired
	private FutbolasRepository repo;
	
	public List<Futbolas> listAll() {
		return repo.findAll();
	}
	
	public void save(Futbolas futbolas) {
		repo.save(futbolas);
	}
	
	public Futbolas get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

	//get product by keyword
	public List<Futbolas> findByKeyword(String keyword){
		return repo.findbyKeyword(keyword);
	}
}
