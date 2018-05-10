package io.namoo.metro.ra.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.namoo.metro.ra.jpa.jpo.MetroJpo;

@Repository 
public interface MetroRepository extends CrudRepository<MetroJpo, String> {
	//
	boolean existsByName(String name); 
}