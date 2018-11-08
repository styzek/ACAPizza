package eu.busi.ACAPizza.dataAccess.util;

import eu.busi.ACAPizza.dataAccess.entity.RoleEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
//@Service
public class ProviderConverter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder xxx = new BCryptPasswordEncoder();
        return xxx;
    }

    @Autowired
    private PasswordEncoder xxx;


    public UserEntity userModelToUserEntity(User user){

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setLastName(user.getLastName());
        userEntity.setAdress(user.getAdress());
        userEntity.setZipCode(user.getZipCode());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPassword(xxx.encode(user.getPassword()));
        userEntity.setPhone(user.getPhone());
        userEntity.setAccountNonExpired(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnable(true);
        RoleEntity role = new RoleEntity("ROLE_USER");
        Set<RoleEntity> xyz = new HashSet<>();
        xyz.add(role);
        userEntity.setRoles(xyz);
        return userEntity;

    }

    public User userEntityToUserModel(UserEntity userEntity){

        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setLastName(userEntity.getLastName());
        user.setAdress(userEntity.getAdress());
        user.setZipCode(userEntity.getZipCode());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setPhone(userEntity.getPhone());


        return user;
    }
}
