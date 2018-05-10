package io.naraplatform.share.domain.granule;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.domain.lang.LangText;
import io.naraplatform.share.util.json.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LangContact implements ValueObject {
    //
    private LangText langName;
    private String email;
    private String phone;

    public LangContact(LangText langName, String email, String phone) {
        //
        this.langName = langName;
        this.email = email;
        this.phone = phone;
    }

    public String toString() {
        //
        return toJson();
    }

    public static LangContact getSample() {
        //
        LangText langName = LangText.newText("ko", "홍길동").addText("en", "Gildong Hong");
        String email = TieredEmail.getSample().getEmail();
        String phone = Phone.getSample().getFullNumber();

        LangContact sample = new LangContact(langName, email, phone);

        return sample;
    }

    public static LangContact fromJson(String json) {
        //
        return JsonUtil.fromJson(json, LangContact.class);
    }

    public String getDefaultLangCode() {
        //
        if (langName == null) {
            return null;
        }

        return langName.getDefaultLangCode();
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
