package io.naraplatform.share.domain.granule;

import java.util.UUID;

import io.naraplatform.share.domain.Tier;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor

public class Admin implements JsonSerializable {
    //
    private Tier tier;
    private String id;
    private String name;
    private String email; 
    private long time;

    public Admin(String id, String name, String email) {
        //
    	this.tier = Tier.Primary; 
    	this.id = id; 
    	this.name = name; 
    	this.email = email; 
    	this.time = System.currentTimeMillis(); 
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static Admin getSample() {
        //
        String id = UUID.randomUUID().toString(); 
        String name = "홍길동"; 
        String email = "hong@sdsmetro.com"; 
        
        return new Admin(id, name, email);
    }

    public static Admin fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Admin.class);
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
