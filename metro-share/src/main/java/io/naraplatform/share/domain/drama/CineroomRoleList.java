package io.naraplatform.share.domain.drama;

import java.util.ArrayList;
import java.util.List;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;

public class CineroomRoleList implements ValueObject {
    //
    private List<CineroomRole> roles;

    public CineroomRoleList() {
        //
        this.roles = new ArrayList<>();
    }

    public CineroomRoleList(CineroomRole role) {
        //
        this();
        this.roles.add(role);
    }

    public CineroomRoleList(List<CineroomRole> roles) {
        //
        this();
        this.roles.addAll(roles);
    }

    public static CineroomRoleList defaultRoles() {
        //
        return new CineroomRoleList(CineroomRole.defaultRoles());
    }

    public static CineroomRoleList userRole() {
        //
        return new CineroomRoleList(CineroomRole.userRole());
    }

    public static CineroomRoleList adminRole() {
        //
        return new CineroomRoleList(CineroomRole.adminRole());
    }

    public String toString() {
        //
        return toJson();
    }

    public static CineroomRoleList fromJson(String json) {
        //
        return JsonUtil.fromJson(json, CineroomRoleList.class);
    }

    public static CineroomRoleList getSample() {
        //
        return new CineroomRoleList(CineroomRole.getSample());
    }

    public int size() {
        //
        return roles.size();
    }

    public List<CineroomRole> getRoles() {
        return roles;
    }

    public void setRoles(List<CineroomRole> roles) {
        //
        this.roles =roles;
    }

    public boolean hasRole() {
        //
        if(size() > 0) {
            return true;
        }

        return false;
    }

    public CineroomRole getOne() {
        //
        if (size()>0) {
            return roles.get(0);
        }

        return null;
    }

    public void addAll(List<CineroomRole> roles) {
        //
        this.roles.addAll(roles);
    }

    public CineroomRoleList add(CineroomRole role) {
        //
        this.roles.add(role);
        return this;
    }

    public CineroomRole getByName(String roleName) {
        //
        for(CineroomRole role : this.roles) {
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
