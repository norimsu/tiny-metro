package io.naraplatform.share.util.country;

public class PhoneNumberUtil {
    //
    /**
     * Return country phone code.
     *
     * ex) KR -> 82
     *
     * @param alpha2Code
     * @return
     */
    public static int getCountryCode(String alpha2Code) {
        //
        com.google.i18n.phonenumbers.PhoneNumberUtil phoneNumberUtil = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();
        return phoneNumberUtil.getCountryCodeForRegion(alpha2Code);
    }

}
