package io.naraplatform.share.domain.granule;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
public class Address implements ValueObject {
    //
    private Locale langLocale;

    private Style style;
    private String tag;               // example: Home 1, Home 2 <-- Category
    private Category category;

    private String zipCode;
    private String zipAddress;

    private String city;
    private String state;

    private String street;              // non-zip addresss, or street address
    private String country;

    private String phoneNumber;         // optional

    public Address(Style style, Category category, String zipCode, String country) {
        //
        switch(style) {
            case Korean: langLocale = Locale.KOREA; break;
            case US: langLocale = Locale.US; break;
        }
        this.style = style;
        this.zipCode = zipCode;
        this.country = country;
        this.category = category;
        this.tag = category.name();
    }

    public static Address forKorean(Category category, String zipCode, String zipAddress, String street, String country) {
        //
        Address address = new Address(Style.Korean, category, zipCode, country);
        address.setZipAddress(zipAddress);
        address.setStreet(street);

        return address;
    }

    public static Address forUS(Category category, String zipCode, String street, String city, String state, String country) {
        //
        Address address = new Address(Style.US, category, zipCode, country);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);

        return address;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static Address getUSSample() {
        //
        Category category = Category.Office;
        String zipCode = "06889";
        String street = "12 Jhones st.";
        String city = "fairfield";
        String state = "CT";
        String country = "U.S.A";

        Address sample = Address.forUS(category, zipCode, street, city, state,  country);

        return sample;
    }

    public static Address getKoreanSample() {
        //
        Category category = Category.Office;
        String zipCode = "12345";
        String zipAddress = "서울시 금천구 디지털1로 155번지 잼잼빌딩";
        String street = "703호";
        String country = "대한민국";

        Address sample = Address.forKorean(category, zipCode, zipAddress, street, country);

        return sample;
    }

    public static Address fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Address.class);
    }

    public enum Style {
        US,
        Korean
    }

    public enum Category {
        Office,
        Home,
        Others
    }

    public static void main(String[] args) {
        //
        System.out.println(getKoreanSample());
        System.out.println(getUSSample().toJson());
        System.out.println(fromJson(getUSSample().toJson()));
    }
}
