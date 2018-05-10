package io.naraplatform.share.domain.drama;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.naraplatform.share.domain.lang.LangText;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class CineroomRole implements JsonSerializable {
    //
    private int index;
    private String key;
    private LangText name;
    private RoleLevel level;

    public CineroomRole() {
        //
    }

    public CineroomRole(int index, LangText name, RoleLevel level) {
        //
        this.index = index;
        this.key = name.getText();
        this.name = name;
        this.level = level;
    }

    public static List<CineroomRole> defaultRoles() {
        //
        List<CineroomRole> defaultRoles = new ArrayList<>();
        defaultRoles.add(new CineroomRole(0, LangText.newText("en", "User"), RoleLevel.Normal));
        defaultRoles.add(new CineroomRole(1, LangText.newText("en", "Admin"), RoleLevel.Admin));

        return defaultRoles;
    }

    public static CineroomRole userRole() {
        //
        return new CineroomRole(0, LangText.newText("en","User"), RoleLevel.Normal);
    }

    public static CineroomRole adminRole() {
        //
        return new CineroomRole(1, LangText.newText("en", "Admin"), RoleLevel.Admin);
    }

    @Override
    public boolean equals(Object target) {
        //
        if (this == target) {
            return true;
        }

        if (target == null || getClass() != target.getClass()) {
            return false;
        }

        CineroomRole entity = (CineroomRole) target;

        return Objects.equals(key, entity.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public CineroomRole clone() {
        //
        return new CineroomRole(index, name, level);
    }

    public static CineroomRole getSample() {
        //
        return new CineroomRole(0, LangText.newText("en", "Instructor"), RoleLevel.Admin);
    }

    public static CineroomRole fromJson(String json) {
        //
        return JsonUtil.fromJson(json, CineroomRole.class);
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
        System.out.println(getSample());
    }
}
