package io.naraplatform.share.domain.granule;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class TinyAddress implements JsonSerializable {
    //
    private String zipCode;
    private String zipAddress;
    private String street;
    private String coutry;

    public TinyAddress() {
        //
    }

    public TinyAddress(String zipCode, String zipAddress, String street, String country) {
        //
        this.zipCode = zipCode;
        this.zipAddress = zipAddress;
        this.street = street;
        this.coutry = country;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static TinyAddress getSample() {
        //
        String zipCode = "08876";
        String zipAddress = "Fairfield, CT";
        String street = "16th Berry street";
        String country = "U.S.A";

        TinyAddress sample = new TinyAddress(zipCode, zipAddress, street, country);

        return sample;
    }

    public static TinyAddress fromJson(String json) {
        //
        return JsonUtil.fromJson(json, TinyAddress.class);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipAddress() {
        return zipAddress;
    }

    public void setZipAddress(String zipAddress) {
        this.zipAddress = zipAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
