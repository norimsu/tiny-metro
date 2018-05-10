package io.naraplatform.share.util.security.bcrypt;

import io.naraplatform.share.util.security.PasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordEncoder implements PasswordEncoder {
    //
    @Override
    public String encode(String password) {
        //
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean check(String password, String encodedPassword) {
        //
        return BCrypt.checkpw(password, encodedPassword);
    }
}
