package io.namoo.metro.domain.spec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.domain.logic.MetroLogic;
import io.namoo.metro.domain.spec.sdo.MetroCdo;
import io.namoo.metro.domain.store.MetroStoreLycler;
import io.namoo.metro.domain.store.mem.MetroMemStoreLycler;
import io.naraplatform.share.domain.NameValueList;

public class MetroServiceTest {
	//
	private MetroService metroService; 
	
	@Before
	public void setUp() throws Exception {
		// 
		MetroStoreLycler storeLycler = new MetroMemStoreLycler(); 
		this.metroService = new MetroLogic(storeLycler);  
	}

	@Test
	public void testRegisterMetro() throws Exception {
		//
		String metroId = metroService.registerMetro(MetroCdo.sample()); 
		assertNotNull(metroId); 
	}

	@Test(expected = NoSuchElementException.class) 
	public void testFindNoMetro() throws Exception {
		// 
		metroService.findMetro("GhostMetroId"); 
	}

	@Test 
	public void testFindMetro() throws Exception {
		// 
		String metroId = metroService.registerMetro(MetroCdo.sample()); 
		Metro metro = metroService.findMetro(metroId); 
		
		assertNotNull(metro); 
	}

	@Test
	public void testModifyMetro() throws Exception {
		//
		String metroId = metroService.registerMetro(MetroCdo.sample()); 
		
		String newName = "NewName"; 
		NameValueList nameValues = new NameValueList("name", newName); 
		metroService.modifyMetro(metroId, nameValues);		
		Metro metro = metroService.findMetro(metroId); 
		
		assertEquals(newName, metro.getName()); 
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveMetro() throws Exception {
		// 
		String metroId = metroService.registerMetro(MetroCdo.sample()); 
		metroService.removeMetro(metroId);		
		metroService.findMetro(metroId); 
	}
}