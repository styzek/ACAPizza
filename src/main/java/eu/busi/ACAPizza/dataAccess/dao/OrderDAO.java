package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.repository.OrderRepository;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.Order;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDAO {
    @Autowired
    OrderRepository repository;

    @Autowired
    ProviderConverter providerConverter;

    public Order save (Order order){
        OrderEntity orderEntity= providerConverter.orderModelToOrderEntity(order);
        orderEntity=repository.save(orderEntity);
         return providerConverter.orderEntityToOrderModel(orderEntity);
    }


//    public Order getOrder (OrderEntity orderEntity){
//        repository.findById(orderEntity);
//        return
//    }

    public Order notPaidOrder (User user){
       return providerConverter.orderEntityToOrderModel(repository.findAll()
               .stream()
               .filter(o->o.getClient().equals(user.getUsername()))
               .filter(o->o.getPaid()==false)
               .findFirst()
               .get()
       );
    }
}
