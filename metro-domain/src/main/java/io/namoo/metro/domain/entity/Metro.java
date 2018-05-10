package io.namoo.metro.domain.entity;

import io.naraplatform.share.domain.NameValue;
import io.naraplatform.share.domain.NameValueList;
import io.naraplatform.share.domain.NaraAggregate;
import io.naraplatform.share.domain.NaraEntity;
import io.naraplatform.share.domain.granule.Admin;
import io.naraplatform.share.domain.granule.AdminList;
import io.naraplatform.share.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Metro extends NaraEntity implements NaraAggregate {
	//
	private String name;
	private AdminList admins;
	private long time;

	public Metro(String id) {
		// 
		super(id); 
	}
	
	public Metro(String name, Admin admin) {
		//
		super();
		this.name = name;
		this.admins = new AdminList(admin);
		this.time = System.currentTimeMillis();
	}

	public static Metro fromJson(String json) {
		//
		return JsonUtil.fromJson(json, Metro.class);
	}

	public void setValues(NameValueList nameValues) {
		//
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
			case "name":
				this.name = value;
				break;
			case "admins":
				this.admins = AdminList.fromJson(value);
				break;
			}
		}
	}

	public static Metro sample() {
		//
		String metroName = "NamooCompany";
		return new Metro(metroName, Admin.getSample());
	}

	public static void main(String[] args) {
		//
		System.out.println(sample());
	}
}