package eu.busi.ACAPizza.dataAccess.repository;

import eu.busi.ACAPizza.dataAccess.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity,Integer> {
}
