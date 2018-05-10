package io.namoo.metro.domain.spec;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.domain.spec.sdo.MetroCdo;
import io.naraplatform.share.domain.NameValueList;

public interface MetroService {
	//
	String registerMetro(MetroCdo metroCdo); 
	Metro findMetro(String metroId); 
	void modifyMetro(String metroId, NameValueList nameValues); 
	void removeMetro(String metroId); 
}