package io.namoo.metro.domain.spec.sdo;

import io.naraplatform.share.domain.granule.Admin;
import io.naraplatform.share.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class MetroCdo {
	// 
	private String name; 
	private Admin admin; 
	
	public MetroCdo(String name, Admin admin) {
		// 
		this.name = name; 
		this.admin = admin; 
	}
	
	public String toString() {
		// 
		return JsonUtil.toJson(this); 
	}
	
	public static MetroCdo sample() {
		// 
		return new MetroCdo("SDSMetro", Admin.getSample()); 
	}
	
	public static void main(String[] args) {
		// 
		System.out.println(sample()); 
	}
}