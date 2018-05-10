package io.namoo.metro.domain.store;

import io.namoo.metro.domain.entity.Metro;

public interface MetroStore {
	//
	void create(Metro metro); 
	Metro retrieve(String id); 
	void update(Metro metro); 
	void delete(Metro metro); 
	boolean exist(String id); 
	boolean existByName(String name); 
}