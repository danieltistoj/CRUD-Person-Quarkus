package org.gt.Repository;

import io.vertx.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.gt.Entity.UserEntity;
@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity>{

    public UserEntity findByName(String name){
        return find("username",name).firstResult();
    }
    public UserEntity findByEmail(String email){
        return find("email",email).firstResult();
    }

}
