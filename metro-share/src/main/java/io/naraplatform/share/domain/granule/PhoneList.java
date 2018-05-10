package io.naraplatform.share.domain.granule;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class PhoneList implements JsonSerializable {
    //
    private List<Phone> phones;

    public PhoneList() {
        //
        this.phones = new ArrayList<>();
    }

    public PhoneList(Phone phone) {
        //
        this();
        this.phones.add(phone);
    }

    public static PhoneList newList() {
        //
        return new PhoneList();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static PhoneList getSample() {
        //
        PhoneList sample = new PhoneList();
        sample.add(Phone.getSample());

        return sample;
    }

    public static PhoneList fromJson(String json) {
        //
        return JsonUtil.fromJson(json, PhoneList.class);
    }

    public PhoneList add(Phone phone) {
        //
        phones.add(phone);
        return this;
    }

    public PhoneList add(Phone.Category category, String countryCode, String carrierCode, String fullNumber) {
        //
        Phone newPhone = new Phone(countryCode, carrierCode, fullNumber);
        newPhone.setCategory(category);
        phones.add(newPhone);

        return this;
    }

    public void addAll(List<Phone> phones) {
        //
        this.phones.addAll(phones);
    }

    public List<Phone> getList() {
        //
        return phones;
    }

    public void setList(List<Phone> phones) {
        //
        this.phones = phones;
    }

    public Phone getFirst() {
        //
        if (phones == null || phones.isEmpty()) return null;
        return phones.get(0);
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public boolean contains(String fullNumber) {
        //
        for(Phone phone : this.phones) {
            if (phone.getFullNumber().equals(fullNumber)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return phones.size();
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
        System.out.println(getSample().toJson());
        System.out.println(fromJson(getSample().toJson()));
    }
}
