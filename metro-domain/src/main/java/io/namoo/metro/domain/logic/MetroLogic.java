package io.namoo.metro.domain.logic;

import java.util.NoSuchElementException;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.domain.spec.MetroService;
import io.namoo.metro.domain.spec.sdo.MetroCdo;
import io.namoo.metro.domain.store.MetroStore;
import io.namoo.metro.domain.store.MetroStoreLycler;
import io.naraplatform.share.domain.NameValueList;

public class MetroLogic implements MetroService {
	//
	private MetroStore metroStore; 
	
	public MetroLogic(MetroStoreLycler storeLycler) {
		// 
		this.metroStore = storeLycler.requestMetroStore(); 
	}
	
	@Override
	public String registerMetro(MetroCdo metroCdo) {
		// 
		String name = metroCdo.getName(); 
		if(metroStore.existByName(name)) {
			throw new IllegalArgumentException("Name is duplicated(name): " + name); 
		}

		Metro metro = new Metro(
			name, 
			metroCdo.getAdmin()
		); 
		
		metroStore.create(metro);
		
		return metro.getId();
	}

	@Override
	public Metro findMetro(String metroId) {
		// 
		Metro metro = metroStore.retrieve(metroId); 
		if(metro == null) {
			throw new NoSuchElementException("Metro id: " + metroId); 
		}
		
		return metro;
	}

	@Override
	public void modifyMetro(String metroId, NameValueList nameValues) {
		// 
		Metro metro = findMetro(metroId); 
		metro.setValues(nameValues);
		
		metroStore.update(metro); 
	}

	@Override
	public void removeMetro(String metroId) {
		// 
		Metro metro = findMetro(metroId); 
		// Do something 
		metroStore.delete(metro); 
	}
}