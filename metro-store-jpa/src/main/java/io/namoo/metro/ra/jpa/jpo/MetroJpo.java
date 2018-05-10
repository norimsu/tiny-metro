package io.namoo.metro.ra.jpa.jpo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import io.namoo.metro.domain.entity.Metro;
import io.naraplatform.share.domain.granule.AdminList;
import io.naraplatform.share.util.json.JsonSerializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@NoArgsConstructor
public class MetroJpo implements JsonSerializable {
	//
	@Id
	private String id; 
	
	private String name;
	private String adminsJson;
	private long time;
	
	public MetroJpo(Metro metro) {
		// 
		BeanUtils.copyProperties(metro, this); 
		this.adminsJson = metro.getAdmins().toJson(); 
	}

	public Metro toDomain() {
		// 
		Metro metro = new Metro(id); 
		BeanUtils.copyProperties(this, metro, "Id"); 
		metro.setAdmins(AdminList.fromJson(adminsJson)); 
		
		return metro; 
	}
	
	public String toString() {
		// 
		return toJson(); 
	}
	
	public static MetroJpo sample() {
		// 
		return new MetroJpo(Metro.sample()); 
	}
	
	public static void main(String[] args) {
		// 
		System.out.println(sample()); 
	}
}