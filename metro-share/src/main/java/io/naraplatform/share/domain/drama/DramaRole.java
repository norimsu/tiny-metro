package io.naraplatform.share.domain.drama;

import io.naraplatform.share.domain.lang.LangText;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class DramaRole implements JsonSerializable {
    //
    private int index;
    private String key;
    private LangText name;
    private RoleLevel level;

    public DramaRole() {
        //
    }

    public DramaRole(int index, LangText name, RoleLevel level) {
        //
        this.index = index;
        this.key = name.getText();
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static DramaRole fromJson(String json) {
        //
        return JsonUtil.fromJson(json, DramaRole.class);
    }

    public static DramaRole userRole() {
        //
        return new DramaRole(0, LangText.newText("en","User"), RoleLevel.Normal);
    }

    public static DramaRole adminRole() {
        //
        return new DramaRole(1, LangText.newText("en", "Admin"), RoleLevel.Admin);
    }

    public static DramaRole getAdminSample() {
        //
        return new DramaRole(0, LangText.newText("en", "Admin").addText("ko", "어드민"), RoleLevel.Admin);
    }

    public static DramaRole getUserSample() {
        //
        return new DramaRole(1, LangText.newText("en", "User").addText("ko", "사용자"), RoleLevel.Normal);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LangText getName() {
        return name;
    }

    public void setName(LangText name) {
        this.name = name;
    }

    public RoleLevel getLevel() {
        return level;
    }

    public void setLevel(RoleLevel level) {
        this.level = level;
    }

    public static void main(String[] args) {
        //
        System.out.println(getAdminSample());
    }
}
