package io.naraplatform.share.domain.granule;

import java.util.Locale;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;
import io.naraplatform.share.util.string.StringUtil;

public class LocaledName implements ValueObject {
    //
    private String langCode;        // iso 639, ko, en, etc
    private String familyName;
    private String middleName;
    private String firstName;

    public LocaledName() {
        //
    }

    public LocaledName(String familyName, String givenName) {
        //
        this(Locale.getDefault(), familyName, givenName);
    }

    public LocaledName(Locale langLocale, String familyName, String firstName) {
        //
        this(langLocale.getLanguage(), familyName, firstName);
    }

    public LocaledName(String langCode, String familyName, String firstName) {
        //
        this.langCode = langCode;
        this.familyName = familyName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static LocaledName getSample() {
        //
        Locale langLocale = Locale.getDefault();
        String familyName = "김";
        String firstName = "철수";

        LocaledName sample = new LocaledName(langLocale, familyName, firstName);

        return sample;
    }

    public static LocaledName getEnglishSample() {
        //
        Locale langLocale = Locale.ENGLISH;
        String familyName = "Kim";
        String givenName = "Chulsu";

        LocaledName sample = new LocaledName(langLocale, familyName, givenName);

        return sample;
    }

    public static LocaledName fromJson(String json) {
        //
        return JsonUtil.fromJson(json, LocaledName.class);
    }

    public String getDisplayName() {
        //
        String displayFamilyName = StringUtil.defaultString(familyName);
        String displayGivenName = StringUtil.defaultString(firstName);

        if(langCode.equals("ko")) {
            return String.format("%s%s", displayFamilyName, displayGivenName);
        } else {
            return String.format("%s %s", displayGivenName, displayFamilyName);
        }
    }

    public String getFullName() {
        //
        if (this.middleName == null || middleName.equals("")) {
            return getDisplayName();
        }

        return String.format("%s %s %s", firstName, middleName, familyName);
    }

    public String getGivenName() {
        //
        return firstName;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
