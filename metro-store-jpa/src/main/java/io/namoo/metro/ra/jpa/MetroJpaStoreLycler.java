package io.namoo.metro.ra.jpa;

import io.namoo.metro.domain.store.MetroStore;
import io.namoo.metro.domain.store.MetroStoreLycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetroJpaStoreLycler implements MetroStoreLycler {
	//
	@Autowired
	private MetroStore metroStore;

	@Override
	public MetroStore requestMetroStore() {
		// 
		return metroStore;
	}
}