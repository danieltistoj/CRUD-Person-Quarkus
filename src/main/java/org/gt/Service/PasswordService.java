package org.gt.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class PasswordService {
    public String encryptPassword(String password){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password,salt);
    }
    public boolean verifyPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }
}
