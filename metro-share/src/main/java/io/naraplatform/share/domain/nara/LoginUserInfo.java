package io.naraplatform.share.domain.nara;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;
import io.naraplatform.share.util.security.bcrypt.BCryptPasswordEncoder;

public class LoginUserInfo implements ValueObject, JsonSerializable {
    //
    private String displayName;
    private String loginId;
    private String encryptedPassword;

    private NaraSpaceType spaceType;
    private String spaceUrl;
    private LoginIdType idType;
    private Long time;

    public LoginUserInfo() {
        //
    }

    private LoginUserInfo(String displayName, String loginId, NaraSpaceType spaceType, String spaceUrl) {
        //
        this.displayName = displayName;
        this.loginId = loginId;
        this.spaceType = spaceType;
        this.spaceUrl = spaceUrl;
        this.idType = LoginIdType.Email;
        this.time = System.currentTimeMillis();
    }

    public static LoginUserInfo newWithNoEncrypted(String displayName,
                                                   String loginId,
                                                   String password,
                                                   NaraSpaceType spaceType,
                                                   String spaceUrl) {
        //
        LoginUserInfo loginUserInfo = new LoginUserInfo(displayName, loginId, spaceType, spaceUrl);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        loginUserInfo.setEncryptedPassword(encryptedPassword);

        return loginUserInfo;
    }

    public String toString() {
        //
        return toJson();
    }

    public static LoginUserInfo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, LoginUserInfo.class);
    }

    public static LoginUserInfo getSample() {
        //
        String displayName = "Steve Jobs";
        String password = "12345";
        String userId = "steve@google.com";
        String spaceUrl = "/nara/official";

        return newWithNoEncrypted(displayName, userId, password, NaraSpaceType.Nara, spaceUrl);
    }

    public boolean valid(String password) {
        //
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.check(password, encryptedPassword);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public LoginIdType getIdType() {
        return idType;
    }

    public void setIdType(LoginIdType idType) {
        this.idType = idType;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public NaraSpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(NaraSpaceType spaceType) {
        this.spaceType = spaceType;
    }

    public String getSpaceUrl() {
        return spaceUrl;
    }

    public void setSpaceUrl(String spaceUrl) {
        this.spaceUrl = spaceUrl;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample().valid("12345"));
    }
}
