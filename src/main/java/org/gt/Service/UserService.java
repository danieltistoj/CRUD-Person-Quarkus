package org.gt.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.gt.Entity.UserEntity;
import org.gt.Repository.UserRepository;
import java.util.List;
@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;
    @Inject
    private PasswordService passwordService;

    @Transactional
    public boolean createUser(UserEntity userEntity){
        UserEntity newUserEntity = new UserEntity();
        if(userRepository.findByName(userEntity.getUsername())!=null){
            return false;
        }
        if(userRepository.findByEmail(userEntity.getEmail())!=null){
            return false;
        }
        String encryptedPassword = passwordService.encryptPassword(userEntity.getPassword());
        newUserEntity.setPassword(encryptedPassword);
        newUserEntity.setUsername(userEntity.getUsername());
        newUserEntity.setRole(userEntity.getRole());
        newUserEntity.setEmail(userEntity.getEmail());
        userRepository.persist(newUserEntity);
        return true;
    }
    @Transactional
    public boolean authenticateUser(UserEntity userEntity){
        UserEntity authUserEntity = userRepository.findByName(userEntity.getUsername());
        if(authUserEntity!=null && passwordService.verifyPassword(userEntity.getPassword(),authUserEntity.getPassword())){
            return true;
        }
        return false;
    }
    public List<UserEntity> allUser(){
        return userRepository.listAll();
    }
    public UserEntity findUserByName(String username){
        UserEntity getUserEntity = userRepository.findByName(username);
        if(getUserEntity!=null){
            return getUserEntity;
        }
        return null;
    }
    @Transactional
    public Object updateUser(String username,UserEntity userEntity){
        UserEntity updateUserEntity = userRepository.findByName(username);
        if(!updateUserEntity.getUsername().equals(userEntity.getUsername()) && userEntity.getUsername()!=null){
            if(userRepository.findByName(userEntity.getUsername())==null){
                updateUserEntity.setUsername(userEntity.getUsername());
            }else{
                throw  new IllegalArgumentException("username already exist");
            }
        }
        if(!updateUserEntity.getEmail().equals(userEntity.getEmail()) && userEntity.getEmail()!=null ){
            if(userRepository.findByEmail(userEntity.getEmail())==null){
                updateUserEntity.setEmail(userEntity.getEmail());
            }else{
                throw  new IllegalArgumentException("Email already exist");
            }
        }
        if(userEntity.getRole()!=null){
            System.out.println(userEntity.getRole());
            updateUserEntity.setRole(userEntity.getRole());
            System.out.println(updateUserEntity.getRole());
        }
        return "user update successfully";
    }
}
