package io.namoo.metro.domain.store.mem;

import io.namoo.metro.domain.store.MetroStore;
import io.namoo.metro.domain.store.MetroStoreLycler;

public class MetroMemStoreLycler implements MetroStoreLycler {
	//
	@Override
	public MetroStore requestMetroStore() {
		// 
		return new MetroMemStore();
	}
}