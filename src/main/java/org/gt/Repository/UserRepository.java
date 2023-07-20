package org.gt.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.gt.Entity.PersonEntity;
import org.gt.Entity.UserEntity;
@ApplicationScoped
public class UserRepository {
    @Transactional
    public   void createUser(UserEntity user){
        UserEntity.persist(user);
    }
    public UserEntity findByName(String name){
        return UserEntity.find("user_name",name).firstResult();
    }
}
