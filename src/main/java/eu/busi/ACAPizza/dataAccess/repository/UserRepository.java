package eu.busi.ACAPizza.dataAccess.repository;


import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
