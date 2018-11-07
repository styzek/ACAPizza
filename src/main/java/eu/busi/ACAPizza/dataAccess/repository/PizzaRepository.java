package eu.busi.ACAPizza.dataAccess.repository;


import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<PizzaEntity,Integer> {
}
