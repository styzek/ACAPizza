package eu.busi.ACAPizza.dataAccess.repository;


import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String username);


}
