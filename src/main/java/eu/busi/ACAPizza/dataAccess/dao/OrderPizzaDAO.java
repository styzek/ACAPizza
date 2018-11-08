package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.OrderPizzaEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.repository.OrderPizzaRepository;
import eu.busi.ACAPizza.dataAccess.repository.UserRepository;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.Order;
import eu.busi.ACAPizza.model.OrderPizza;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderPizzaDAO {

    @Autowired
    private OrderPizzaRepository orderPizzaRepository;


    @Autowired
    private ProviderConverter providerConverter;

    public OrderPizza save(OrderPizza orderPizza){
        OrderPizzaEntity orderPizzaEntity=providerConverter.userModelToUserEntity(orderPizza);
        userEntity=userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }
}
