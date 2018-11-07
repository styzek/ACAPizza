package eu.busi.ACAPizza.dataAccess.dao;


import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.repository.UserRepository;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderConverter providerConverter;

    public User save(User user){
        UserEntity userEntity=providerConverter.userModelToUserEntity(user);
        userEntity=userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }


}
