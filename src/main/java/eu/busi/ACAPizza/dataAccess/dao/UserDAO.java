package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.User;

import java.util.List;

@Service
public class UserDAO  {



    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ProviderConverter providerConverter;

    public User save(User user){
        UserEntity userEntity=providerConverter.userModelToUserEntity(user);
        userEntity=userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }


    public UserEntity getUser (String email, String password) {
        UserEntity user = userRepository.findAll().stream().filter( u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst().get();


            return user;


    }

    public List<UserEntity> getAllUsers () {

        List<UserEntity> users = userRepository.findAll();
        return users;
    }


}
