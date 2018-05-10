package io.naraplatform.share.domain.granule;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Contact implements ValueObject {
    //
    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        //
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String toString() {
        //
        return toJson();
    }

    public static Contact getSample() {
        //
        String name = "Steve Jobs";
        String email = TieredEmail.getSample().getEmail();
        String phone = Phone.getSample().getFullNumber();

        Contact sample = new Contact(name, email, phone);

        return sample;
    }

    public static Contact fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Contact.class);
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
