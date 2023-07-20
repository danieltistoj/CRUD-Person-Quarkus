package org.gt.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gt.DTO.UserDTO;
import org.gt.Entity.UserEntity;
import org.gt.Repository.UserRepository;
@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;
    @Inject
    private PasswordService passwordService;

    @Transactional
    public boolean createUser(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        if(userRepository.findByName(userDTO.getUser_name())!=null){

            return false;
        }
        String encryptedPassword = passwordService.encryptPassword(userDTO.getPassword());
        userEntity.setPassword(encryptedPassword);
        userEntity.setUser_name(userDTO.getUser_name());
        userRepository.createUser(userEntity);
        return true;
    }

}
