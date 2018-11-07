package eu.busi.ACAPizza.dataAccess.repository;

import eu.busi.ACAPizza.dataAccess.entity.IngredientEntity;
import eu.busi.ACAPizza.dataAccess.entity.OrderPizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPizzaRepository extends JpaRepository<OrderPizzaEntity,Integer> {
}
