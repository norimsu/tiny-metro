package io.naraplatform.share.domain.granule;

import io.naraplatform.share.domain.Tier;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class TieredEmail implements JsonSerializable {
    //
    private Category category;
    private Tier tier;
    private String email;

    public TieredEmail() {
        //
    }

    public TieredEmail(String email) {
        //
        this.tier = Tier.Secondary;
        this.email = email;
        this.category = Category.Others;
    }

    public TieredEmail(Category category, Tier tier, String email) {
        //
        this.category = category;
        this.tier = tier;
        this.email = email;
    }

    public static TieredEmail asOrgPrimary(String email) {
        //
        return new TieredEmail(Category.Organization, Tier.Primary, email);
    }

    public static TieredEmail asPersonalPrimary(String email) {
        //
        return new TieredEmail(Category.Personal, Tier.Primary, email);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static TieredEmail fromJson(String json) {
        return JsonUtil.fromJson(json, TieredEmail.class);
    }

    public static TieredEmail getSample() {
        //
        String email = "jhone@company.com";
        return asOrgPrimary(email);
    }

    public boolean isPrimary() {
        //
        if (this.tier.isPrimary()) {
            return true;
        }

        return false;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enum Category {
        //
        Organization,
        Company,
        Personal,
        Others
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
