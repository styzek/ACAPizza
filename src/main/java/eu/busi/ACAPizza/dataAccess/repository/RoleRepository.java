package eu.busi.ACAPizza.dataAccess.repository;

import eu.busi.ACAPizza.dataAccess.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,String> {
}
