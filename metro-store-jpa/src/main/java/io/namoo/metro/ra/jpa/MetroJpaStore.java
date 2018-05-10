package io.namoo.metro.ra.jpa;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.domain.store.MetroStore;
import io.namoo.metro.ra.jpa.jpo.MetroJpo;
import io.namoo.metro.ra.jpa.repo.MetroRepository;
import io.naraplatform.share.exception.store.AlreadyExistsException;

@Component
public class MetroJpaStore implements MetroStore {
	//
	@Autowired
	private MetroRepository metroRepository; 
	
	@Override
	public void create(Metro metro) {
		// 
		if (metroRepository.existsByName(metro.getName())) {
			throw new AlreadyExistsException("Metro name: " + metro.getName()); 
		}
		MetroJpo metroJpo = new MetroJpo(metro); 
		
		metroRepository.save(metroJpo); 
	}

	@Override
	public Metro retrieve(String id) {
		// 
		Optional<MetroJpo> optionalMetroJpo = metroRepository.findById(id);
		MetroJpo metroJpo = optionalMetroJpo
				.get(); 
		
		return metroJpo.toDomain();   
	}

	@Override
	public void update(Metro metro) {
		//
		MetroJpo sourceMetroJpo = new MetroJpo(metro); 
		Optional<MetroJpo> optionalMetroJpo = metroRepository.findById(metro.getId()); 
		MetroJpo metroJpo = optionalMetroJpo.orElseThrow(IllegalArgumentException::new); 
		
		BeanUtils.copyProperties(sourceMetroJpo, metroJpo, "Id");
		metroRepository.save(metroJpo); 
	}

	@Override
	public void delete(Metro metro) {
		// 
		metroRepository.deleteById(metro.getId()); 
	}

	@Override
	public boolean exist(String id) {
		// 
		return metroRepository.existsById(id);
	}

	@Override
	public boolean existByName(String name) {
		// 
		return metroRepository.existsByName(name); 
	}
}