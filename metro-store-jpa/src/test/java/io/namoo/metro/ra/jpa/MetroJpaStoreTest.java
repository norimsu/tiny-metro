package io.namoo.metro.ra.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.ra.jpa.repo.MetroRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
//@ContextConfiguration
//@SpringBootTest(classes=SpringBootTestApplication.class)

public class MetroJpaStoreTest {
	//
//    @Autowired
//    private TestEntityManager entityManager;
//
    @Autowired
    private MetroRepository metroRepository;
    
    @Autowired
    private MetroJpaStore metroJpaStore; 
    
    private Metro metro; 
    
    @TestConfiguration
    static class MetroServiceTestContextConfiguration {
  
        @Bean
        public MetroJpaStore metroJpaStore() {
            return new MetroJpaStore();
        }
    }
    
	@Before
	public void setUp() throws Exception {
		// 
		this.metro = Metro.sample(); 
	}

	@Test
	public void testCreateAndRetrieve() throws Exception {
		//
		metroJpaStore.create(this.metro);
		Metro metro = metroJpaStore.retrieve(this.metro.getId()); 
		
		assertNotNull(metro); 
	}

	@Test
	public void testUpdate() throws Exception {
		//
		String newName = "NewName"; 
		metroJpaStore.create(this.metro);
		Metro metro = metroJpaStore.retrieve(this.metro.getId()); 
		metro.setName(newName); 
		metroJpaStore.update(metro);
		
		Metro newMetro = metroJpaStore.retrieve(this.metro.getId()); 
		assertEquals(newName, newMetro.getName()); 
	}

	@Test(expected=NoSuchElementException.class)
	public void testDelete() throws Exception {
		// 
		metroJpaStore.create(this.metro);
		Metro deletedMetro = metroJpaStore.retrieve(metro.getId()); 
		metroJpaStore.delete(deletedMetro);
		
		Metro afterDeleteMetro = metroJpaStore.retrieve(this.metro.getId()); 
//	
//		assertNull(afterDeleteMetro); 
	}

	@Test
	public void testExist() throws Exception {
		// 
		metroJpaStore.create(this.metro);
		boolean exist = metroJpaStore.exist(metro.getId()); 
		
		assertTrue(exist); 
	}

	@Test
	public void testExistByName() throws Exception {
		// 
		metroJpaStore.create(metro);
		boolean exist = metroJpaStore.existByName("Hello"); 
		
		assertFalse(exist); 
	}
}