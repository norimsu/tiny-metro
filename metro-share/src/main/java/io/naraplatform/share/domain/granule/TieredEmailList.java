package io.naraplatform.share.domain.granule;

import io.naraplatform.share.domain.Tier;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class TieredEmailList implements JsonSerializable {
    //
    private List<TieredEmail> emails;

    public TieredEmailList() {
        //
        this.emails = new ArrayList<>();
    }

    public TieredEmailList(String email) {
        //
        this();
        this.add(new TieredEmail(TieredEmail.Category.Organization, Tier.Primary, email));
    }

    public TieredEmailList(TieredEmail email) {
        //
        this();
        this.add(email);
    }

    public TieredEmailList(TieredEmail.Category category, Tier tier, String email) {
        //
        this();
        this.add(new TieredEmail(category, tier, email));
    }

    public static TieredEmailList newList() {
        //
        return new TieredEmailList();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static TieredEmailList getSample() {
        //
        TieredEmailList sample = new TieredEmailList();
        sample.add(TieredEmail.getSample());

        return sample;
    }

    public static TieredEmailList fromJson(String json) {
        //
        return JsonUtil.fromJson(json, TieredEmailList.class);
    }

    public TieredEmailList add(TieredEmail email) {
        //
        if(emails.size() == 0) {
            email.setTier(Tier.Primary);
        } else if(email.isPrimary()) {
            TieredEmail primary = getPrimary();
            if (primary != null) {
                primary.setTier(Tier.Secondary);
            }
        }
        this.emails.add(email);

        return this;
    }

    public String getPrimaryEmail() {
        //
        TieredEmail primary = getPrimary();
        if (primary == null) return null;
        return primary.getEmail();
    }

    public TieredEmail getPrimary() {
        //
        for(TieredEmail email : emails) {
            //
            if (email.isPrimary()) {
                return email;
            }
        }

        return null;
    }

    public void add(TieredEmail.Category category, Tier tier, String emailStr) {
        //
        TieredEmail email = new TieredEmail(category, tier, emailStr);
        this.add(email);
    }

    public void addAll(List<TieredEmail> emails) {
        //
        for(TieredEmail email : emails) {
            this.add(email);
        }
    }

    public List<TieredEmail> getList() {
        //
        return emails;
    }

    public void setList(List<TieredEmail> emails) {
        //
        this.emails = emails;
    }

    public TieredEmail getFirst() {
        //
        if(emails == null|| emails.isEmpty())
            return null;

        return emails.get(0);
    }

    public TieredEmail get(String targetEmail) {
        //
        TieredEmail foundEmail = null;
        for(TieredEmail email : this.emails) {
            if (email.getEmail().equals(targetEmail)) {
                foundEmail = email;
                break;
            }
        }

        return foundEmail;
    }

    public boolean contains(String targetEmail) {
        //
        for(TieredEmail email : this.emails) {
            if (email.getEmail().equals(targetEmail)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return emails.size();
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}