package io.naraplatform.share.domain.drama;

import java.util.ArrayList;
import java.util.List;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.domain.lang.LangText;
import io.naraplatform.share.util.json.JsonUtil;

public class DramaRoleList implements ValueObject {
    //
    private List<DramaRole> roles;

    public DramaRoleList() {
        //
        this.roles = new ArrayList<>();
    }

    public DramaRoleList(DramaRole role) {
        //
        this();
        this.roles.add(role);
    }

    public DramaRoleList(List<DramaRole> roles) {
        //
        this();
        this.roles.addAll(roles);
    }

    public static List<DramaRole> defaultRoles() {
        //
        List<DramaRole> defaultRoles = new ArrayList<>();
        defaultRoles.add(new DramaRole(0, LangText.newText("en", "User"), RoleLevel.Normal));
        defaultRoles.add(new DramaRole(1, LangText.newText("en", "Admin"), RoleLevel.Admin));

        return defaultRoles;
    }

    public static DramaRoleList userRole() {
        //
        return new DramaRoleList(DramaRole.userRole());
    }

    public static DramaRoleList adminRole() {
        //
        return new DramaRoleList(DramaRole.adminRole());
    }

    public String toString() {
        //
        return toJson();
    }

    public static DramaRoleList fromJson(String json) {
        //
        return JsonUtil.fromJson(json, DramaRoleList.class);
    }

    public static DramaRoleList getSample() {
        //
        DramaRoleList sample = new DramaRoleList(DramaRole.getAdminSample());
        sample.add(DramaRole.userRole());

        return sample;
    }

    public int size() {
        //
        return roles.size();
    }

    public List<DramaRole> getRoles() {
        return roles;
    }

    public boolean hasRole() {
        //
        if(size() > 0) {
            return true;
        }

        return false;
    }

    public DramaRole getOne() {
        //
        if (size()>0) {
            return roles.get(0);
        }

        return null;
    }

    public void add(DramaRole role) {
        //
        this.roles.add(role);
    }

    public void addAll(List<DramaRole> roles) {
        //
        this.roles.addAll(roles);
    }

    public DramaRole getByName(String roleName) {
        //
        for(DramaRole role : this.roles) {
            if (role.getName().getText().equals(roleName)) {
                return role;
            }
        }

        return null;
    }

    public boolean hasByName(String roleName) {
        //
        if (getByName(roleName) != null) {
            return true;
        }

        return false;
    }
}
