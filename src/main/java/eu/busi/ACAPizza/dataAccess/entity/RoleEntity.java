package eu.busi.ACAPizza.dataAccess.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="role")
public class RoleEntity implements GrantedAuthority {

    @Id
    @Column(name = "role")
   private String role;

   @ManyToMany(mappedBy = "roles")
    Collection<UserEntity> users;

    public RoleEntity() {
    }


    @Override
    public String getAuthority() {
        return null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }
}
