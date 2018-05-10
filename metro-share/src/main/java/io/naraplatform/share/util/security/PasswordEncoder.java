package io.naraplatform.share.util.security;

public interface PasswordEncoder {
    //
    String encode(String password);
    boolean check(String password, String encodedPassword);
}
