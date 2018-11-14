package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.repository.OrderRepository;
import eu.busi.ACAPizza.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDAO {
    @Autowired
    OrderRepository repository;

    public void save (OrderEntity orderEntity){
        repository.save(orderEntity);
    }

//    public Order getOrder (OrderEntity orderEntity){
//        repository.findById(orderEntity);
//        return
//    }
}
