package io.naraplatform.share.domain.drama;

import java.util.Objects;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class UserRole implements JsonSerializable {
    //
    private String name;
    private RoleLevel level;

    public UserRole() {
        //
    }

    public UserRole(String name) {
        //
        this(name, RoleLevel.Normal);
    }

    public UserRole(String name, RoleLevel level) {
        //
        this.name = name;
        this.level = level;
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

        UserRole entity = (UserRole) target;

        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public UserRole clone() {
        //
        return new UserRole(name, level);
    }

    public static UserRole getSample() {
        //
        return new UserRole("Instructor", RoleLevel.Admin);
    }

    public static UserRole fromJson(String json) {
        //
        return JsonUtil.fromJson(json, UserRole.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
