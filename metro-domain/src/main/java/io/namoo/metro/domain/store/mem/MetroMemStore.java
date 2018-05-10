package io.namoo.metro.domain.store.mem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.domain.store.MetroStore;

public class MetroMemStore implements MetroStore {
	//
	private Map<String, Metro> metroMap; 
	
	public MetroMemStore() {
		// 
		this.metroMap = new HashMap<>(); 
	}
	
	@Override
	public void create(Metro metro) {
		// 
		metroMap.put(metro.getId(), metro); 
	}

	@Override
	public Metro retrieve(String id) {
		// 
		return metroMap.get(id);
	}

	@Override
	public void update(Metro metro) {
		// 
		// do nothing 
	}

	@Override
	public void delete(Metro metro) {
		// 
		metroMap.remove(metro.getId()); 
	}

	@Override
	public boolean exist(String id) {
		// 
		if (metroMap.get(id) != null) {
			return true; 
		}
		
		return false;
	}

	@Override
	public boolean existByName(String name) {
		// 
		boolean found = false; 
		Iterator<Metro> metroIter = metroMap.values().iterator(); 
		while(metroIter.hasNext()) {
			Metro metro = metroIter.next(); 
			if (metro.getName().equals(name)) {
				found = true; 
				break; 
			}
		}
		
		return found;
	}
}