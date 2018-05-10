package io.naraplatform.share.domain.granule;

import io.naraplatform.share.domain.Tier;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class AdminList implements JsonSerializable {
    //
    private List<Admin> admins;

    public AdminList() {
        //
        this.admins = new ArrayList<>();
    }

    public AdminList(Admin admin) {
        //
        this();
        this.admins.add(admin);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static AdminList getSample() {
        //
        AdminList sample = new AdminList(Admin.getSample());

        return sample;
    }

    public static AdminList fromJson(String json) {
        //
        return JsonUtil.fromJson(json, AdminList.class);
    }

    public void add(Admin admin) {
        //
        this.admins.add(admin);
    }

    public void addAll(List<Admin> admins) {
        //
        this.admins.addAll(admins);
    }

    public List<Admin> getList() {
        //
        return admins;
    }

    public Admin find(String id) {
        //
        return this.admins.stream().filter(admin -> id.equals(admin.getId())).findFirst().orElse(null);
    }

    public void remove(String id) {
        //
        Admin admin = find(id);
        if (admin == null) return;
        this.admins.remove(admin);
    }

    public boolean contains(String id) {
        //
        return find(id) != null;
    }

    public Admin getPrimaryAdmin() {
        for (Admin admin : this.admins) {
            if (Tier.Primary == admin.getTier()) {
                return admin;
            }
        }
        return null;
    }

    public int size() {
        //
        return admins.size();
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        if (admins != null && !admins.isEmpty()){
            for(int index = 0, length = admins.size(); index < length; index++) {
                if (index == 0) admins.get(index).setTier(Tier.Primary);
                else admins.get(index).setTier(Tier.Secondary);
            }
        }
        this.admins = admins;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
        System.out.println(getSample().toJson());
        System.out.println(fromJson(getSample().toJson()));
    }
}
