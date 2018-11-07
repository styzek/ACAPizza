package eu.busi.ACAPizza.dataAccess.util;

import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProviderConverter {

    public UserEntity userModelToUserEntity(User user){

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAdress(user.getAdress());
        userEntity.setZipCode(user.getZipCode());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhone(user.getPhone());
//        Collection<String> userRolesString = user.getRoles();
//        Set<RoleEntity> userRolesEnums = userRolesString.stream()
//                .map(RoleEntity::new)
//                .collect(Collectors.toSet());
//        userEntity.setRoles(userRolesEnums);

//        userEntity.setOrders(user.getOrders().stream() //get role = collection<String>
//                .map(s -> {
//                    OrderEntity orderEntity = new OrderEntity();
//                    orderEntity.setName(RoleEnum.valueOf(s));
//                    return roleEntity; })
//                .collect(Collectors.toSet()));

        return userEntity;

    }

    public User userEntityToUserModel(UserEntity userEntity){

        User user = new User();
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setAdress(userEntity.getAdress());
        user.setZipCode(userEntity.getZipCode());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setPhone(userEntity.getPhone());


        return user;
    }
}
