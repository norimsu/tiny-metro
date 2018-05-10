package io.naraplatform.share.domain.granule;

import io.naraplatform.share.util.json.JsonUtil;

public class Host {
    //
    private String id;                  // can be null.
    private String displayName;
    private String email;

    public Host() {
        //
    }

    public Host(String id, String name, String email) {
        //
        this.id = id;
        this.displayName = name;
        this.email = email;
    }

    public Host(String name, String email) {
        //
        this(null, name, email);
    }

    public String toString() {
        //
        return toJson();
    }

    public String toJson() {
        //
        return JsonUtil.toJson(this);
    }

    public static Host fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Host.class);
    }

    public static Host getSample() {
        //
        return new Host("Tim cook", "timcook@gmail.com");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
